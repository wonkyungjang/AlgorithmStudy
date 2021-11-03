import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_ {

	static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int dp1 = 1;
		int dp2 = 2;
		for (int i = 2; i < n; i++) {
			int temp = dp2;
			dp2 = (dp1 + dp2)%15746;
			dp1 = temp;
		}
		if (n == 1) System.out.println(dp1);
		else System.out.println(dp2);
	}

}
