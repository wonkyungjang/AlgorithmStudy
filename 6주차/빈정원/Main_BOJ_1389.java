package _06_0929;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 케빈 베이컨의 6단계 법칙
public class Main_BOJ_1389 {

	static int N, M;
	static final int INF = 987654321;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dp = new int[N + 1][N + 1];
		
		// 무한대로 초기화
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) dp[i][j] = 0;
				else dp[i][j] = INF;
			}
		}
		
		// 연결된 곳은 1로 바꿔주기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			dp[A][B] = 1;
			dp[B][A] = 1;
		}
		
		// 플로이드 와샬
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
				}
			}
		}
		
		System.out.println(getAnswer());
		
	}

	public static int getAnswer() {
		int min = Integer.MAX_VALUE;
		int ans = 0;
		// 케빈 베이컨의 수 구하기
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= N; j++) {
				sum += dp[i][j];
			}
			if (min > sum) {
				min = sum;
				ans = i;
			}
		}
		return ans;
	}

}
