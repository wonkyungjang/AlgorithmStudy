import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19948 {
	
	static int space;
	static int[] alpha = new int[26];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		space = Integer.parseInt(br.readLine());
		StringTokenizer stn = new StringTokenizer(br.readLine());
		for (int i = 0; i < 26; i++) {
			alpha[i] = Integer.parseInt(stn.nextToken());
		}
		boolean firstalp = true;
		boolean success = true;
		StringBuilder sb = new StringBuilder("");
		char pch = '0';
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (pch == ch) continue;
			pch = ch;
			if (ch == ' ') {
				firstalp = true;
				if ((--space) < 0) {
					success = false;
					break;
				}
				continue;
			}
			else if (firstalp) {
				firstalp = false;
				if (ch >= 97) ch -= 32;
				if (alpha[ch-'A'] > 1) {
					alpha[ch-'A']-=2;
					sb.append(ch);
				}
				else {
					success = false;
					break;
				}
			}
			else {
				if (ch >= 97) ch -= 32;
				if (alpha[ch-'A'] > 0) {
					alpha[ch-'A']--;
				}
				else {
					success = false;
					break;
				}
			}
		}
		if (success) System.out.println(sb.toString());
		else System.out.println(-1);
	}

}
