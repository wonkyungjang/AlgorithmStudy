package _11_1103;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 감시
public class Main_BOJ_15683 {
	
	static class CCTV {
		int r, c, type;

		public CCTV(int r, int c, int type) {
			this.r = r;
			this.c = c;
			this.type = type;
		}
	}

	static int N, M;
	static int min = Integer.MAX_VALUE;
	static int[][] map;
	static ArrayList<CCTV> cctvs = new ArrayList<>();
	static int[] typeCnt = {0, 4, 2, 4, 4, 1};
	static final int UP = 0;
	static final int DOWN = 1;
	static final int LEFT = 2;
	static final int RIGHT = 3;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (1 <= map[i][j] && map[i][j] <= 5) {
					cctvs.add(new CCTV(i, j, map[i][j]));
				}
			}
		}
		
		dfs(0, new int[cctvs.size()], cctvs.size());
		
		System.out.println(min);
	}

	private static void dfs(int cnt, int[] nums, int size) {
		if (cnt == size) {
			// map 복사
			int[][] copy = new int[N][M];
			for (int i = 0; i < N; i++) {
				copy[i] = Arrays.copyOf(map[i], M);
			}
			
			// 감시되는 구역 -1로 채우기
			for (int i = 0; i < size; i++) {
				watch(cctvs.get(i), nums[i]);
			}
			
			// 사각 지대의 최소 크기 구하기
			min = Math.min(min, getBlindSpot());
			
			// map 복원
			map = copy;
			
			return;
		}
		
		for (int i = 0; i < typeCnt[cctvs.get(cnt).type]; i++) {
			nums[cnt] = i;
			dfs(cnt + 1, nums, size);
		}
	}

	private static int getBlindSpot() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	private static void watch(CCTV cctv, int dir) {
		int r = cctv.r;
		int c = cctv.c;
		if (cctv.type == 1) {
			// 1번 CCTV인 경우 상/하/좌/우
			watch(r, c, dir);
		} else if (cctv.type == 2) {
			// 2번 CCTV인 경우 상하/좌우
			if (dir == 0) {
				watch(r, c, UP); watch(r, c, DOWN);
			} else if (dir == 1) {
				watch(r, c, LEFT); watch(r, c, RIGHT);
			}
		} else if (cctv.type == 3) {
			// 3번 CCTV인 경우 상좌/상우/하좌/하우
			if (dir == 0) {
				watch(r, c, UP); watch(r, c, LEFT);
			} else if (dir == 1) {
				watch(r, c, UP); watch(r, c, RIGHT);
			} else if (dir == 2) {
				watch(r, c, DOWN); watch(r, c, LEFT);
			} else if (dir == 3) {
				watch(r, c, DOWN); watch(r, c, RIGHT);
			}
		} else if (cctv.type == 4) {
			// 4번 CCTV일 경우 상하좌/상하우/상좌우/하좌우
			if (dir == 0) {
				watch(r, c, UP); watch(r, c, DOWN); watch(r, c, LEFT);
			} else if (dir == 1) {
				watch(r, c, UP); watch(r, c, DOWN); watch(r, c, RIGHT);
			} else if (dir == 2) {
				watch(r, c, UP); watch(r, c, LEFT); watch(r, c, RIGHT);
			} else if (dir == 3) {
				watch(r, c, DOWN); watch(r, c, LEFT); watch(r, c, RIGHT);
			}
		} else if (cctv.type == 5) {
			// 5번 CCTV일 경우 상하좌우
			watch(r, c, UP); watch(r, c, DOWN); watch(r, c, LEFT); watch(r, c, RIGHT);
		}
	}

	private static void watch(int r, int c, int dir) {
		if (dir == UP) {
			for (int i = r; i >= 0; i--) {
				if (map[i][c] == 6) break;
				else if (map[i][c] == 0) map[i][c] = -1;
			}
		} else if (dir == DOWN) {
			for (int i = r; i < N; i++) {
				if (map[i][c] == 6) break;
				else if (map[i][c] == 0) map[i][c] = -1;
			}
		} else if (dir == LEFT) {
			for (int i = c; i >= 0; i--) {
				if (map[r][i] == 6) break;
				else if (map[r][i] == 0) map[r][i] = -1;
			}
		} else if (dir == RIGHT) {
			for (int i = c; i < M; i++) {
				if (map[r][i] == 6) break;
				else if (map[r][i] == 0) map[r][i] = -1;
			}
		}
	}

}
