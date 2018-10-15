
abstract class Code {

	String nom;
	
	
	Code(String nom) {
		this.nom = nom;
	}
	
	Code() {
		
	}
	
	public abstract void affiche();
	
	public abstract String code(String s);
	
	public abstract String decode(String s);
	
}
