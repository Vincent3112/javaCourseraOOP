public class Colis extends Courrier{

	double volume;
	double prix;
	
	Colis(int poids, boolean isExpress, String adresse, int volume) {
		super(poids, isExpress, adresse);
		this.volume = volume;
		if (adresse == "") {
			isNotValid = true;
		}
		if (volume > 50) {
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
		System.out.println("Colis");
		if (isNotValid) {
			System.out.println("(Courrier invalide)");
		}
		System.out.println("	Poids : " + poids + " grammes ");
		System.out.println("	Express : " + isExpress());
		System.out.println("	Destination : " + adresse);
		System.out.println("	Prix : " + getPrix() + " euros ");
		System.out.println("	Volume : " + volume);
	}
	
	public double affranchirCourrier() {
		double montant=0;
		montant = 0.5*volume + poids;
		if (isExpress) {
			montant = montant*2;
		}
		return montant/1000;
	}
}