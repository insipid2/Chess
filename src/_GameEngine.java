import java.util.Scanner;

public class _GameEngine {

    /**
     * @param args
     */
    public static void main(String[] args) {

        // VARIABLES
        Board gameBoard = null;
        Scanner input = new Scanner(System.in);
        boolean hasPotentialDesire = true;		

        String tempInput = ""; // temporary storage for player input
        boolean invalidInput = false;

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



        while (hasPotentialDesire) {
        
            // 0 - Program Start
            // Want to start a new game?
            if(gameState == 0){
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
                    printInvalidInput();
                }
            }
            
            // 1 - Beginning of turn
            // Play or concede?
            if (gameState == 1){
                clearScreen();
                gameBoard.display();
                if(invalidInput){
                    invalidInput = false;
                    printInvalidInput();
                }
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
            
            if (gameState == 2){
                clearScreen();
                gameBoard.display();
                printHeader(colorTurn, gameState);
                System.out.print("Enter the row number: (0-7) ");
            }
            

            //System.out.println("           Welcome to Super Battle Chess 2D VII!!!");


        }

        System.out.println("GAME OVER");
    }




    
    
    //Invalid input, let the player know
    private static void printInvalidInput(){
        System.out.println("Ouch, what do you do?");
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
