import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17144 {

	static int R, C, T;
	static int [][] map;
	static int [][] temp;
	static int [] dr1 = {-1, 0, 1, 0};
	static int [] dc1 = {0, 1, 0, -1};
	static int [] dr2 = {1, 0, -1, 0};
	static int [] dc2 = {0, 1, 0, -1};
	static int cleanerX;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		temp = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) {
					temp[i][j] = -1;
					cleanerX = i;
					
				}
			}
		}
		
		for (int t = 0; t < T; t++) {
			
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(map[i][j] != 0 && map[i][j] != -1) {
						spread(i, j);
					}
				}
			}
			
			for (int i = 0; i < R; i++) {
				System.arraycopy(temp[i], 0, map[i], 0, map[i].length);
			}
			
			temp = new int[R][C];
			temp[cleanerX][0] = -1;
			temp[cleanerX-1][0] = -1;
			
			cycle();
		}
	
		int result = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] != -1) {
					result += map[i][j];
				}
			}
		}
		
		System.out.println(result);
		
	}

	private static void cycle() {
		int d = 0;
		int stop = cleanerX;
		int r = cleanerX-1;
		int c = 0;
		while(d<4) {
			int nr = r + dr1[d];
			int nc = c + dc1[d];
			if(nr >= 0 && nr < stop && nc >= 0 && nc < C && map[nr][nc] != -1) {
				if(map[r][c] == -1) {
					map[nr][nc] = 0;
				}else {
					map[r][c] = map[nr][nc];
					map[nr][nc] = 0;
				}
				r = nr;
				c = nc;
			}else {
				d++;
			}
		}
		
		d = 0;
		r = cleanerX;
		c = 0;
		while(d<4) {
			int nr = r + dr2[d];
			int nc = c + dc2[d];
			if(nr >= stop && nr < R && nc >= 0 && nc < C && map[nr][nc] != -1) {
				if(map[r][c] == -1) {
					map[nr][nc] = 0;
				}else {
					map[r][c] = map[nr][nc];
					map[nr][nc] = 0;
				}
				r = nr;
				c = nc;
			}else {
				d++;
			}
		}
	}

	private static void spread(int r, int c) {
		int cnt = 0;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr1[d];
			int nc = c + dc1[d];
			if(nr>=0 && nr<R && nc>=0 && nc<C && map[nr][nc] != -1) {
				temp[nr][nc] += (map[r][c]/5);
				cnt++;
			}
		}
		temp[r][c] += (map[r][c] - (map[r][c]/5)*cnt);
	}
	
}
