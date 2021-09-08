import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4963 {
	
	static int w, h;
	static int[][] mp;
	static boolean[][] visited;
	static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
	static int[] dy = {0, 0, 1, -1, 1, -1, -1, 1};
	
	public static boolean check(int x, int y) {
		if (x < h && y < w && x >= 0 && y >= 0) return true;
		else return false;
	}
	
	public static void bfs(int x, int y) {
		Queue<Point> que = new LinkedList<>();
		que.offer(new Point(x, y));
		visited[x][y] = true;
		while (que.size() > 0) {
			Point t = que.poll();
			for (int i = 0; i < 8; i++) {
				int cx = t.x+dx[i];
				int cy = t.y+dy[i];
				if (check(cx, cy) && !visited[cx][cy] && mp[cx][cy] == 1) {
					que.offer(new Point(cx, cy));
					visited[cx][cy] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer stn = new StringTokenizer(br.readLine());
			w = Integer.parseInt(stn.nextToken());
			h = Integer.parseInt(stn.nextToken());
			if (w == 0 && h == 0) break;
			mp = new int[h][w];
			visited = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				stn = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					mp[i][j] = Integer.parseInt(stn.nextToken());
				}
			}
			int cnt = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!visited[i][j] && mp[i][j] == 1) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}

}
