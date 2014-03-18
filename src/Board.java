
public class Board {
	
	Piece[][] gameboard = new Piece[8][8];
	
	
	Board(){
		
	}
	
	public void display(){
		
		
		System.out.println("|------|------|------|------|------|------|------|------|");
		for(int i = 0; i < 8; i++){
			
			System.out.print("|");
			for(int j = 0; j < 8; j++){
				
				System.out.print(" " + gameboard[i][j] + " |");
				
			}
			System.out.println();
			System.out.println("|------|------|------|------|------|------|------|------|");
		}
		
	}
}