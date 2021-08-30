package _02_0901;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 색종이 - 2
public class Main_BOJ_2567 {
	
	static int N;
	static final int SIZE = 102;	// 테두리를 false로 미리 채워놓기 위해 SIZE를 102로 선언
	static boolean[][] map = new boolean[SIZE][SIZE];
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) + 1;
			int c = Integer.parseInt(st.nextToken()) + 1;
			// 문제의 그림에서 시계방향으로 90도 회전시켜서 푸는게 편리
			for (int j = r; j < r + 10; j++) {
				for (int k = c; k < c + 10; k++) {
					map[j][k] = true;
				}
			}
		}
		int sum = 0;
		for (int r = 1; r < SIZE - 1; r++) {
			for (int c = 1; c < SIZE - 1; c++) {
				// 현재 위치가 true(색종이)일 때, 상하좌우가 false면 테두리
				if (map[r][c]) {
					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if (!map[nr][nc]) sum++;
					}
				}
			}
		}
		System.out.println(sum);
	}
	
}
