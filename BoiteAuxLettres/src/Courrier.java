
public abstract class Courrier {

	int poids;
	boolean isExpress;
	String adresse;
	boolean isNotValid;
	
	Courrier(int poids, boolean isExpress, String adresse) {
		this.poids = poids;
		this.isExpress = isExpress;
		this.adresse = adresse;
		boolean isNotValid = false;
		if (adresse == "") {
			isNotValid = true;
		}		
	}
	
	public String isExpress() {
		if (isExpress) {
			return "oui";
		}
		else {
			return "non";
		}
	}
	public abstract double affranchirCourrier();
	

	public void afficher() {
		}
}