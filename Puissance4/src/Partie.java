public class Partie {
	
	class JoueursTour {
		 JoueursTour next;
		 Joueurs joueur;
		 JoueursTour(Joueurs joueur){
			 this.joueur = joueur;
		 }
	}
		 
	private Jeu jeu;
	private JoueursTour joueurCourant;
	private JoueursTour ordi;
	private JoueursTour player;
	
	public Partie(Joueurs joueur1, Joueurs joueur2) {
		
		ordi = new JoueursTour(joueur1);
		player = new JoueursTour(joueur2);
		ordi.next = player;
		player.next = ordi;
        joueurCourant = ordi;
		jeu = new Jeu(8);
	}

	public void joue() {		
		while (!jeu.estPlein() & !jeu.look4InRow() & !jeu.look4InCol() & !jeu.look4InDiagRight() & !jeu.look4InDiagLeft()) {
			joueurCourant.joueur.joue(jeu);
			joueurCourant = joueurCourant.next;
		}
		if (jeu.getVictoryAI()) {
			jeu.afficher();
			System.out.println("L'" + ordi.joueur.getNom() + " a gagné !");
		}
		if(jeu.getVictoryPlayer()) {
			jeu.afficher();
			System.out.println(player.joueur.getNom() + " a gagné !");
		}
	}
}