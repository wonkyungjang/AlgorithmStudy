package _03_0908;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 섬의 개수
public class Main_BOJ_4963 {

	static int W, H, cnt;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};	// 8방 탐색
	static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			if (W == 0 && H == 0) break;
			map = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			boolean[][] v = new boolean[H][W];
			cnt = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					// 아직 방문하지 않은 땅이면 bfs
					if (map[i][j] == 1 && !v[i][j]) {
						bfs(i, j, v);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}

	public static void bfs(int r, int c, boolean[][] v) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r, c});
		v[r][c] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 8; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
				// 아직 방문하지 않은 땅인 경우 방문
				if (map[nr][nc] == 1 && !v[nr][nc]) {
					v[nr][nc] = true;
					q.add(new int[] {nr, nc});
				}
			}
		}
	}

}
