public class Joueurs {

	int couleur;
	String nom;
	
	Joueurs() {
	}
	
	Joueurs(int couleur, String nom) {
		this.couleur = couleur;
		this.nom = nom;
	}
	
	public int getCouleur() {
		return couleur;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void joue(Jeu jeu) {	
	}
}