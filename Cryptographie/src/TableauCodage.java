import java.util.ArrayList;

public class TableauCodage {

	public ArrayList<Integer> cleCodage;
	
	
	TableauCodage(int nbrCharacteres) {
		cleCodage = new ArrayList<Integer>();
	}
	
	public void add(Integer integer) {
		if (integer != 0)
		{
			cleCodage.add(integer);
		}
	}
	
	
	
	public int get(int unInt) {
		return cleCodage.get(unInt);
	}
	
	public void getTableau() {
		for (int i = 0; i < cleCodage.size(); i++) {
			System.out.print(cleCodage.get(i) + ", ");
		}
	}

	

	
}
