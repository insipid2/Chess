import java.util.Scanner;

public class _GameEngine {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ///////////////
        // VARIABLES //
        ///////////////
        Board gameBoard = null;
        Scanner input = new Scanner(System.in);
        boolean hasPotentialDesire = true;		

        String tempInput = "";          // temporary storage for player input
        boolean invalidInput = false;   // flag for whether there has been valid input
        int inputRowInt = 0;            // stores row input from player
        char inputColChar = ' ';        // stores column input from player
        int arrayRowInt = 0;            // stores row number corresponding to game board array
        int arrayColInt = 0;            // stores column number corresponding to game board array
        Piece mySelectedPiece;          // stores the piece the player has chosen to move

        // Game State, whose turn is it?
        String colorTurn = "Black";

        // Turn State, where are they in choosing their move?
        // State 0 - no game in progress, start new game?
        // State 1 - Turn start, take turn or concede?
        // State 2 - Piece selection - ROW
        // State 3 - Piece selection - COLUMN
        // State 4 - Piece selection - Confirm?
        // State 5 - Destination selection - ROW
        // State 6 - Destination selection - COLUMN
        // State 7 - Destination selection - Confirm?
        // State 8 - Update Board, end turn
        int gameState = 0;


        //////////////////////
        // USER INTERACTION //
        //////////////////////
        while (hasPotentialDesire) {
        
            // 0 - Program Start
            // Want to start a new game?
            if(gameState == 0){
                invalidInput = printInvalidInput(invalidInput);
                System.out.println("How about a nice game of Chess?");
                System.out.println("Enter 1 for new game, 0 to exit.");
                tempInput = input.next();
                
                if(tempInput.equals("0")){
                    System.out.println("You cannot lose if you do not play.");
                    System.exit(0);
                }
                else if(tempInput.equals("1")){
                    // Create the Game Board
                    gameBoard = newGame();
                    gameState++;
                }
                else{
                    invalidInput = true;
                }
            }
            
            // 1 - Beginning of turn
            // Play or concede?
            if(gameState == 1){
                clearScreen();
                gameBoard.display();
                invalidInput = printInvalidInput(invalidInput);
                printHeader(colorTurn, gameState);
                System.out.print("Enter 1 to take turn, or 0 to concede: ");
                tempInput = input.next();
                
                if(tempInput.equals("0")){
                    System.out.println();
                    System.out.println(colorTurn + " forfeits the game.");
                    System.out.println();
                    gameState--;
                }
                else if(tempInput.equals("1")){
                    gameState++;
                }
                else{
                    invalidInput = true;
                }
            }
            
            // 2 - Piece Selection, Row
            if(gameState == 2){
                clearScreen();                
                gameBoard.display();
                invalidInput = printInvalidInput(invalidInput);
                printHeader(colorTurn, gameState);
                System.out.print("Enter the row number: (0-7) ");
                tempInput = input.next();
                
                try{
                    inputRowInt = Integer.parseInt(tempInput);
                }
                catch(NumberFormatException nfe){
                    invalidInput = true;
                    inputRowInt = -1;
                }
                
                if(inputRowInt >= 0 && inputRowInt <= 7){
                    gameState++;
                }
                else{
                    invalidInput = true;
                }
                
            }
            
            // 3 - Piece Selection, Column
            if(gameState == 3){
                clearScreen();                
                gameBoard.display();
                invalidInput = printInvalidInput(invalidInput);
                printHeader(colorTurn, gameState);
                System.out.println("Row " + inputRowInt + " selected");
                System.out.print("Enter the column letter: (a-h) ");
                tempInput = input.next();
                
                if(tempInput.length() == 1){
                    switch(tempInput.charAt(0)){
                        case 'a': case 'b': case 'c': case 'd':
                        case 'e': case 'f': case 'g': case 'h':
                            inputColChar = tempInput.charAt(0);
                            gameState++;
                        default:
                            invalidInput = true;
                    }
                }
                else{
                    invalidInput = true;
                }                
            }
            
            // 4 - Piece Selection, confirm
            if(gameState == 4){
                arrayRowInt = rowUItoArray(inputRowInt);
                arrayColInt = colUItoArray(inputColChar);
                clearScreen();                
                gameBoard.display();
                invalidInput = printInvalidInput(invalidInput);
                printHeader(colorTurn, gameState);
                System.out.println(gameBoard.getPiece(arrayRowInt, arrayColInt).toString() + " at " + inputRowInt + " - " + inputColChar + " selected");
                if (isMyPiece(gameBoard, arrayRowInt, arrayColInt, colorTurn)){
                    System.out.println("Congratulations.  You have successfully chosen one of your pieces.");
                    System.out.println("Is this the piece you would like to move?");
                    System.out.println("Enter 1 to confirm piece selection, enter 0 to cancel");
                    tempInput = input.next();
                    
                    if(tempInput.equals("0")){
                        gameState = gameState - 2;
                    }
                    else if(tempInput.equals("1")){
                        gameState++;
                        mySelectedPiece = gameBoard.getPiece(arrayRowInt, arrayColInt);                        
                    }
                    else{
                        invalidInput = true;
                    }
                }
                else{
                    invalidInput = true;
                    gameState = gameState - 2;
                }
            }
            
            // 5 - break here to test
            if(gameState == 5){
                System.out.println("piece chosen?");
                System.exit(0);
            }
            

            // System.out.println("           Welcome to Super Battle Chess 2D VII!!!");


        }

