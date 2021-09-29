import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1389 {

	static int n, m;
	static int[][] relations;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stn.nextToken());
		m = Integer.parseInt(stn.nextToken());
		
		relations = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				relations[i][j] = Integer.MAX_VALUE;
			}
		}
		for (int i = 0; i < m; i++) {
			stn = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stn.nextToken());
			int b = Integer.parseInt(stn.nextToken());
			relations[a-1][b-1] = 1;
			relations[b-1][a-1] = 1;
		}
		
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (relations[i][k] != Integer.MAX_VALUE && relations[k][j] != Integer.MAX_VALUE)
					if (relations[i][k] + relations[k][j] < relations[i][j]) {
						relations[i][j] = relations[i][k] + relations[k][j];
					}
				}
			}
		}
		
		int ans_d = Integer.MAX_VALUE;
		int ans = 0;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = 0; j < n; j++) {
				if (relations[i][j] != Integer.MAX_VALUE) {
					sum += relations[i][j];
				}
			}
			if (sum < ans_d) {
				ans = i;
				ans_d = sum;
			}
		}
		System.out.println(ans+1);
	}

}
