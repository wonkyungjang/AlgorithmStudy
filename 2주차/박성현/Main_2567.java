import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2567 {
	
	static int[][] mp;
	static int n;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static boolean[][] visited = new boolean[102][102];
	
	public static boolean check(int x, int y) {
		if (x < 102 && y < 102 && x >= 0 && y >= 0) return true;
		else return false;
	}
	public static int bfs(int x, int y) {
		Queue<Point> que = new LinkedList<>();
		que.offer(new Point(x, y));
		int cnt = 0;
		visited[x][y] = true;
		while (que.size() > 0) {
			Point t = que.poll();
			for (int i = 0; i < 4; i++) {
				if (check(t.x+dx[i], t.y+dy[i]) && !visited[t.x+dx[i]][t.y+dy[i]]) {
					if (mp[t.x+dx[i]][t.y+dy[i]] == 0) {
						que.offer(new Point(t.x+dx[i], t.y+dy[i]));
						visited[t.x+dx[i]][t.y+dy[i]] = true;
					}
					else cnt++;
				}
			}
		}
		
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		mp = new int[102][102];
		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer stn = new StringTokenizer(br.readLine());
			int cx = Integer.parseInt(stn.nextToken());
			int cy = Integer.parseInt(stn.nextToken());
			for (int r = 0; r < 10; r++) {
				for (int c = 0; c < 10; c++) {
					mp[cx+r+1][cy+c+1] = 1;
				}
			}
		}
		int sum = 0;
		for (int r = 0; r < 102; r++) {
			for (int c = 0; c < 102; c++) {
				if (mp[r][c] == 0 && !visited[r][c]) {
					sum += bfs(r, c);
				}
			}
		}
		System.out.println(sum);
	}

}
