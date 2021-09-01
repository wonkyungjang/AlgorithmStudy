import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2798 {

	static int n, m;
	static int[] cards;
	static int r = 3;
	static int ans = 0;
	
	public static void combi(int cnt, int start, int sum) {
		if (ans == m) return;
		else if (sum > m) return; 
		if (cnt == r) {
			if (m-sum < m-ans) ans = sum;
			return;
		}
		for (int i = start; i < n; i++) {
			combi(cnt+1, i+1, sum+cards[i]);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stn.nextToken());
		m = Integer.parseInt(stn.nextToken());
		cards = new int[n];
		
		stn = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			cards[i] = Integer.parseInt(stn.nextToken());
		}
		
		combi(0, 0, 0);
		System.out.println(ans);

	}

}
