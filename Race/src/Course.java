import java.util.ArrayList;

/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/

class Vehicule{
	String nom;
	double vitesseMax;
	int poids;
	int carburant;
	
	Vehicule(String nom, double vitesseMax, int poids, int carburant){
		this.nom = nom;
		this.vitesseMax = vitesseMax;
		this.poids = poids;
		this.carburant = carburant;
	}
	
	Vehicule(){
		nom = "Anonyme";
		carburant = 0;
		vitesseMax = 130;
		poids = 1000;
	}
	
	public String toString() {
		return nom + " ->  vitesse max = " + vitesseMax + " km/h, poids = " + poids + " kg";
	}
	
	public boolean meilleur(Vehicule autreVehicule) {
		return (this.vitesseMax > autreVehicule.vitesseMax) ? true : false;	
	}
	
	public String getNom() {
		return nom;
	}
	
	public double getVitesseMax() {
		return vitesseMax;
	}
	
	public int getPoids() {
		return poids;
	}
	
	public int getCarburant() {
		return carburant;
	}
	
	public boolean estDeuxRoues() {
		return false;
	}
}



class Voiture extends Vehicule{
	
	String categorie;
	
	Voiture(String nom, double vitesseMax, int poids, int carburant, String categorie){
		super( nom,  vitesseMax, poids, carburant);
		this.categorie = categorie;
	}
	
	public String toString() {
		return nom + " ->  vitesse max = " + vitesseMax + " km/h, poids = " + poids + " kg, Voiture de " + categorie;
	}
	
	public String getCategorie() {
		return categorie;
	}
	
	public boolean estDeuxRoues() {
		return false;
	}
}

class Moto extends Vehicule{
	
	boolean hasSideCar;
	
	Moto(String nom, double vitesseMax, int poids, int carburant){
		super( nom,  vitesseMax, poids, carburant);
	}
	
	Moto(String nom, double vitesseMax, int poids, int carburant, boolean hasSideCar){
		super( nom,  vitesseMax, poids, carburant);
		this.hasSideCar = hasSideCar;
	}
	
	public String toString() {
		String str = "";
		if (hasSideCar) {
			 str = ", avec sidecar";
		}
		return nom + " ->  vitesse max = " + vitesseMax + " km/h, poids = " + poids + " kg, Moto" + str;
	}
	
	public boolean estDeuxRoues() {
		return (hasSideCar) ? false : true;
	}
}


abstract class Rallye{
	
	public abstract boolean check();
	
}

class GrandPrix extends Rallye{
	
	ArrayList<Vehicule> collection;
	
	GrandPrix(){
		collection = new ArrayList<Vehicule>();
	}
	
	
	public boolean check() {
		if (collection.size() == 0)
			return true;
		if (collection.get(0).estDeuxRoues()) {
			for (Vehicule vehicule : collection) {
				if (!vehicule.estDeuxRoues()) {
					return false;
				}
			}	
		}
		else {
			for (Vehicule vehicule : collection) {
				if (vehicule.estDeuxRoues()) {
					return false;
				}
			}
		}
		return true;
	}
	
	public void ajouter(Vehicule vehicule)  {
		collection.add(vehicule);
	}
	
	public void add(Vehicule vehicule) {
		if (vehicule != null) {
			collection.add(vehicule);
		}
	}
	
	public void run(int tours) {
		Vehicule vehiculeGagnant = new Vehicule();
		ArrayList<Vehicule> ligneArrivée = new ArrayList<Vehicule>();
		int vehicule = 0;
		if (!check()) {
			System.out.println("Pas de Grand Prix");
		}
		else {
			for (Vehicule vehiculeAuDepart : collection) {
				vehiculeAuDepart.carburant -= tours;
				if (vehiculeAuDepart.carburant > 0) {
					ligneArrivée.add(vehiculeAuDepart);
				}
			}
			
			if (ligneArrivée.size() == 0) {
				System.out.println("Elimination de tous les véhicules");
				return;
			}
				
			while (vehicule < ligneArrivée.size() - 1) {
				if (ligneArrivée.get(vehicule).meilleur(ligneArrivée.get(vehicule+1))) {
					vehiculeGagnant = ligneArrivée.get(vehicule);
				}
				else {
					vehiculeGagnant = ligneArrivée.get(vehicule+1);
				}
				vehicule++;
			}
			System.out.println("Le gagant du grand prix est :");
			System.out.println(vehiculeGagnant.toString());
			}
		}
	}

