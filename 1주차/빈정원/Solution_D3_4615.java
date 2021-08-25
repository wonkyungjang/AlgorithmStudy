package _01_0825;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 재미있는 오셀로 게임
public class Solution_D3_4615 {
	
	static int T, N, M, blackCnt, whiteCnt;
	static int board[][];
	static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};	// 상, 하, 좌, 우,
	static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};	// 좌상, 우상, 좌하, 우하
	static final int BLACK = 1;
	static final int WHITE = 2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			board = new int[N + 1][N + 1];
			// 처음 4개 놓기
			board[N / 2][N / 2] = WHITE;
			board[N / 2 + 1][N / 2 + 1] = WHITE;
			board[N / 2 + 1][N / 2] = BLACK;
			board[N / 2][N / 2 + 1] = BLACK;
			blackCnt = 2;
			whiteCnt = 2;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				board[r][c] = Integer.parseInt(st.nextToken());
				if (board[r][c] == BLACK) blackCnt++;
				else whiteCnt++;
				go(r, c);
			}
			System.out.println("#" + t + " " + blackCnt + " " + whiteCnt);
		}
		
	}

	public static void print() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void go(int r, int c) {
		int color = board[r][c];
		// 8방 탐색
		for (int d = 0; d < 8; d++) {
			int i = 0;
			while (true) {
				i++;
				int nr = r + dr[d] * i;
				int nc = c + dc[d] * i;
				// board를 벗어나거나 비어있는 칸이면 다음 방향 탐색
				if (nr <= 0 || nr > N || nc <= 0 || nc > N || board[nr][nc] == 0) break;
				// 같은색을 찾으면 되돌아가면서 색을 바꾸기
				if (board[nr][nc] == color) {
					// 같은색을 찾았으므로 한칸전으로 돌아가기 위해 --i부터 시작
					// i == 0일 때는 같은색이므로 0보다 클 때까지 이동
					while (--i > 0) {
						nr -= dr[d];
						nc -= dc[d];
						board[nr][nc] = color;
						if (color == BLACK) {
							whiteCnt--;
							blackCnt++;
						} else {
							blackCnt--;
							whiteCnt++;
						}
					}
					break;
				}
			}
		}
	}

}
