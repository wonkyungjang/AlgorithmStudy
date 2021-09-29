import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600 {

	static int k, w, h;
	static int[][] map;
	static int[] dx = {1, -1, 0, 0, 1, 1, 2, 2, -1, -1, -2, -2};
	static int[] dy = {0, 0, 1, -1, 2, -2, 1, -1, 2, -2, 1, -1};
	static boolean[][][] visited;
	
	static class Node {
		int x;
		int y;
		int jn;
		int count;
		public Node(int x, int y, int jn, int count) {
			this.x = x;
			this.y = y;
			this.jn = jn;
			this.count = count;
		}
	}
	
	static boolean check(int x, int y) {
		if (x >= 0 && y >= 0 && x < h && y < w) return true;
		else return false;
	}
	
	static int bfs() {
		Queue<Node> que = new LinkedList<>();
		que.offer(new Node(0, 0, 0, 0));
		visited[0][0][0] = true;
		while (que.size() > 0) {
			Node cp = que.poll();
			if (cp.x == h-1 && cp.y == w-1) {
				return cp.count;
			}
			for (int i = 0; i < 12; i++) {
				int cx = cp.x + dx[i];
				int cy = cp.y + dy[i];
				if (i < 4) {
					if (check(cx, cy) && !visited[cx][cy][cp.jn] && map[cx][cy] == 0) {
						que.offer(new Node(cx, cy, cp.jn, cp.count+1));
						visited[cx][cy][cp.jn] = true;
					}
				}
				else if (cp.jn < k) {
					if (check(cx, cy) && !visited[cx][cy][cp.jn+1] && map[cx][cy] == 0) {
						que.offer(new Node(cx, cy, cp.jn+1, cp.count+1));
						visited[cx][cy][cp.jn+1] = true;
					}
				}
				else break;
			}
		}
		return -1;
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		StringTokenizer stn = new StringTokenizer(br.readLine());
		w = Integer.parseInt(stn.nextToken());
		h = Integer.parseInt(stn.nextToken());
		map = new int[h][w];
		visited = new boolean[h][w][k+1];
		
		for (int i = 0; i < h; i++) {
			stn = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(stn.nextToken());
			}
		}
		System.out.println(bfs());
	}

}
