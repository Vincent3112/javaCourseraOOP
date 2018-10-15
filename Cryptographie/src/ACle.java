import java.util.ArrayList;

public class ACle extends Code{

	String clé;
	ArrayList<Integer> translationTable1 = new ArrayList<Integer>();
	ArrayList<Integer> translationTable2 = new ArrayList<Integer>();
	ArrayList<Integer> translationTable3 = new ArrayList<Integer>();
	ArrayList<Integer> translationTable4 = new ArrayList<Integer>();
	
	
	ACle(String nom, String clé){
		super(nom);
		this.clé = clé;
	}
	
	ACle() {
		
	}
	
	public void affiche() {
		System.out.println(nom + " avec " + clé + " comme clé");
	}
	
	public String code(String s) {
		
		char[] charArray = s.toCharArray();
		for (char c : charArray) {
			int ascii = c;
			ascii-=64;
			translationTable1.add(ascii);
		}
		//System.out.println(translationTable1);
		char[] charArray2 = clé.toCharArray();
		for (char c : charArray2) {
			int ascii = c;
			ascii-=64;
			translationTable2.add(ascii);
		}
		//System.out.println(translationTable2);
		TableauCodage cleCodage = new TableauCodage(translationTable1.size());
		int i = 0;
		int j = 0;
		while (j < translationTable1.size()) {
			cleCodage.add(translationTable2.get(i));
			i++;
			j++;
			if (i == translationTable2.size()) {
				i = 0;
			}
		}
		//cleCodage.getTableau();
		TableauCodage additionCodes = new TableauCodage(translationTable1.size());
		int k =0;
		while (k < translationTable1.size()) {
			int a = translationTable1.get(k) + cleCodage.get(k);
			if (a > 26) {
				a-=26;
			}
			additionCodes.add(a);
			k++;
		}
		//additionCodes.getTableau();
		ArrayList<String> codedecode = new ArrayList<String>();
		int l =0;
		char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		while ( l < translationTable1.size()) {
			codedecode.add(Character.toString(alphabet[additionCodes.get(l) - 1]));
			l++;
		}
		String leCodeEstDecode = String.join("",  codedecode);
		return leCodeEstDecode;
	}
	
	
	
	public String decode(String s) {
		char[] charArray3 = s.toCharArray();
		for (char c : charArray3) {
			int ascii = c;
			ascii-=64;
			translationTable3.add(ascii);
		}
		//System.out.println(translationTable3);
		char[] charArray4 = clé.toCharArray();
		for (char c : charArray4) {
			int ascii = c;
			ascii-=64;
			translationTable4.add(ascii);
		}
		TableauCodage cleCodage2 = new TableauCodage(translationTable3.size());
		int i = 0;
		int j = 0;
		while (j < translationTable3.size()) {
			cleCodage2.add(translationTable4.get(i));
			i++;
			j++;
			if (i == translationTable4.size()) {
				i = 0;
			}
		}
		TableauCodage additionCodes2 = new TableauCodage(translationTable3.size());
		int m =0;
		while (m < translationTable3.size()) {
			int a = translationTable3.get(m) - cleCodage2.get(m);
			if (a <= 0) {
				a+=26;
			}
			additionCodes2.add(a);
			m++;
		}
		ArrayList<String> coderecode = new ArrayList<String>();
		int l =0;
		char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		while ( l < translationTable3.size()) {
			coderecode.add(Character.toString(alphabet[additionCodes2.get(l) - 1]));
			l++;
		}	
		String leCodeEstCode = String.join("",  coderecode);
		return leCodeEstCode;		
	}
}
