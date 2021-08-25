import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_17413 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		boolean tag = false;
		
		StringBuilder sb = new StringBuilder("");
		StringBuilder word = new StringBuilder("");
		for (int i = 0; i < s.length(); i++) {
			if (tag && s.charAt(i) == '>') {
				sb.append(s.charAt(i));
				tag = false;
			}
			else if (tag) {
				sb.append(s.charAt(i));
			}
			else if (s.charAt(i) == '<') {
				sb.append(word.reverse());
				word = new StringBuilder("");
				sb.append(s.charAt(i));
				tag = true;
			}
			else if (s.charAt(i) == ' ') {
				sb.append(word.reverse() + " ");
				word = new StringBuilder("");
			}
			else {
				word.append(s.charAt(i));
			}
		}
		sb.append(word.reverse());
		
		System.out.println(sb.toString());
		
	}

}
