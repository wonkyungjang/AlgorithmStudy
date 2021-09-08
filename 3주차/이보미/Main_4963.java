import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4963 {

	static int w;
	static int h;
	static int [][] map;
	static boolean [][] visit;
	static int [] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int [] dc = {0, 0, -1, 1, -1, 1, -1, 1};
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0) {
				break;
			}
			
			map = new int[h][w];
			visit = new boolean[h][w];
			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			cnt = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(map[i][j] == 1 && !visit[i][j]) {
						dfs(i, j);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
		}
	}

	private static void dfs(int r, int c) {
		visit[r][c] = true;
		
		for (int d = 0; d < 8; d++) {
			if(check(r+dr[d], c+dc[d])) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(map[nr][nc] == 1 && !visit[nr][nc]) {
					dfs(nr, nc);
				}
			}
		}
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<h && c>=0 && c<w;
	}

}
