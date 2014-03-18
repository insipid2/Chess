
public class King extends Piece{

	King(int team){
		super(team);
	}
	
	@Override
	public String[] checkMovement(){
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString(){
		if (team == 0){
			return "KNGb";
		}
		else{
			return "KNGw";
		}
	}

}
