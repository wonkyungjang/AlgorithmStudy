package _11_1103;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 여우는 어떻게 울지?
public class Main_BOJ_9536 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			ArrayList<String> words = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				words.add(st.nextToken());
			}
			while (true) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();					// 동물 or what
				st.nextToken();					// goes or does
				String sound = st.nextToken();	// 소리 or the
				if (st.hasMoreTokens()) {
					st.nextToken();				// fox
					st.nextToken();				// say?
					break;
				}
				words.removeIf((item) -> sound.equals(item));
			}
			StringBuilder sb = new StringBuilder();
			for (String s : words) {
				sb.append(s + " ");
			}
			System.out.println(sb);
		}
	}

}
