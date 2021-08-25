import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1523 {

	static int n, m;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stn.nextToken());
		m = Integer.parseInt(stn.nextToken());
		
		if (n <= 100 && n > 0) {
			switch (m) {
			case 1:
				for (int i = 1; i < n+1; i++) {
					for (int j = 0; j < i; j++) {
						System.out.print('*');
					}
					System.out.println();
				}
				break;
			case 2:
				for (int i = 1; i < n+1; i++) {
					for (int j = 0; j < n+1-i; j++) {
						System.out.print('*');
					}
					System.out.println();
				}
				break;
			case 3:
				for (int i = 1; i < n+1; i++) {
					for (int j = 0; j < n-i; j++) {
						System.out.print(' ');
					}
					for (int j = 0; j < (i-1)*2 + 1; j++) {
						System.out.print('*');
					}
					System.out.println();
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
