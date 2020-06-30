public class PatternMatchingTestes {
	private static String geraString(int size, int rep) {
		StringBuilder res = new StringBuilder();;
		String charStr = "ABCDEFGHIJKLMOPQRSTWXYZ";
		int posCharStr = 0;
		
		if (size > 0 && rep > 0 && rep < charStr.length()) {
			for (int i = 0; i < size; i++) {
				res.append(charStr.charAt(posCharStr));
				posCharStr++;
				if (posCharStr == rep)
					posCharStr = 0;
			}
		}
		return res.toString();
	}
	
	public static void main(String[] args) {
		
		System.out.println("*******************************");
		System.out.println("*Pequenos testes de verifica��o");
		System.out.println("*******************************");
		
		String txt = "ABCDCBDCBDACBDABDCBADF"; 
		String pat = "ADF";
		System.out.println("txt = " + txt + "\npat = " + pat);
		System.out.println("\tKnuth-Morris-Prat -> " + KMP_String_Matching.KMPSearch(pat, txt));
		
		txt = "ABCDCBDCBDACBDABDCBADF"; 
		pat = "JJJ";
		System.out.println("\ntxt = " + txt + "\npat = " + pat);
		System.out.println("\tKnuth-Morris-Prat -> " + KMP_String_Matching.KMPSearch(pat, txt));
		
		System.out.println("\ntxt = " + pat + "\npat = " + txt);
		System.out.println("\tKnuth-Morris-Prat -> " + KMP_String_Matching.KMPSearch(pat, txt));
		
		txt = PatternMatchingTestes.geraString(50, 20); 
		pat = "TWABCDEFGHIJK";
		System.out.println("\ntxt = " + txt + "\npat = " + pat);
		System.out.println("\tKnuth-Morris-Prat -> " + KMP_String_Matching.KMPSearch(pat, txt));
		
		txt = PatternMatchingTestes.geraString(50_000, 2); 
		pat = PatternMatchingTestes.geraString(20_000, 2);
		pat = pat + "Z";
		System.out.println("\ntxt com " + 50_000 + "\npat com " + 20_001);
		System.out.println("\tKnuth-Morris-Prat -> " + KMP_String_Matching.KMPSearch(pat, txt));
		
		txt = PatternMatchingTestes.geraString(500_000, 2); 
		pat = PatternMatchingTestes.geraString(20_000, 2);
		pat = pat + "Z";
		System.out.println("\ntxt com " + 500_000 + "\npat com " + 20_001);
		System.out.println("\tKnuth-Morris-Prat -> " + KMP_String_Matching.KMPSearch(pat, txt));
		
		txt = PatternMatchingTestes.geraString(500_000, 2); 
		pat = PatternMatchingTestes.geraString(20_000, 2);
		txt = txt + "Z";
		pat = pat + "Z";
		System.out.println("\ntxt com " + 500_001 + "\npat com " + 20_001);
		System.out.println("\tKnuth-Morris-Prat -> " + KMP_String_Matching.KMPSearch(pat, txt));
	}
}