import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14500 {

	static int n, m;
	static int[][] map;
	static int max;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static boolean[][] visited;
	
	static boolean check(int x, int y) {
		if (x < n && y < m && x >= 0 && y >= 0) return true;
		else return false;
	}
	
	public static void dfs(int x, int y, int k, int sum) {
		visited[x][y] = true;
		if (k == 4) {
			if (max < sum) max = sum;
			return;
		}
		for (int i = 0; i < 4; i++) {
			int cx = x+dx[i];
			int cy = y+dy[i];
			if (check(cx, cy) && !visited[cx][cy]) {
				dfs(cx, cy, k+1, sum+map[cx][cy]);
				visited[cx][cy] = false;
			}
		}
		visited[x][y] = false;
	}
	
	public static void fcase(int x, int y, int s) { 
		for (int i = 0; i < 4; i++) {
			int sum = s;
			for (int j = 0; j < 3; j++) {
				int cx = x+dx[(i+j)%4];
				int cy = y+dy[(i+j)%4];
				if (check(cx, cy)) {
					sum += map[cx][cy]; 
				}
				else break;
				if (j == 2 && max < sum) max = sum; 
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stn.nextToken());
		m = Integer.parseInt(stn.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			stn = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(stn.nextToken());
			}
		}
		max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dfs(i, j, 1, map[i][j]);
				fcase(i, j, map[i][j]);
			}
		}
		System.out.println(max);
	}

}
