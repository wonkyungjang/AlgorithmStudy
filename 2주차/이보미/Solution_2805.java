import java.util.Scanner;

public class Solution_2805 {

	static int T;
	static int N;
	static int [][] map;
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		T = scann.nextInt();
		
		for (int t = 1; t <= T; t++) {
			N = scann.nextInt();
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String str = scann.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j)-'0';
				}
			}
			
			int k = N/2;
			int sum = 0;
			for (int i = 0; i <= k; i++) {
				for (int j = k-i; j <= k+i; j++) {
					sum += map[i][j];
				}
				
			}
		
			for (int i = k-1; i >= 0; i--) {
				for (int j = k-i; j <= k+i; j++) {
					sum += map[N-i-1][j];
				}
			}
			
			System.out.println("#"+t+" "+sum);
		}
				
	}

}
