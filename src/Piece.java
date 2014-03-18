
public abstract class Piece {
	// 0 = black, 1 = white	
	int team;
	
	public Piece(int team){
		this.team = team;
	}
	
	public abstract String[] checkMovement();
	
}
