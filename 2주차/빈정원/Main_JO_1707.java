package _02_0901;

import java.util.Scanner;

// 달팽이사각형
public class Main_JO_1707 {

	static int N;
	static int[][] map;
	static int[] dr = {0, -1, 0, 1};	// 우하좌상
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		int num = 1;
		int nr = 0;
		int nc = -1;
		while (num <= N * N) {
			for (int d = 0; d < 4; d++) {
				nr += dr[d];
				nc += dc[d];
				while (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == 0) {
					map[nr][nc] = num++;
					nr += dr[d];
					nc += dc[d];
				}
				nr -= dr[d];
				nc -= dc[d];
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(map[i][j] + " ");
			System.out.println();
		}
	}

}
