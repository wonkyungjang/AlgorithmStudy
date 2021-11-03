import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9184 {
	
	static int[][][] dp;
	
	static int w(int a, int b, int c) {
		if (a <= 0 || b <= 0 || c <= 0) {
			return (dp[a][b][c]) = 1;
		}
		else if (a > 20 || b > 20 || c > 20) {
			return dp[20][20][20];
		}
		else if (a < b && b < c) {
			return (dp[a][b][c] = dp[a][b][c-1] + dp[a][b-1][c-1] - dp[a][b-1][c]);
		}
		else {
			return (dp[a][b][c] = dp[a-1][b][c] + dp[a-1][b-1][c] + dp[a-1][b][c-1] - dp[a-1][b-1][c-1]);
		}
	}
	
	static int ww(int a, int b, int c) {
		if (a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}
		else if (a > 20 || b > 20 || c > 20) {
			return dp[20][20][20];
		}
		else {
			return dp[a][b][c];
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dp = new int[21][21][21];
		for (int a = 0; a <= 20; a++) {
			for (int b = 0; b <= 20; b++) {
				for (int c = 0; c <= 20; c++) {
					w(a, b, c);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer stn = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stn.nextToken());
			int b = Integer.parseInt(stn.nextToken());
			int c = Integer.parseInt(stn.nextToken());
			if (a == -1 && b == -1 && c == -1) break;
			sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(ww(a, b, c)).append('\n');
		}
		System.out.print(sb);
		
	}
}
