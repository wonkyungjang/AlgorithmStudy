import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2156_포도주시식 {

	static int drink[];
	static int dp[];
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		drink=new int[n+1];
		dp=new int[n+1];
		
		for(int i=1;i<=n;i++) {
			drink[i]=Integer.parseInt(br.readLine());
		}
		
		dp[1]=drink[1];
		if(n>=2) dp[2]=drink[1]+drink[2];
	
		for(int i=3;i<=n;i++) {
			dp[i]=Math.max(dp[i-1], Math.max(drink[i-1]+drink[i]+dp[i-3], dp[i-2]+drink[i]));
		}
		System.out.println(dp[n]);
	}

}
