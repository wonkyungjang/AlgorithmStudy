import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19948 {

	static String poem;
	static int spacebarCnt;
	static int [] keyboard;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		poem = br.readLine().toUpperCase().replaceAll("\\s+", " ");
		spacebarCnt = Integer.parseInt(br.readLine());
		keyboard = new int[100];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < 26; i++) {
			keyboard[65+i] = Integer.parseInt(st.nextToken());
		}
		
		boolean flag = true;

		for (int i = 0; i < poem.length(); i++) {
			char c = poem.charAt(i);
			
			if(c == ' ') {
				if(spacebarCnt == 0) {
					flag = false;
					break;
				}else {
					spacebarCnt--;
				}
			}else if(keyboard[(int)c] == 0) {
				flag = false;
				break;
			}else {
				if( i >= 1 && c == poem.charAt(i-1)) continue;
				keyboard[(int)c]--;
			}
		}
		
		
		String [] p = poem.split(" ");
		StringBuilder title = new StringBuilder();
		for (int i = 0; i < p.length; i++) {
			title.append(p[i].charAt(0));
		}
		
		for (int i = 0; i < title.length(); i++) {
			char c = title.charAt(i);
			if(keyboard[(int)c] == 0) {
				flag = false;
				break;
			}else {
				if(i >= 1 && c == title.charAt(i-1)) continue;
				keyboard[(int)c]--;
			}
		}
	
		if(flag) {
			System.out.println(title);
		}else {
			System.out.println(-1);
		}
		
	}

}
