package _06_0929;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 말이 되고픈 원숭이
public class Main_BOJ_1600 {

	static int K, W, H;
	static int[][] map;
	static int[][][] v;
	static int[] dr = {-1, 1, 0, 0, -1, -2, -2, -1, 1, 2, 2, 1};	// 상하좌우, 말처럼 이동
	static int[] dc = {0, 0, -1, 1, -2, -1, 1, 2, -2, -1, 1, 2};
	static int[] dk = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		v = new int[H][W][K + 1];	// map[r][c][k] -> map[r][c]에 말처럼 k번 이동해서 도착
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		
		int min = Integer.MAX_VALUE;
		for (int k = 0; k <= K; k++) {
			if (v[H - 1][W - 1][k] != 0)
				min = Math.min(min, v[H - 1][W - 1][k]);
		}
		if (W == 1 && H == 1) System.out.println(0);	// 출발점과 도착점이 같은 경우
		else if (min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}

	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0, 0, 0});
		v[0][0][0] = 0;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 12; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				int nk = cur[2] + dk[d];	// dk[d] : 상하좌우 이동일 때는 0, 말처럼 이동할 때는 1
				if (nr < 0 || nr >= H || nc < 0 || nc >= W || map[nr][nc] == 1 || nk > K) continue;
				if (v[nr][nc][nk] == 0) {
					v[nr][nc][nk] = v[cur[0]][cur[1]][cur[2]] + 1;
					q.add(new int[] {nr, nc, nk});					
				}
			}
		}
	}

}
