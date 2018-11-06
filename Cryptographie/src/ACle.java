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
		
		char[] charArrayString = s.toCharArray();
		for (char c : charArrayString) {
			int ascii = c;
			ascii-=64;
			translationTable1.add(ascii);
		}
		
		char[] charArrayKey = clé.toCharArray();
		for (char c : charArrayKey) {
			int ascii = c;
			ascii-=64;
			translationTable2.add(ascii);
		}
		
		TableauCodage keyMatchStringSize = new TableauCodage(translationTable1.size());
		int i = 0;
		int j = 0;
		while (j < translationTable1.size()) {
			keyMatchStringSize.add(translationTable2.get(i));
			i++;
			j++;
			if (i == translationTable2.size()) {
				i = 0;
			}
		}
		
		TableauCodage additionCodes = new TableauCodage(translationTable1.size());
		int k =0;
		while (k < translationTable1.size()) {
			int a = translationTable1.get(k) + keyMatchStringSize.get(k);
			if (a > 26) {
				a-=26;
			}
			additionCodes.add(a);
			k++;
		}
		
		ArrayList<String> codedString = new ArrayList<String>();
		int l =0;
		char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		while ( l < translationTable1.size()) {
			codedString.add(Character.toString(alphabet[additionCodes.get(l) - 1]));
			l++;
		}
		String stringIsCoded = String.join("",  codedString);
		return stringIsCoded;
	}
	
	public String decode(String s) {
		char[] charArray3 = s.toCharArray();
		for (char c : charArray3) {
			int ascii = c;
			ascii-=64;
			translationTable3.add(ascii);
		}
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