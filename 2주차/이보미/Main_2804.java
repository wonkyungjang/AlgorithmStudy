import java.util.Scanner;

public class Main_2804 {
	
	static char [][] crossWord;
	static String wordA;
	static String wordB;
			
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		wordA = scann.next();
		wordB = scann.next();
		crossWord = new char[wordB.length()][wordA.length()];
		
		// 4중포문...?
//		outer : for (int i = 0; i < wordA.length(); i++) {
//			for (int j = 0; j < wordB.length(); j++) {
//				if(wordA.charAt(i) == wordB.charAt(j)) {
//					crossing(j, i);
//					break outer;
//				}
//			}
//		}
//		
		for (int i = 0; i < wordA.length(); i++) {
			if(wordB.indexOf(wordA.charAt(i)) != -1) { // indexOf은 찾는 문자가 없으면 -1을 리턴
				crossing(wordB.indexOf(wordA.charAt(i)), i);
				break;
			}
		}
		
		for (int i = 0; i < wordB.length(); i++) {
			for (int j = 0; j < wordA.length(); j++) {
				System.out.print(crossWord[i][j]);
			}
			System.out.println();
		}
	}

	private static void crossing(int r, int c) {
		for (int i = 0; i < wordB.length(); i++) {
			for (int j = 0; j < wordA.length(); j++) {
				if(i == r) {
					crossWord[i][j] = wordA.charAt(j);
				}
				else if(j == c) {
					crossWord[i][j] = wordB.charAt(i);
				}else {
					crossWord[i][j] = '.';
				}
			}
		}
	}

}
