import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class _GameEngine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Board gameBoard;
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		boolean gameInProgress = true;
		int colorTurn = 0;  // 0 = black, 1 = white
		int curPieceX = 0, curPieceY = 0;
		int curTargetX = 0, curTargetY = 0;
		
		
		gameBoard = newGame();
		
		System.out.println("         Welcome to Super Battle Chess 2D VII!!!");
		System.out.println();
		gameBoard.display();
		
		while(gameInProgress){
			// black's turn
			if(colorTurn == 0){
				System.out.println("Black's turn.");
				System.out.println("Choose a piece to move.");
				System.out.print("Enter the row number: ");
				try{
					curPieceX = input.read();
		        }catch(IOException e){
		            System.err.println("Invalid Format!");
		        }
				System.out.println();
				System.out.print("Enter the colum letter: ");
				try{
					curPieceY = input.read();
		        }catch(IOException e){
		            System.err.println("Invalid Format!");
		        }
				System.out.println();
				
			}
			// white's turn
			else{
				System.out.println("White's turn.");
				System.out.println("Choose a piece to move.");
				System.out.print("Enter the row number: ");
				try{
					curPieceX = input.read();
		        }catch(IOException e){
		            System.err.println("Invalid Format!");
		        }
				System.out.println();
				System.out.print("Enter the colum letter: ");
				try{
					curPieceY = input.read();
		        }catch(IOException e){
		            System.err.println("Invalid Format!");
		        }
				System.out.println();
				
			}
			
		}
		
		
		
		
	}
	
	public static Board newGame(){
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
