
public class _GameEngine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Board tester;
		tester = newGame();
		tester.display();
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
