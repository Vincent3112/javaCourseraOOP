import java.util.ArrayList;

abstract class Employe{
	
	protected String nom;
	protected String prenom;
	protected int age;
	protected String dateEntree;
	
	abstract double calculerSalaire();
	
	abstract String getNom();
	
	Employe(String prenom, String nom,int age, String dateEntree ){
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.dateEntree = dateEntree;
	}
	
	
	
}

class Vendeur extends Employe{
	
	private static int CA;
	static double partVariable = 0.2*CA;
	static double partFixe = 400;
	
	public double calculerSalaire() {
		return partVariable + partFixe;
	}
	
	public String getNom() {
		return "L'employé " + prenom + nom;
	}
	
	Vendeur(String nom, String prenom,int age, String dateEntree, int CA){
		super( nom, prenom,age, dateEntree);
		this.CA = CA;
	}
}

class Representant extends Employe{
	
	int CA; 
	
	public double calculerSalaire() {
		return 0.2*CA + 800;
	}
	
	public String getNom() {
		return "L'employé " + prenom + nom;
	}
	
	Representant(String nom, String prenom,int age, String dateEntree, int CA){
		super( nom, prenom,age, dateEntree);
		this.CA = CA;
	}
}

class Technicien extends Employe{
	
	int units; 
	
	public double calculerSalaire() {
		return 5*units;
	}
	
	public String getNom() {
		return "L'employé " + prenom + nom;
	}
	
	Technicien(String nom, String prenom,int age, String dateEntree, int units){
		super( nom, prenom,age, dateEntree);
		this.units = units;
	}
	
	
}


class Manutentionnaire extends Employe{
	
	int hours; 
	
	public double calculerSalaire() {
		return 65*hours;
	}
	
	public String getNom() {
		return "L'employé " + prenom + nom;
	}
	
	Manutentionnaire(String nom, String prenom,int age, String dateEntree, int hours){
		super( nom, prenom,age, dateEntree);
		this.hours = hours;
	}
	
	
	
}

class ManutARisque extends Manutentionnaire implements employeARisque{
	
	
	
	ManutARisque(String nom, String prenom,int age, String dateEntree, int hours){
		super( nom, prenom,age, dateEntree, hours);
	}
	
	public double calculerSalaire() {
		return 65*hours + primeMensuelle;
	}
}

class TechnARisque extends Technicien implements employeARisque{
	
	
	
	TechnARisque(String nom, String prenom,int age, String dateEntree, int hours){
		super( nom, prenom,age, dateEntree, hours);
	}
	
	public double calculerSalaire() {
		return 5*units + primeMensuelle;
	}
}

interface employeARisque{
	
	final double primeMensuelle = 200;
}

class Personnel{
	
	ArrayList<Employe> listeEmploye;
	
	Personnel(){
		listeEmploye = new ArrayList<Employe>();
	}
	
	public void ajouterEmploye(Employe nouvelEmploye) {
		listeEmploye.add(nouvelEmploye);
	}
	
	public void afficherSalaires() {
		for (Employe employe : listeEmploye) {
			System.out.println(employe.getNom() + " gagne " + employe.calculerSalaire() + " francs.");
		}
	}
	
	public double salaireMoyen() {
		int numeroEmploye = 0;
		double salaireMoyen = 0;
		while (numeroEmploye < listeEmploye.size()) {
			for (Employe employe : listeEmploye) {
				salaireMoyen += employe.calculerSalaire();
				numeroEmploye++;
			}
		}
		return salaireMoyen/listeEmploye.size();
	}
	
}

public class Salaires {

	public static void main(String [] args) {
		
		Personnel p = new Personnel();
		
		p.ajouterEmploye(new Vendeur("Pierre", "Business", 45, "1995", 30000));
		p.ajouterEmploye(new Representant("Léon", " VendTout", 25, "2001", 20000));
		p.ajouterEmploye(new Technicien("Yves", "Remord", 28, "1998", 1000));
		p.ajouterEmploye(new Manutentionnaire("Jeanne", "Stockeout", 32, "2000", 45));
		p.ajouterEmploye(new ManutARisque("Al", "Abordage", 30, "2001", 45));
		p.ajouterEmploye(new TechnARisque("Jean-Philipe", "ervitemonslip", 30, "2001", 1000));
		
		
		p.afficherSalaires();
		System.out.println("Le salaire moyen dans l'entreprise est de " + p.salaireMoyen() + " francs.");
		
	}
}
