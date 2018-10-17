import java.util.ArrayList;

public class Cesar extends ACle {

	int crans; 
	
	Cesar(String nom, int crans) {
		this.crans = crans;
		this.nom = nom;
		genereCle();
	}
	
	public void affiche() {
		System.out.println(nom + " à " + crans + " crans");
	}
	
	public void genereCle() {
		
		String cleGenere;
		char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();		
			cleGenere = Character.toString(alphabet[crans - 1]);
			clé = cleGenere;
	}
}