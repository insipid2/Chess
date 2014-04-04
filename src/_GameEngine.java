import java.io.IOException;
import java.util.Scanner;

public class _GameEngine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// VARIABLES

		Board gameBoard;
		// BufferedReader input = new BufferedReader(new
		// InputStreamReader(System.in));
		Scanner input = new Scanner(System.in);
		boolean gameInProgress = true;
		String colorTurn = "b"; // b = black, w = white

		String tempInput = ""; // temporary storage for player input
		int tempInt = 0;
		char tempChar = 'a';
		boolean rowInputGood = false, colInputGood = false; // whether the
															// player input is
															// valid
		boolean validPiece = false;

		int curPieceX, curPieceY = 0;
		int curTargetX, curTargetY = 0;

		// ACTION!
		gameBoard = newGame();

		System.out
				.println("           Welcome to Super Battle Chess 2D VII!!!");
		System.out.println();
		gameBoard.display();

		while (gameInProgress) {
			System.out.println("Player " + colorTurn + "\'s turn.");
			System.out.println("Enter 1 to take turn, or 0 to concede game");
			
			
			

			// piece selection loop
			while (!validPiece) {
				
				// 
				while (!rowInputGood) {
					System.out.println("Player " + colorTurn + "\'s turn, choose a piece to move.");
					System.out.print("Enter the row number: ");
					tempInput = input.next();
					try {
						tempInt = rowInputToBoard(Integer.parseInt(tempInput));
						rowInputGood = true;
						
					} catch (NumberFormatException nfe) {
						System.out.println("  *dood. numbers only, 0 to 7");
					}

				}
				curPieceX = tempInt;
				

				while (!colInputGood) {
					System.out.println("Black's turn, choose a piece to move.");
					System.out.print("Enter the column number: ");
					tempInput = input.next();
					try {
						tempChar = tempInput.charAt(0);
						switch (tempChar) {
						case 'a':
						case 'b':
						case 'c':
						case 'd':
						case 'e':
						case 'f':
						case 'g':
						case 'h':
							colInputGood = true;
						}
					} catch (NumberFormatException nfe) {
						System.out.println("  *dood. letters only, a to h");
					}

				}
				curPieceY = Character.getNumericValue(tempChar);

			}

		}

	}

	// not sure if this will be used yet, or how
	private static boolean concedeGame(int input) {
		return input == 1;
	}

	// is the number from 0-7?
	private static boolean validRowColInput(int input) {
		return (input >= 0 && input <= 7);
	}

	// change the 7-0 numbers (corresponding to the board labels)
	// into the 0-7 numbers (corresponding to the board array)
	// the numbers flip, 0=7 , 1=6, ... 7=0
	private static int rowInputToBoard(int input) {
		return 7 - input;
	}

	// change the 0-7 numbers (corresponding to the board array)
	// into the 7-0 numbers (corresponding to the board labels, numbered in reverse)
	// the numbers flip, 0=7 , 1=6, ... 7=0
	private static int rowBoardToOutput(int input) {
		return 7 - input;
	}

	// change the a-h letters (corresponding to the board labels the players see)
	// into the 0-7 numbers (corresponding to the board array)
	// a=0 ... h=7
	private static int colInputToBoard(char input) {
		return Character.valueOf(input) - 97;
	}

	// change the 0-7 numbers (corresponding to the board array)
	// into letters a-h (corresponding to the board labels the players see)
	private static char colBoardToOutput(int input) {
		return (char) (input + 97);
	}
	
	// change an answer of 1 into a 'yes', other numbers are 'no'
	private static boolean continueToNext(int input) {
		return (input == 1);
	}
	
	// change string into 0 or 1, return -1 otherwise
	// use to process take turn, confirm piece, confirm destination questions
	private static int stringToOneZero (String input){
		int tempInt = Integer.parseInt(input);
		if (tempInt == 1 || tempInt == 0){
			return tempInt;
		}
		else{
			return -1;
		}
	}
	
	// check to see if the piece at row/col belongs to the specified team
	private boolean isMyPiece (int row, int col, int team, Board gameBoard){
		return (gameBoard.getPiece(row, col).team == team);
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