/*******************************************
 * Ne pas modifier apres cette ligne
 * pour pr'eserver les fonctionnalit'es et
 * le jeu de test fourni.
 * Votre programme sera test'e avec d'autres
 * donn'ees.
 *******************************************/
public class Course {

    public static void main(String[] args) {

        // PARTIE 1
        System.out.println("Test partie 1 : ");
        System.out.println("----------------");
        Vehicule v0 = new Vehicule();
        System.out.println(v0);

        // les arguments du constructeurs sont dans l'ordre:
        // le nom, la vitesse, le poids, le carburant
        Vehicule v1 = new Vehicule("Ferrari", 300.0, 800, 30);
        Vehicule v2 = new Vehicule("Renault Clio", 180.0, 1000, 20);
        System.out.println();
        System.out.println(v1);
        System.out.println();
        System.out.println(v2);

        if (v1.meilleur(v2)) {
            System.out.println("Le premier vehicule est meilleur que le second");
        } else {
            System.out.println("Le second vehicule est meilleur que le premier");
        }
        // FIN PARTIE 1

        // PARTIE2
        System.out.println();
        System.out.println("Test partie 2 : ");
        System.out.println("----------------");

        // les trois premiers arguments sont dans l'ordre:
        // le nom, la vitesse, le poids, le carburant
        // le dernier argument indique la presence d'un sidecar
        Moto m1 = new Moto("Honda", 200.0, 250, 15, true);
        Moto m2 = new Moto("Kawasaki", 280.0, 180, 10);
        System.out.println(m1);
        System.out.println();
        System.out.println(m2);
        System.out.println();

        // les trois premiers arguments sont dans l'ordre:
        // le nom, la vitesse, le poids, le carburant
        // le dernier argument indique la categorie
        Voiture vt1 = new Voiture("Lamborghini", 320, 1200, 40, "course");
        Voiture vt2 = new Voiture("BMW", 190, 2000, 35, "tourisme");
        System.out.println(vt1);
        System.out.println();
        System.out.println(vt2);
        System.out.println();
        // FIN PARTIE 2

        // PARTIE 3
        System.out.println();
        System.out.println("Test partie 3 : ");
        System.out.println("----------------");

        GrandPrix gp1 = new GrandPrix();
        gp1.ajouter(v1);
        gp1.ajouter(v2);
        System.out.println(gp1.check());
        

        GrandPrix gp2 = new GrandPrix();
        gp2.ajouter(vt1);
        gp2.ajouter(vt2);
        gp2.ajouter(m2);
        System.out.println(gp2.check());

        GrandPrix gp3 = new GrandPrix();
        gp3.ajouter(vt1);
        gp3.ajouter(vt2);
        gp3.ajouter(m1);
        System.out.println(gp3.check());

        GrandPrix gp4 = new GrandPrix();
        gp4.ajouter(m1);
        gp4.ajouter(m2);
        System.out.println(gp4.check());
        // FIN PARTIE 3

        // PARTIE 4
        System.out.println();
        System.out.println("Test partie 4 : ");
        System.out.println("----------------");
        GrandPrix gp5 = new GrandPrix();
        gp5.ajouter(vt1);
        gp5.ajouter(vt2);

        System.out.println("Premiere course :");
        gp5.run(11);
        System.out.println();

        System.out.println("Deuxieme  course :");
        gp3.run(40);
        System.out.println();

        System.out.println("Troisieme  course :");
        gp2.run(11);
        // FIN PARTIE 4
    }
}
