import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9372 {
	
	static int T, N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			StringTokenizer stn = new StringTokenizer(br.readLine());
			N = Integer.parseInt(stn.nextToken());
			M = Integer.parseInt(stn.nextToken());
			for (int i = 0; i < M; i++) {
				stn = new StringTokenizer(br.readLine());
			}
			System.out.println(N-1);
 		}
	}

}
