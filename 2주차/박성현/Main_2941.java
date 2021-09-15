import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2941 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'c') {
				if (i+1 < s.length()) { 
					if (s.charAt(i+1) == '=' || s.charAt(i+1) == '-') {
						i++;
					}
				}
				cnt++;
			}
			else if (s.charAt(i) == 'd') {
				if (i+1 < s.length()) { 
					if (s.charAt(i+1) == '-') {
						i++;
					}
					else if (i+2 < s.length()) {
						if (s.charAt(i+1) == 'z' && s.charAt(i+2) == '=') {
							i+=2;
						}
					}
				}
				cnt++;
			}
			else if (s.charAt(i) == 'l' || s.charAt(i) == 'n') {
				if (i+1 < s.length()) { 
					if (s.charAt(i+1) == 'j') {
						i++;
					}
				}
				cnt++;
			}
			else if (s.charAt(i) == 's' || s.charAt(i) == 'z') {
				if (i+1 < s.length()) { 
					if (s.charAt(i+1) == '=') {
						i++;
					}
				}
				cnt++;
			}
			else cnt++;
		}
		
		System.out.println(cnt);
	}
}
