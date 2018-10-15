
public class Secret {

	public static void main(String [] args) {
		String message ="VINCENT";
		System.out.println("Test CODAGES: ");
		System.out.println("----------------------");
		System.out.println();
		Code [] tab = {
				new Cesar("Cesar", 5),
				new ACle("a cle", "EQUINOXE"), 
				new ACleAleatoire(5),
				new ACleAleatoire(10)};
		
		Codages codes = new Codages(tab);
		codes.test(message);
		
		
		
		
		
	}
}
