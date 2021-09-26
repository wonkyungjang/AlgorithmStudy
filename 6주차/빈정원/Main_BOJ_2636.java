package _06_0929;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 치즈
public class Main_BOJ_2636 {

	static int R, C, restCheese;
	static int[][] map;
	static Queue<int[]> q = new LinkedList<>();
	static boolean[][] v;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		v = new boolean[R][C];
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (r == 0 || r == R - 1 || c == 0 || c == C - 1) {
					map[r][c] = -1;		// 테두리(공기와 접촉된 칸)를 치즈의 구멍과 구별하기 위해 -1로 초기화
					v[r][c] = true;
				} else if (map[r][c] == 1) {
					restCheese++;	// 전체 치즈 개수 미리 세기
				}
			}
		}

		int time = 0;
		int last = 0;
		while (restCheese > 0) {
			time++;
			fillAir();			// 공기와 접촉된 칸을 모두 -1로 채우기
			last = restCheese;	// 남아있는 치즈조각 계속 갱신
			meltCheese();		// 치즈 녹이기
		}
		System.out.printf("%d\n%d", time, last);
	}
	
	public static void meltCheese() {
		int[][] copy = new int[R][C];
		for (int r = 0; r < R; r++)
			copy[r] = Arrays.copyOf(map[r], C);
		
		for (int r = 1; r < R - 1; r++) {
			for (int c = 1; c < C - 1; c++) {
				boolean isMelt = false;
				if (copy[r][c] == 1) {	// 현재 칸이 치즈일 때
					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if (copy[nr][nc] == -1) {	// 상하좌우 중 한 칸이라도 공기면 녹음
							isMelt = true;
							break;
						}
					}
					if (isMelt) {	// 공기로 채우기
						map[r][c] = -1;
						v[r][c] = true;
						restCheese--;
					}
				}
			}
		}
	}

	public static void fillAir() {
		// 이미 공기인 부분들을 큐에 넣고 bfs 시작
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == -1) {
					v[r][c] = true;
					q.add(new int[] {r, c});
				}
			}
		}
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] != 0) continue;
				map[nr][nc] = -1;	// 비어있는 부분을 공기로 채움
				q.add(new int[] {nr, nc});
			}
		}
	}

}
