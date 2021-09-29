import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636 {

	static int r, c;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	static boolean check(int x, int y) {
		if (x >= 0 && y >= 0 && x < r && y < c) return true;
		else return false;
	}
	
	static int bfs() {
		int[][] tmap = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				tmap[i][j] = map[i][j];
			}
		}
		Queue<Point> que = new LinkedList<>();
		que.offer(new Point(0, 0));
		visited[0][0] = true;
		int num = 0;
		while (que.size() > 0) {
			Point cp = que.poll();
			for (int i = 0; i < 4; i++) {
				int cx = cp.x + dx[i];
				int cy = cp.y + dy[i];
				if (check(cx, cy) && !visited[cx][cy]) {
					visited[cx][cy] = true;
					if (map[cx][cy] == 0) que.offer(new Point(cx, cy));
					else {
						num++;
						tmap[cx][cy] = 0;
					}
				}
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				map[i][j] = tmap[i][j];
			}
		}
		return num;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		r = Integer.parseInt(stn.nextToken());
		c = Integer.parseInt(stn.nextToken());
		
		map = new int[r][c];
		for (int i = 0; i < r; i++) {
			stn = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(stn.nextToken());
			}
		}
		
		int num = 0;
		int pnum = 0;
		int time = 0;
		while (true) {
			visited = new boolean[r][c];
			num = bfs();
			if (num == 0) break;
			time++;
			pnum = num;
		}
		System.out.println(time);
		System.out.println(pnum);
	}

}
