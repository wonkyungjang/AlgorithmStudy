import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636 {

	static int R, C;
	static int [][] map;
	static boolean [][] visit;
	static int [] dr = {-1, 1, 0, 0};
	static int [] dc = {0, 0, -1, 1};
	static int cheese, hour, cnt;
	
	static class Position {
		int r;
		int c;
		
		public Position(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		
		cheese = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					cheese++;
				}
			}
		}

		while(cheese != 0) {
			hour++;
			cnt = cheese;
			melting();
		}
	
		System.out.println(hour);
		System.out.println(cnt);
		
	}

	private static void melting() {
		Queue<Position> que = new LinkedList<>();
		que.offer(new Position(0, 0));
		visit = new boolean[R][C];
		visit[0][0] = true;
		
		while(!que.isEmpty()) {
			Position cur = que.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				if (nr < 0 || nr >= R || nc < 0 || nc >= C || visit[nr][nc]) continue;
				if (map[nr][nc] == 1) {
					cheese--;
					map[nr][nc] = 0;
				} else if (map[nr][nc] == 0) {
					que.offer(new Position(nr, nc));
				}
				visit[nr][nc] = true;
			}
		}
	}

}
