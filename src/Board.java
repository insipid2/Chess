
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
	
	// add given piece to x, y in array
	public void addPiece(int x, int y, Piece gamePiece){
		gameboard[x][y] = gamePiece;
	}
	
	// delete piece at given x, y
	public void removePiece(int x, int y){
		gameboard[x][y] = null;
	}
	
	// return piece at specified x, y
	public Piece getPiece(int x, int y){
		return gameboard[x][y];
	}
	
	// move piece at specified start x, y
	// to specified destination x, y
	public void movePiece(int startx, int starty, int destx, int desty){
	    gameboard[destx][desty] = gameboard[startx][starty];
	    removePiece(startx, starty);
	}
}