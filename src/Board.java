
public class Board {
	
	Piece[][] gameboard = new Piece[8][8];
		
	
	Board(){
		
	}
	
	public void display(){
		
		
		System.out.println("  |------|------|------|------|------|------|------|------|");
		for(int i = 0; i <= 7; i++){
			
			System.out.print((7 - i) + " |");
			for(int j = 0; j < 8; j++){
				if(gameboard[i][j] == null){
					System.out.print("  ..  |");
				}
				else{
					System.out.print(" " + gameboard[i][j].toString() + " |");
				}
								
			}
			System.out.println();
			System.out.println("  |------|------|------|------|------|------|------|------|");			
		}
		System.out.println("      a      b      c      d      e      f      g      h");
		System.out.println();
		System.out.println();
		
	}
	
	public void addPiece(int x, int y, Piece gamePiece){
		gameboard[x][y] = gamePiece;
	}
	
	public void removePiece(int x, int y){
		gameboard[x][y] = null;
	}
	
	public Piece getPiece(int x, int y){
		return gameboard[x][y];
	}
}