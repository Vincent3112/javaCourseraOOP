import java.util.ArrayList;

public class Boite {

private ArrayList<Courrier> listeCourrier;
	
	public Boite(int nbPersonnes) {
		listeCourrier = new ArrayList<Courrier>();
	}
	
	public void ajouterCourrier(Courrier courrier)
	{
	if (courrier != null)
	{
	listeCourrier.add(courrier);
	}
	}
	
	
	
	public double affranchir() {
		double montantTotal = 0;
		for (Courrier courrier : listeCourrier) {
			montantTotal += courrier.affranchirCourrier();
		}
		return montantTotal;
	}
	
	public void afficher() {
		for (Courrier courrier : listeCourrier) {
			courrier.afficher();
		}
	}
	
	public int courriersInvalides() {
		int	nbrCourrierInvalide = 0;
		for (Courrier courrier : listeCourrier) {
			if (courrier.isNotValid == true) {
				nbrCourrierInvalide +=1;
			}
		}
		return nbrCourrierInvalide;
		}
}
