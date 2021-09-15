import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2804 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		String first = s[0];
		String second = s[1];
		
		int cx = 0;
		int cy = 0;
		boolean find = false;
		for (int i = 0; i < first.length(); i++) {
			for (int j = 0; j < second.length(); j++) {
				if (first.charAt(i) == second.charAt(j)) {
					cx = i;
					cy = j;
					find = true;
					break;
				}
			}
			if (find) break;
		}
		
		for (int i = 0; i < second.length(); i++) {
			for (int j = 0; j < first.length(); j++) {
				if (i == cy) {
					System.out.print(first.charAt(j));
				}
				else if (j == cx) {
					System.out.print(second.charAt(i));
				}
				else {
					System.out.print('.');
				}
			}
			System.out.println();
		}
	}

}
