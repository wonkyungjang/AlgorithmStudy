import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11399 {

	static int n;
	static int[] p;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		p = new int[n];
		StringTokenizer stn = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			p[i] = Integer.parseInt(stn.nextToken());
			
		}
		Arrays.sort(p);
		long sum = 0;
		long ps = 0;
		for (int i = 0; i < n; i++) {
			ps += p[i];
			sum += ps;
		}
		System.out.println(sum);
	}

}
