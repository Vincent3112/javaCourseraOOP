public class JoueurOrdi extends Joueurs{
	
	JoueurOrdi(int couleur, String nom) {
			super(couleur, nom);
		}
		
		public void joue(Jeu jeu) {
			//jeu.afficher();
			for (int col = 0; col < jeu.getTaille(); col++) {
				if (jeu.joueCoup(col, this.getCouleur())) {
					System.out.println("L'ordi a joué en colonne " + (col + 1));
					return;
				}
			}
		}
	}