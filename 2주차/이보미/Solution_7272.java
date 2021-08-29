import java.util.ArrayList;
import java.util.Scanner;

public class Solution_7272 {

	static int T;
	static ArrayList<Character> hole;
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		hole = new ArrayList<>();
		hole.add('A');
		hole.add('D');
		hole.add('O');
		hole.add('P');
		hole.add('Q');
		hole.add('R');
		
		T = scann.nextInt();
		
		for (int t = 1; t <= T; t++) {
			String str1 = scann.next();
			String str2 = scann.next();
			
			String result = "SAME";
			if(str1.length() == str2.length()) {
				for (int i = 0; i < str1.length(); i++) {
					char c1 = str1.charAt(i);
					char c2 = str2.charAt(i);
					if(c1 == 'B' && c2 == 'B') continue;
					else if(hole.contains(c1) && hole.contains(c2)) continue;
					else if(!hole.contains(c1) && !hole.contains(c2) && c1 != 'B' && c2 != 'B') continue;
					else result = "DIFF"; break;
				}
			}else {
				result = "DIFF";
			}
			
			System.out.println("#"+t+" "+result);
		}
	}

}
