package _03_0908;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 미세먼지 안녕!
public class Main_BOJ_17144 {
	
	static int R, C, T;
	static int map[][];
	static int ac = -1;	// 공기청정기 위치
	static int dustSum;	// 미세먼지의 양
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1 && ac == -1) ac = i;	// 공기청정기 위치 저장
				else if (map[i][j] != -1 && map[i][j] != 0) dustSum += map[i][j];	// 초기 미세먼지양 계산
			}
		}
		while (T-- > 0) {
			moveDust();
			moveWind(new int[] {-1, 0, 1, 0}, new int[] {0, 1, 0, -1}, ac - 1, 0, 0, ac);			// 위쪽
			moveWind(new int[] {1, 0, -1, 0}, new int[] {0, 1, 0, -1}, ac + 2, 0, ac + 1, R - 1);	// 아래쪽
		}
		System.out.println(dustSum);
	}

	// dr, dc는 바람이 CW일 때 CCW, CCW일 때 CW
	public static void moveWind(int[] dr, int dc[], int r, int c, int rowMin, int rowMax) {
		if (map[r][c] != 0) dustSum -= map[r][c]; // 정화 (최대 1개이므로 미리 체크)
		
		for (int d = 0; d < 4; d++) {
			int idx = 0;
			while (++idx > 0) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr < rowMin || nr > rowMax || nc < 0 || nc >= C) break;	// 범위 벗어나면 방향 전환
				// 공기청정기를 만나면 끝
				if (map[nr][nc] == -1) {
					map[r][c] = 0;
					break;
				}
				// map에서 먼지 이동
				map[r][c] = map[nr][nc];
				r = nr;
				c = nc;
			}
		}
	}

	public static void moveDust() {
		int dr[] = {-1, 1, 0, 0};
		int dc[] = {0, 0, -1, 1};

		// 동시 확산 처리하기 위해 map 복사
		int tmpMap[][] = new int[R][C];
		for (int i = 0; i < R; i++) {
			tmpMap[i] = Arrays.copyOf(map[i], C);
		}
		
		for (int r = 0; r < R; r++)  {
			for (int c = 0; c < C; c++) {
				if (map[r][c] != 0 && map[r][c] != -1) {
					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if (nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == -1) continue;
						tmpMap[nr][nc] += map[r][c] / 5;
						tmpMap[r][c] -= map[r][c] / 5;
					}
				}
			}
		}
		map = tmpMap;
	}

}
