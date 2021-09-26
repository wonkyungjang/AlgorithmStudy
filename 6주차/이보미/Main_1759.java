import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1759 {

	static int L, C;
	static char [] c;
	static char [] vowel = {'a', 'e', 'i', 'o', 'u'};
	static char [] code;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		c = new char[C];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			c[i] = st.nextToken().charAt(0);
		}
		
		code = new char[L];
		
		Arrays.sort(c); // 처음 문자열을 정렬해주면 사전식으로 조합이 됨
		combination(0, 0);
	}

	private static void combination(int cnt, int start) {
		if(cnt == L) {
			int count = 0;
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < code.length; j++) {
					if(code[j] == vowel[i]) count++;
				}
			}
			
			if(count > 0 && L-count >= 2) {
				for (char c : code) {
					System.out.print(c);
				}
				System.out.println();
			}
			
			return;
		}
		
		for (int i = start; i < C; i++) {
			code[cnt] = c[i];
			combination(cnt+1, i+1);
		}
	}

}
