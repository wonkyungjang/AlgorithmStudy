import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2156 {

	static int n;
	static int[] podos;
	static int[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		podos = new int[n];
		dp = new int[n][3];
		for (int i = 0; i < n; i++) {
			podos[i] = Integer.parseInt(br.readLine());
		}
		dp[0][0] = 0;
		dp[0][1] = podos[0];
		dp[0][2] = 0;
		if (n > 1) {
			dp[1][0] = dp[0][1];
			dp[1][1] = dp[0][0] + podos[1];
			dp[1][2] = dp[0][1] + podos[1];
			for (int i = 2; i < n; i++) {
				dp[i][0] = Math.max(Math.max(dp[i-1][1], dp[i-1][2]), dp[i-1][0]);
				dp[i][1] = dp[i-1][0] + podos[i];
				dp[i][2] = dp[i-1][1] + podos[i];
			}
		}
		int max = 0;
		for (int i = 0; i < 3; i++) {
			if (max < dp[n-1][i]) max = dp[n-1][i];
		}
		System.out.println(max);
	}

}
