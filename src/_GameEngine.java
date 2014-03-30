import java.io.IOException;
import java.util.Scanner;


public class _GameEngine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// VARIABLES, SET UP
		
		Board gameBoard;
		// BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		Scanner input = new Scanner(System.in);
		boolean gameInProgress = true;
		int colorTurn = 0;  // 0 = black, 1 = white
		
		String tempInput = "";  // temporary storage for player input
		int tempInt = 0;
		char tempChar = 'a';
		boolean rowInputGood = false, colInputGood = false; // whether the player input is valid
		boolean validPiece = false;
		
		int curPieceX, curPieceY = 0;
		int curTargetX, curTargetY = 0;
		
		
		// ACTION!
		gameBoard = newGame();
		
		System.out.println("           Welcome to Super Battle Chess 2D VII!!!");
		System.out.println();
		gameBoard.display();
		
		while(gameInProgress){
			// black's turn
			if(colorTurn == 0){
				while(!validPiece){
					while(!rowInputGood){					
						System.out.println("Black's turn, choose a piece to move.");
						System.out.print("Enter the row number: ");
						tempInput = input.next();
						try{
							tempInt = Integer.parseInt(tempInput);
							if(tempInt >= 0 || tempInt < 8){
								rowInputGood = true;
							}
						}
						catch(NumberFormatException nfe){
							System.out.println("  *dood. numbers only, 0 to 7");
						}		
							
						
					}
					curPieceX = tempInt;
					
					while(!colInputGood){					
						System.out.println("Black's turn, choose a piece to move.");
						System.out.print("Enter the column number: ");
						tempInput = input.next();
						try{
							tempChar = tempInput.charAt(0);
							switch(tempChar){
							case 'a': case 'b': case 'c':
							case 'd': case 'e': case 'f':
							case 'g': case 'h':
								colInputGood = true;
							}
						}
						catch(NumberFormatException nfe){
							System.out.println("  *dood. letters only, a to h");
						}		
							
						
					}
					curPieceY = Character.getNumericValue(tempChar);					
					
				}
				
				
				
			}

		}
			
	}
	
	private static boolean concedeGame(Scanner input){
		System.out.println("Would you like to make a move, or concede the game?");
		System.out.print("Enter 1 to take turn, or 0 to concede game: ");
		int concede = Integer.parseInt(input.next());
		if(concede == 1){
			return false;
		}
		else{
			return true;
		}
	}
	
	private static Board newGame(){
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
		for(int i = 0; i < 8; i++){
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
		for(int i = 0; i < 8; i++){
			temp = new Pawn(1);
			chessBoard.addPiece(6, i, temp);
		}
		
		return chessBoard;
	}

}
