package _02_0901;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 비밀번호
public class Solution_D3_1234 {

	static int T = 10, N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			char[] charArr = st.nextToken().toCharArray();
			StringBuilder sb = new StringBuilder();	// sb를 스택처럼 사용
			for (int i = 0; i < N; i++) {
				char c = charArr[i];
				int len = sb.length();
				// 스택이 비어있거나, 스택의 top이 현재 문자와 다르면 스택에 push
				if (len == 0 || sb.charAt(len - 1) != c)
					sb.append(c);
				// 스택의 top이 현재 문자와 같은 경우 pop
				else 
					sb.deleteCharAt(len - 1);
			}
			System.out.println("#" + t + " " + sb);
		}
	}

}
