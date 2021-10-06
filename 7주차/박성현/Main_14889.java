import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889 {

	static int n;
	static int[][] s;
	static int minD;
	
	static void combi(int start, int cnt, boolean[] v) {
		if (cnt == n/2) {
			int a = 0;
			int b = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (v[i] && v[j]) a+=s[i][j];
					else if (!v[i] && !v[j]) b+=s[i][j];
				}
			}
			int d = Math.abs(a-b);
			if (minD > d) minD = d;
			return;
		}
		for (int i = start; i < n; i++) {
			v[i] = true;
			combi(i+1, cnt+1, v);
			v[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		s = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer stn = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				s[i][j] = Integer.parseInt(stn.nextToken());
			}
		}
		minD = Integer.MAX_VALUE;
		combi(0, 0, new boolean[n]);
		System.out.println(minD);
	}

}
