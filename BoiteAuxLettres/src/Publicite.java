public class Publicite extends Courrier {

	double prix;
	
	Publicite(int poids, boolean isExpress, String adresse) {
		super(poids, isExpress, adresse);
		
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
		System.out.println("Pub");
		if (isNotValid) {
			System.out.println("(Courrier invalide)");
		}
		System.out.println("	Poids : " + poids + " grammes");
		System.out.println("	Express : " + isExpress());
		System.out.println("	Destination : " + adresse);
		System.out.println("	Prix : " + getPrix() + " euros ");
	}
	
	public double affranchirCourrier() {
		double montant=0;
		montant = 5*poids;
		if (isExpress) {
			montant = montant*2;
		}
		return montant/1000;
	}
}