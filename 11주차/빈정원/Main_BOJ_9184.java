package _11_1103;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 신나는 함수 실행
public class Main_BOJ_9184 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// dp로 미리 구하기
		int[][][] dp = new int[21][21][21];
		for (int a = 0; a <= 20; a++) {
			for (int b = 0; b <= 20; b++) {
				for (int c = 0; c <= 20; c++) {
					if (a == 0 || b == 0 || c == 0) {
						dp[a][b][c] = 1;
					} else if (a < b && b < c) {
						dp[a][b][c] = dp[a][b][c - 1] + dp[a][b - 1][c - 1] - dp[a][b - 1][c];
					} else {
						dp[a][b][c] = dp[a - 1][b][c] + dp[a - 1][b - 1][c] + dp[a - 1][b][c - 1] - dp[a - 1][b - 1][c - 1];
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a == -1 && b == -1 && c == -1) {
				break;
			}
			
			int ans = 0;
			if (a <= 0 || b <= 0 || c <= 0) {
				ans = 1;
			} else if (a > 20 || b > 20 || c > 20) {
				ans = dp[20][20][20];
			} else {
				ans = dp[a][b][c];
			}
			sb.append("w(" + a + ", " + b + ", " + c + ") = " + ans + "\n");
			
		}
		System.out.println(sb);
	}

}
