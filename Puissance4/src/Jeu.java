public class Jeu {

	public boolean gagnant = false;
	public boolean AIWon = false;
	public boolean playerWon = false;
	String pion;
	private int taille;
	private int [][] grille;
	
	public boolean getVictoryAI() {
		return AIWon;
	}
	
	public boolean getVictoryPlayer() {
		return playerWon;
	}
	
	public Jeu(int taille) {
		initialiseJeu(taille);
	}
	
	public void initialiseJeu(int taille) {
		this.taille = taille;
		grille = new int [taille] [taille];
		for (int row = 0; row < taille; row++) {
			for (int col = 0; col < taille; col++) {
				grille [col][row] = 0;
			}
		}
	}
	
	public boolean joueCoup(int col, int couleur) {
		if (col < 0 || col >= taille) {
			return false;
		}	
		for (int ligne = 0; ligne < taille; ligne++) {
			if (grille[col][ligne] == 0) {
				grille[col][ligne] = couleur;
				return true;
			}
		}
		return false;
	}
		
	public boolean look4InRow() {
		for (int row = 0; row < taille; row++) {
			for (int col = 0; col < taille - 3; col++) {
				if (grille [col][row] == 1) {
					if (grille [col+1][row] == 1 & grille [col+2][row] == 1 & grille [col+3][row] == 1) {
						gagnant = true;
						AIWon = true;
					}
				}
				if (grille [col][row] == 2) {
					if (grille [col+1][row] == 2 & grille [col+2][row] == 2 & grille [col+3][row] == 2) {
						gagnant = true;
						playerWon = true;
					}
				}
			}
		}
		return gagnant;
	}
	
	public boolean look4InCol() {
		for (int row = 0; row < taille - 3; row++) {
			for (int col = 0; col < taille; col++) {
				if (grille [col][row] == 1) {
					if (grille [col][row+1] == 1 & grille [col][row+2] == 1 & grille [col][row+3] == 1) {
						gagnant = true;
						AIWon = true;
					}
				}
				if (grille [col][row] == 2) {
					if (grille [col][row+1] == 2 & grille [col][row+2] == 2 & grille [col][row+3] == 2) {
						gagnant = true;
						playerWon = true;
					}
				}
			}
		}
		return gagnant;
	}
	
	public boolean look4InDiagRight() {
		for (int row = 0; row < taille - 3; row++) {
			for (int col = 0; col < taille - 3; col++) {
				if (grille [col][row] == 1) {
					if (grille [col+1][row+1] == 1 & grille [col+2][row+2] == 1 & grille [col+3][row+3] == 1) {
						gagnant = true;
						AIWon = true;
					}
				}
				if (grille [col][row] == 2) {
					if (grille [col+1][row+1] == 2 & grille [col+2][row+2] == 2 & grille [col+3][row+3] == 2) {
						gagnant = true;
						playerWon = true;
					}
				}			
			}
		}
		return gagnant;
	}
	
	public boolean look4InDiagLeft() {
		for (int row = 0; row < taille - 3; row++) {
			for (int col = 3; col < taille; col++) {
				if (grille [col][row] == 1) {
					if (grille [col-1][row+1] == 1 & grille [col-2][row+2] == 1 & grille [col-3][row+3] == 1) {
						gagnant = true;
						AIWon = true;
					}
				}
				if (grille [col][row] == 2) {
					if (grille [col-1][row+1] == 2 & grille [col-2][row+2] == 2 & grille [col-3][row+3] == 2) {
						gagnant = true;
						playerWon = true;
					}
				}
			}
		}
		return gagnant;
	}
	
	public boolean estPlein() {	
		for (int row = 0; row < taille; row++) {
			for (int col = 0; col < taille; col++) {
				if (grille [col][row] == 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	public int getTaille() {
		return taille;
	}
	
	public void afficher() {
		for (int ligne = taille - 1; ligne >= 0; ligne--) {
			for (int col = 0; col < taille; col++) {
				if (grille[col][ligne] == 0) {
					System.out.print("  ");
				}
				else if (grille[col][ligne] == 1) {
					System.out.print("R ");
				}
				else {
					System.out.print("B ");
				}
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < taille; i++) {
			System.out.print("- ");
		}
		System.out.println();	
		for (int i = 1; i <= taille; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}