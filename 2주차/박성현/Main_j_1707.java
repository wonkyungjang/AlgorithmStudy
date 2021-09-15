import java.util.Scanner;

public class Main_j_1707 {

	static int N;
	static int[][] mp;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		N = scann.nextInt();
		mp = new int[N][N];
		
		int x = 0;
		int y = 0;
		int n = 1;
		mp[x][y] = n++;
		int m = 0;
		
		for (int j = N-1; j > 0; j--) {
			for (int l = 0; l < 2; l++) {
				for (int k = 0; k < j; k++) {
					x += dx[m%4];
					y += dy[m%4];
					mp[x][y] = n++;
				}
				m++;
			}
			x += dx[m%4];
			y += dy[m%4];
			mp[x][y] = n++;
		}
		
		for (int j = 0; j < N; j++) {
			for (int k = 0; k < N; k++) {
				System.out.print(mp[j][k]);
				System.out.print(" ");
			}
			System.out.println();
		}
		
		scann.close();
	}

}
