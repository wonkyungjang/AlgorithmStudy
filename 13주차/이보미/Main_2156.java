import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 포도주 시식
public class Main_2156 {

	static int n;
	static int [] wine;
	static int [] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		wine = new int[n];
		dp = new int[n];
		
		for (int i = 0; i < n; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		
		// 첫잔일 경우
        if (n >= 1) {
            dp[0] = wine[0];
        } 
        // 두잔일 경우
        if (n >= 2) {
            dp[1] = wine[0] + wine[1];
        }
        // 세잔일 경우
        if (n >= 3) {
            dp[2] = Math.max(dp[1], Math.max(dp[0] + wine[2], wine[1] + wine[2]));
        }
        for (int i = 3; i < n; i++) {
        	// oox, oxo, xoo 중 가장 큰 값을 구하면 됨
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i]));
        }
        
        System.out.println(dp[n - 1]);
	}

}
