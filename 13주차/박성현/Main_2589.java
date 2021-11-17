import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2589 {

	static int n, m;
	static char[][] map;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int max;
	
	static class Land {
		int x;
		int y;
		int k;
		
		public Land(int x, int y, int k) {
			this.x = x;
			this.y = y;
			this.k = k;
		}
	}
	
	static boolean check(int x, int y) {
		if (x < n && y < m && x >= 0 && y >= 0) return true;
		else return false;
	}
	
	static int bfs(int x, int y, boolean[][] visited) {
		Queue<Land> que = new LinkedList<>();
		visited[x][y] = true;
		que.offer(new Land(x, y, 0));
		int md = 0;
		while (!que.isEmpty()) {
			Land cl = que.poll();
			md = cl.k;
			for (int i = 0 ; i < 4; i++) {
				int cx = cl.x + dx[i];
				int cy = cl.y + dy[i];
				if (check(cx, cy) && map[cx][cy] == 'L' && !visited[cx][cy]) {
					visited[cx][cy] = true;
					que.offer(new Land(cx, cy, md+1));
				}
			}
			
		}
		return md;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stn.nextToken());
		m = Integer.parseInt(stn.nextToken());
		map = new char[n][m];
		for (int i = 0; i < n; i++) {
			String l = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = l.charAt(j);
			}
		}
		max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'L') {
					int md = bfs(i, j, new boolean[n][m]);
					if (max < md) max = md;
				}
			}
		}
		System.out.println(max);

	}

}
