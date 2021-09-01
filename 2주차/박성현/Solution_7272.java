import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_7272 {

	static int T;
	 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		int[] alpabet = new int[26];
		alpabet['A' - 'A'] = 1;
		alpabet['D' - 'A'] = 1;
		alpabet['O' - 'A'] = 1;
		alpabet['P' - 'A'] = 1;
		alpabet['Q' - 'A'] = 1;
		alpabet['R' - 'A'] = 1;
		alpabet['B' - 'A'] = 2;
		
		for (int i = 0; i < T; i++) {
			String[] line = br.readLine().split(" ");
			String first = line[0];
			String second = line[1];
			
			boolean result = true;
			if (first.length() == second.length()) {
				for (int j = 0; j < first.length(); j++) {
					if (alpabet[first.charAt(j) - 'A'] != alpabet[second.charAt(j) - 'A']) {
						result = false;
						break;
					}
				}
			}
			else {
				result = false;
			}
			
			if (result) {
				System.out.printf("#%d SAME\n", i+1);
			}
			else {
				System.out.printf("#%d DIFF\n", i+1);
			}
		}

	}

}
