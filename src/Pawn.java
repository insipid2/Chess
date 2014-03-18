
public class Pawn extends Piece{
	
	
	public Pawn(int team){
		super(team);
	}

	@Override
	public String[] checkMovement() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString(){
		if (team == 0){
			return "PWNb";
		}
		else{
			return "PWNw";
		}
	}
	
}
