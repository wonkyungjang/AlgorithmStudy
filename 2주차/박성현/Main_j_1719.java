import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_j_1719 {

	static int n, m;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stn.nextToken());
		m = Integer.parseInt(stn.nextToken());
		
		if (n <= 100 && n > 0 && n % 2 == 1) {
			int k = 1;
			switch (m) {
			case 1:
				for (int i = 1; i < n+1; i++) {
					for (int j = 0; j < k; j++) {
						System.out.print('*');
					}
					System.out.println();
					if (i < n/2+1) k++;
					else k--;
				}
				break;
			case 2:
				for (int i = 1; i < n+1; i++) {
					for (int j = 0; j < n/2+1-k; j++) {
						System.out.print(' ');
					}
					for (int j = 0; j < k; j++) {
						System.out.print('*');
					}
					System.out.println();
					if (i < n/2+1) k++;
					else k--;
				}
				break;
			case 3:
				k = 0;
				for (int i = 1; i < n+1; i++) {
					for (int j = 0; j < k; j++) {
						System.out.print(' ');
					}
					for (int j = 0; j < n-2*k; j++) {
						System.out.print('*');
					}
					System.out.println();
					if (i < n/2+1) k++;
					else k--;
				}
				break;
			case 4:
				k = 0;
				int t = 0;
				for (int i = 1; i < n+1; i++) {
					for (int j = 0; j < k; j++) {
						System.out.print(' ');
					}
					for (int j = 0; j < n/2+1-k+t; j++) {
						System.out.print('*');
					}
					System.out.println();
					if (i < n/2+1) k++;
					else t++;
				}
				break;
			default:
				System.out.println("INPUT ERROR!\n");
			}
		}
		else {
			System.out.println("INPUT ERROR!\n");
		}

	}

}
