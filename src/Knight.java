
public class Knight extends Piece {

	public Knight(int team) {
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
			return "KNTb";
		}
		else{
			return "KNTw";
		}
	}

}
