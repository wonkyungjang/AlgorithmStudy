import java.util.Scanner;

public class Main_jungol_1707 {
	
	static int n;
	static int [] dr = {0, 1, 0, -1};
	static int [] dc = {1, 0, -1, 0};
	static int [][] map;

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		n = scann.nextInt();
		map = new int[n][n];
		
		snail(0, 0, 0);
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	
	}

	private static void snail(int r, int c, int d) {
		int cnt = 1;
		int nr = r;
		int nc = c;
		while(cnt <= n*n) {
			map[nr][nc] = cnt;
			if(!(check(nr+dr[d], nc+dc[d])) || map[nr+dr[d]][nc+dc[d]] != 0) {
				d = (d+1)%4;
			}
			nr += dr[d];
			nc += dc[d];
			cnt++;
		}
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<n && c>=0 && c<n;
	}

}
