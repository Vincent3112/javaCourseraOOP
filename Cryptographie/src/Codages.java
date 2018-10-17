public class Codages {

	Code [] tab;	
	Codages(Code[] tab) {
		this.tab = tab;
	}
	
	public void test(String message) {
		for (Code code : tab) {
			System.out.print("Avec le code : " );
			code.affiche();
			String cryptage = code.code(message);
			System.out.print("Codage de " + message + " : ");
			System.out.println(cryptage);
			System.out.print("Décodage de " + cryptage + " : ");
			System.out.println(code.decode(cryptage));
			System.out.println("------------------------------");
			System.out.println();
		}
	}
}