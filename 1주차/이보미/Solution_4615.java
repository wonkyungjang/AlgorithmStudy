import java.util.Scanner;

public class Solution_4615 {

	static int T;
	static int N, M;
	static int [][] map;
	static int [] dr = {-1, 1, 0, 0, -1, -1, 1, 1}; // 상하좌우대각선
	static int [] dc = {0, 0, -1, 1, -1, 1, -1, 1};
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scann.nextInt();
			M = scann.nextInt();
			map = new int[N][N];
			
			// 초기 세팅
			map[N/2-1][N/2-1] = 2;
			map[N/2-1][N/2] = 1;
			map[N/2][N/2-1] = 1;
			map[N/2][N/2] = 2;
			
			for (int i = 0; i < M; i++) {
				int x = scann.nextInt()-1;
				int y = scann.nextInt()-1;
				int color = scann.nextInt();
				map[y][x] = color;
				game(y, x, color);
			}
			
			int w = 0;
			int b = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == 1) { //흑
						b++;
					}
					if(map[i][j] == 2) { //백
						w++;
					}
				}
			}
			
			System.out.println("#"+t+" "+b+" "+w);
		}
	}

	private static void game(int r, int c, int color) {
		
		for (int d = 0; d < 8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			boolean flag = false;
			while(check(nr, nc) && map[nr][nc] != 0) {
				if(map[nr][nc] == color) {
					flag = true;
					break;
				}
				nr += dr[d];
				nc += dc[d];
			}
			
			while(flag) {
				if(nr == r && nc == c) break;
				map[nr][nc] = color;
				nr -= dr[d];
				nc -= dc[d];
			}
		}
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
