package _10_1027;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 뱀
public class Main_BOJ_3190 {

	static int N, K, L;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};	// 상하좌우
	static int[] dc = {0, 0, -1, 1};
	static int[][] dir;
	static final int UP = 0;
	static final int DOWN = 1;
	static final int LEFT = 2;
	static final int RIGHT = 3;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		map[0][0] = 1;	// 뱀
		LinkedList<int[]> snakes = new LinkedList<>();
		snakes.add(new int[] {0, 0});
		
		K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r - 1][c - 1] = 2;	// 사과
		}
		
		// 방향 정보 저장
		L = Integer.parseInt(br.readLine());
		dir = new int[L][2];
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			dir[i][0] = time;
			dir[i][1] = c;
		}
		
		int time = 0;
		int nr = 0;
		int nc = 0;
		int d = RIGHT;
		int idx = 0;
		int[] curDir = dir[idx];
		while (++time > 0) {
			nr += dr[d];
			nc += dc[d];
			
			// 벽 또는 자기자신의 몸과 부딪히면 게임이 끝남
			if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == 1) break;
			
			// 먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
			snakes.offerFirst(new int[] {nr, nc});
			
			if (map[nr][nc] == 0) {
				// 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
				int[] tmp = snakes.pollLast();
				map[tmp[0]][tmp[1]] = 0;
			}
			
			// 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
			map[nr][nc] = 1;
			
			// 뱀의 방향 정보가 들어온 경우
			if (curDir[0] == time) {
				char nxtDir = (char)curDir[1];
				d = changeDir(d, nxtDir);
				if (idx < L - 1)
					curDir = dir[++idx];
			}
		}
		System.out.println(time);
	}


	private static int changeDir(int curDir, char nxtDir) {
		if (curDir == UP) {
			if (nxtDir == 'L') {
				return LEFT;
			} else {
				return RIGHT;
			}
		} else if (curDir == DOWN) {
			if (nxtDir == 'L') {
				return RIGHT;
			} else {
				return LEFT;
			}
		} else if (curDir == LEFT) {
			if (nxtDir == 'L') {
				return DOWN;
			} else {
				return UP;
			}
		} else {
			if (nxtDir == 'L') {
				return UP;
			} else {
				return DOWN;
			}
		}
	}

}
