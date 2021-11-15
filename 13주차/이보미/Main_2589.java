import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 보물섬
public class Main_2589 {
	
	static int N, M;
	static char [][] map;
	static int [] dr = {-1, 1, 0, 0};
	static int [] dc = {0, 0, -1, 1};
	static int max = Integer.MIN_VALUE;
	
	static class Info {
		int r;
		int c;
		
		public Info(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 'L') {
					bfs(i, j);
				}
			}
		}
		
		System.out.println(max-1);
	}

	private static void bfs(int r, int c) {
		int [][] temp = new int[N][M];
		
		Queue<Info> que = new LinkedList<>();
		que.add(new Info(r, c));
		temp[r][c] = 1;
		
		while(!que.isEmpty()) {
			Info cur = que.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc<M) {
					if(map[nr][nc] == 'L' && temp[nr][nc] == 0) {
						que.add(new Info(nr, nc));
						temp[nr][nc] = temp[cur.r][cur.c] + 1;
					}
				}
			}
		}
		
		int cur_max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				cur_max = Math.max(cur_max, temp[i][j]);
			}
		}
		
		max = Math.max(cur_max, max);
	}
}
