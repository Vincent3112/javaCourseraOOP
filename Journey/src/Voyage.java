import java.util.ArrayList;

/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/

class OptionVoyage{
	
	protected String nom;
	protected double prixForfaitaire;
	
	OptionVoyage(String nom, double prixForfaitaire){
		this.nom = nom;
		this.prixForfaitaire = prixForfaitaire;
	}
	
	OptionVoyage() {
		
	}
	
	
	public String getNom() {
		return nom;
	}
	
	public double prix() {
		return prixForfaitaire;
	}
	
	public String toString() {
		return nom + " -> " + prix() + " CHF";
	}
}

class Transport extends OptionVoyage{
	
	boolean islong;
	public double TARIF_LONG = 1500;
	public double TARIF_BASE = 200;
	
	
	Transport(String nom, double prixForfaitaire, boolean islong){
		super(nom, prixForfaitaire);
		this.islong = islong;
	
	}
	
	Transport(String nom, double prixForfaitaire){
		super(nom, prixForfaitaire);
		islong = false;
	}
	
	public double prix() {
		if (islong == true) {
			return TARIF_LONG + prixForfaitaire;
		}
		else {
			return TARIF_BASE + prixForfaitaire;
		}
	}
}

class Sejour extends OptionVoyage{
	
	int nbrNuit;
	double prixNuit;
	
	Sejour(String nom, double prixForfaitaire, int nbrNuit, double prixNuit){
		super(nom, prixForfaitaire);
		this.nbrNuit = nbrNuit;
		this.prixNuit = prixNuit;		
	}
	
	public double prix() {
		return nbrNuit * prixNuit + prixForfaitaire;
	}
	
	
}

class KitVoyage{
	
	String départ;
	String destination;
	ArrayList<OptionVoyage> collection;
	
	KitVoyage(String départ, String destination){
		this.départ = départ;
		this.destination = destination;
		collection = new ArrayList<OptionVoyage>();
	}
	
	public double prix() {
		double prixTotal = 0;
		for (OptionVoyage optionvoyage : collection) {
			prixTotal += optionvoyage.prix();
		}
		return prixTotal;
	}
	
	public String toString() {
		System.out.println("Voyage de " + départ + " à " + destination + ", avec pour options :");
		for (OptionVoyage optionvoyage : collection) {
			System.out.println("- " + optionvoyage.nom + " -> " + optionvoyage.prix() + " CHF");
		}
		return "Prix total : " + prix();
	}
	
	public void ajouterOption(OptionVoyage optionvoyage) {
		collection.add(optionvoyage);
	}
	
	public void annuler() {
		collection.clear();
	}
	
	
	public int getNbOptions() {
		return collection.size();
	}
	
	
	
	
	
	
}
/*******************************************
 * Ne pas modifier apres cette ligne
 * pour pr'eserver les fonctionnalit'es et
 * le jeu de test fourni.
 * Votre programme sera test'e avec d'autres
 * donn'ees.
 *******************************************/

public class Voyage {
    public static void main(String args[]) {

        // TEST 1
        System.out.println("Test partie 1 : ");
        System.out.println("----------------");
        OptionVoyage option1 = new OptionVoyage("Séjour au camping", 40.0);
        System.out.println(option1.toString());

        OptionVoyage option2 = new OptionVoyage("Visite guidée : London by night" , 50.0);
        System.out.println(option2.toString());
        System.out.println();

        // FIN TEST 1


        // TEST 2
        System.out.println("Test partie 2 : ");
        System.out.println("----------------");

        Transport transp1 = new Transport("Trajet en car ", 50.0);
        System.out.println(transp1.toString());

        Transport transp2 = new Transport("Croisière", 1300.0);
        System.out.println(transp2.toString());

        Sejour sejour1 = new Sejour("Camping les flots bleus", 20.0, 10, 30.0);
        System.out.println(sejour1.toString());
        System.out.println();

        // FIN TEST 2


        // TEST 3
        System.out.println("Test partie 3 : ");
        System.out.println("----------------");

        KitVoyage kit1 = new KitVoyage("Zurich", "Paris");
        kit1.ajouterOption(new Transport("Trajet en train", 50.0));
        kit1.ajouterOption(new Sejour("Hotel 3* : Les amandiers ", 40.0, 5, 100.0));
        System.out.println(kit1.toString());
        System.out.println();
        kit1.annuler();

        KitVoyage kit2 = new KitVoyage("Zurich", "New York");
        kit2.ajouterOption(new Transport("Trajet en avion", 50.0, true));
        kit2.ajouterOption(new Sejour("Hotel 4* : Ambassador Plazza  ", 100.0, 2, 250.0));
        System.out.println(kit2.toString());
        kit2.annuler();

        // FIN TEST 3
    }
}

