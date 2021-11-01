import java.util.Scanner;

public class BJ1904_01타일 {

	static int dp[];
	static int N;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		dp=new int[1000001];
		dp[1]=1;
		dp[2]=2;
		for(int i=3;i<=1000000;i++) {
			dp[i]=(dp[i-1]+dp[i-2])%15746;
		}
		System.out.println(dp[N]);
	}
}
