
public class Rook extends Piece{

	public Rook(int team) {
		super(team);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String[] checkMovement() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString(){
		if (team == 0){
			return "ROKb";
		}
		else{
			return "ROKw";
		}
	}

}
