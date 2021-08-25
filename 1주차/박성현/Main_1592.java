import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1592 {

	static int n, m, l;
	static int[] p;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stn.nextToken());
		m = Integer.parseInt(stn.nextToken());
		l = Integer.parseInt(stn.nextToken());
		p = new int[n];
		
		int count = 0;
		int cx = 0;
		p[cx] = 1;
		while (p[cx] < m) {
			if (p[cx] % 2 == 1) {
				cx += l;
				if (cx >= n) {
					cx %= n;
				}
			}
			else {
				cx -= l;
				if (cx < 0) {
					cx += n;
				}
			}
			p[cx]++;
			count++;
		}
		System.out.println(count);
		
	}

}
