import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 01타일
public class Main_1904 {

	static int N;
	static int [] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		
		dp[0] = 1;
		dp[1] = 1;
		
		System.out.println(fibo(N));

	}
	
	public static int fibo(int n) {
		if(dp[n] == 0) {
			dp[n] = (fibo(n-1) + fibo(n-2)) % 15746;
		}
		return dp[n];
	}
	
	// 효율 더 좋음
	public static int fibo2(int n) {
		for (int i = 2; i < n; i++) {
			dp[n] = (dp[i-1] + dp[i-2]) % 15746;
		}
		return dp[n];
	}


}
