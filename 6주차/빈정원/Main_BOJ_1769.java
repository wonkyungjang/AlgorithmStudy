package _06_0929;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 암호 만들기
public class Main_BOJ_1769 {

	static int L, C;
	static char[] alpha;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alpha = new char[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			alpha[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(alpha);		// 증가하는 순서로 배열되어 있으므로 정렬
		permutation(0, 0, new StringBuilder());
	}

	public static void permutation(int start, int cnt, StringBuilder pwd) {
		if (cnt == L) {
			int vo = 0;
			int co = 0;
			for (int i = 0; i < pwd.length(); i++) {
				char c = pwd.charAt(i);
				if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') vo++;
				else co++;
			}
			if (vo >= 1 && co >= 2)	// 모듬 1개 이상, 자음 2개 이상일 때만 출력
				System.out.println(pwd);
			return;
		}
		for (int i = start; i < C; i++) {
			permutation(i + 1, cnt + 1, pwd.append(alpha[i]));
			pwd.deleteCharAt(pwd.length() - 1);
		}
	}

}
