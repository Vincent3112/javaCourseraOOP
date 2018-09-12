import java.util.Scanner;

class Puissance4 {
	
	protected static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {	
		System.out.println("Entrez votre nom: ");
		String nom = scanner.nextLine();
		System.out.println("--");
		Partie p = new Partie(new JoueurOrdi( 1, "ordinatueur"), new JoueurHumain(2, nom));
		p.joue();
	}
}