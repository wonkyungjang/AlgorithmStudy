import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_j_1329 {

	static int n;
	public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			n = Integer.parseInt(br.readLine());
			
			if (n < 100 && n > 0 && n%2 == 1) {
				int k = 1;
				int t = 0;
				for (int i = 1; i < n+1; i++) {
					for (int j = 0; j < t; j++) {
						System.out.print(' ');
					}
					for (int j = 0; j < k; j++) {
						System.out.print('*');
					}
					System.out.println();
					if (i < n/2+1) {
						k+=2;
						t++;
					}
					else {
						k-=2;
						t--;
					}
				}

			}
			else {
				System.out.println("INPUT ERROR!\n");
			}
	}

}
