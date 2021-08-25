import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_8320 {

	static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		int count = 0;
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
