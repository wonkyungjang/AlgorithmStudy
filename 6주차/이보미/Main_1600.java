import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 최단 경로를 찾는 문제는 bfs
public class Main_1600 {

	static int K, W, H;
	static int [][] map;
	static boolean [][][] visit;
	static int [] dr = {-1, 1, 0, 0};
	static int [] dc = {0, 0, -1, 1};
	static int [] hdr = {-2, -2, 2, 2, -1, 1, -1, 1};
	static int [] hdc = {-1, 1, -1, 1, -2, -2, 2, 2};
	static int result;
	
	static class position {
		int r;
		int c;
		int cnt;
		int k;
		
		public position(int r, int c, int cnt, int k) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.k = k;
		}	
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		visit = new boolean[H][W][K+1];
		
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		result = -1;
		bfs();
		
		System.out.println(result);

	}

	private static void bfs() {
		Queue<position> que = new LinkedList<>();
		que.offer(new position(0, 0, 0, 0));
		visit[0][0][0] = true;
		
		while(!que.isEmpty()) {
			position cur = que.poll();
			
			if(cur.r == H-1 && cur.c == W-1) {
				result = cur.cnt;
				break;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				if(nr >= 0 && nc >= 0 && nr < H && nc < W && !visit[nr][nc][cur.k] && map[nr][nc] == 0) {
                    visit[nr][nc][cur.k] = true;
                    que.offer(new position(nr, nc, cur.cnt + 1, cur.k));
                }
			}
			
			if(cur.k < K) {
                for (int d = 0; d < 8; d++) {
                    int nr = cur.r + hdr[d];
                    int nc = cur.c + hdc[d];
                    
                    if(nr >= 0 && nc >= 0 && nr < H && nc < W && !visit[nr][nc][cur.k+1] && map[nr][nc] == 0) {
                        visit[nr][nc][cur.k+1] = true;
                        que.offer(new position(nr, nc, cur.cnt + 1, cur.k + 1));
                    }
                }
            }

		}
		
	}

}
