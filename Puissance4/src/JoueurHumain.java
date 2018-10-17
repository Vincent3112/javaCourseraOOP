import java.util.Scanner;

public class JoueurHumain extends Joueurs {

	JoueurHumain(int couleur, String nom) {
		super(couleur, nom);
	}

	public void joue(Jeu jeu) {
		jeu.afficher();
		boolean coupValide;
		do {
			System.out.println("Entre la colonne dans laquelle vous souhaitez jouer : ");
			Scanner scanner = new Scanner(System.in);
			int colonneJouée = scanner.nextInt();
			coupValide = jeu.joueCoup(colonneJouée, this.getCouleur());
			if (coupValide == false) {
				System.out.println("Veuillez saisir une autre colonne");
			}
			else {
				System.out.println("Le joueur " + this.nom + " a joué en " + (colonneJouée + 1));
			}
		}
		while (coupValide == false);
	}
}