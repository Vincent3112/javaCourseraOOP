import java.util.ArrayList;
import java.util.Random;

public class ACleAleatoire extends ACle {

	int longueur; 
	
	
	ACleAleatoire(int longueur){
		this.longueur = longueur;
		nom = "Clé aléatoire";
		genereCle();
		
		
	}	
	
	public void genereCle() {
		
		ArrayList<String> cleGenere = new ArrayList<String>();
		char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		for (int i = 0 ; i < longueur; i++) {
			Random r = new Random();
			int val = r.nextInt();
			val = Math.abs(val);
			val = val % 25;
			val += 1;			
			cleGenere.add(Character.toString(alphabet[val]));
			String laCle = String.join("",  cleGenere);
			clé = laCle;
			//System.out.println(laCle);
		}
		
	}
	
	
		
	
}
