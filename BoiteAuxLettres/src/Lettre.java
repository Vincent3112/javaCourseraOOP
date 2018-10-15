
public class Lettre extends Courrier{

	
	String format;
	double prix = 0;
	
	Lettre(int poids, boolean isExpress, String adresse, String format) {
		super(poids, isExpress, adresse);
		this.format = format;
		
		if (adresse == "") {
			isNotValid = true;
		}
	}
	
	public double getPrix() {
		if (isNotValid) {
			return prix;
		}
		else {
			return affranchirCourrier();
		}
	}
	
	
	public void afficher() {
		System.out.println("Lettre");
		if (isNotValid) {
			System.out.println("(Courrier invalide)");
		}
		System.out.println("	Poids : " + poids + " grammes ");
		System.out.println("	Express : " + isExpress());
		System.out.println("	Destination : " + adresse);
		System.out.println("	Prix : " + getPrix() + " euros ");
		System.out.println("	Format : " + format);
	}
	
	public double affranchirCourrier() {
		double prix=0;
		if (format == "A4") {
			prix = 2.5 + poids;
		}
		else {
			prix = 3.5 + poids;
		}
		if (isExpress) {
			prix = prix*2;
		}
		
		return prix/1000;
	}
	
	
}