        System.out.println("GAME OVER");
    }




    // check if the space at row, column (array) in the given board contains a piece belonging to specified color
    private static boolean isMyPiece (Board gameBoard, int row, int col, String sTeam){
        int iTeam = -1;
        Piece tempPiece = gameBoard.getPiece(row, col);
        int tempTeam = tempPiece.team;
        if (sTeam.toLowerCase().equals("black")){
            iTeam = 0;
        }
        else if (sTeam.toLowerCase().equals("white")){
            iTeam = 1;
        }
        return (iTeam == tempTeam);
    }
    
    // convert pre-validated row number from player input to internal array number
    private static int rowUItoArray(int input){
        return 7 - input;
    }
    
 // convert row number from internal array number to player input
    private static int rowArraytoUI(int input){
        return 7 - input;
    }
    
    // convert pre-validated column character from player input to internal array number
    private static int colUItoArray(char input){
        switch (input){
            case 'a': return 0;
            case 'b': return 1;
            case 'c': return 2;
            case 'd': return 3;
            case 'e': return 4;
            case 'f': return 5;
            case 'g': return 6;
            case 'h': return 7;
            default: return -1;        
        }
    }
    
 // convert pre-validated column character from internal array number to UI 
    private static char colArraytoUI(int input){
        switch (input){
            case 0: return 'a';
            case 1: return 'b';
            case 2: return 'c';
            case 3: return 'd';
            case 4: return 'e';
            case 5: return 'f';
            case 6: return 'g';
            case 7: return 'h';
            default: return ' ';        
        }
    }
    
    // if input is invalid, let the player know
    private static boolean printInvalidInput(boolean invalidInput){
        
        if(invalidInput){
            System.out.println("Ouch, what do you do?");            
        }        
        return false;
    }
    
    // Displays whose turn it is, and 
    // whether they are in the process of choosing a piece or a destination
    private static void printHeader(String colorTurn, int turnState){
        System.out.println(colorTurn + "\'s turn.");
        // Turn State, where are they in choosing their move?
        // State 0 - no game in progress, start new game?
        // State 1 - Turn start, take turn or concede?
        // State 2 - Piece selection - ROW
        // State 3 - Piece selection - COLUMN
        // State 4 - Piece selection - Confirm?
        // State 5 - Destination selection - ROW
        // State 6 - Destination selection - COLUMN
        // State 7 - Destination selection - Confirm?
        // State 8 - Update Board, end turn
        if(turnState == 2 || turnState == 3 || turnState == 4){
            System.out.println("Select which Piece to move");
        }
        else if(turnState == 5 || turnState == 6 || turnState == 7){
            System.out.println("Select where to move the Piece");
        }
    }
    
    private static void clearScreen(){
        /*try{
			Runtime.getRuntime().exec("cls");
		}
		catch(Exception e){

		} */

        // temp solution!
        System.out.println("***SCREEN REFRESH***");
        System.out.println();

    }

    // create and return a new board object with the 
    // game pieces in the starting position
    private static Board newGame() {
        Board chessBoard = new Board();
        Piece temp;

        // BLACK (0) - placing pieces
        temp = new Rook(0);
        chessBoard.addPiece(0, 0, temp);
        temp = new Knight(0);
        chessBoard.addPiece(0, 1, temp);
        temp = new Bishop(0);
        chessBoard.addPiece(0, 2, temp);
        temp = new Queen(0);
        chessBoard.addPiece(0, 3, temp);
        temp = new King(0);
        chessBoard.addPiece(0, 4, temp);
        temp = new Bishop(0);
        chessBoard.addPiece(0, 5, temp);
        temp = new Knight(0);
        chessBoard.addPiece(0, 6, temp);
        temp = new Rook(0);
        chessBoard.addPiece(0, 7, temp);
        for (int i = 0; i < 8; i++) {
            temp = new Pawn(0);
            chessBoard.addPiece(1, i, temp);
        }

        // WHITE (1) - placing pieces
        temp = new Rook(1);
        chessBoard.addPiece(7, 0, temp);
        temp = new Knight(1);
        chessBoard.addPiece(7, 1, temp);
        temp = new Bishop(1);
        chessBoard.addPiece(7, 2, temp);
        temp = new Queen(1);
        chessBoard.addPiece(7, 3, temp);
        temp = new King(1);
        chessBoard.addPiece(7, 4, temp);
        temp = new Bishop(1);
        chessBoard.addPiece(7, 5, temp);
        temp = new Knight(1);
        chessBoard.addPiece(7, 6, temp);
        temp = new Rook(1);
        chessBoard.addPiece(7, 7, temp);
        for (int i = 0; i < 8; i++) {
            temp = new Pawn(1);
            chessBoard.addPiece(6, i, temp);
        }

        return chessBoard;
    }

}
