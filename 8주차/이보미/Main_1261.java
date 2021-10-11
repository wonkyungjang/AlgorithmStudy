import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 알고스팟
public class Main_1261 {

	static int N, M;
	static int [][] map;
	static int [][] dist;
	static int [] dr = {-1, 1, 0, 0};
	static int [] dc = {0, 0, -1, 1};
	static final int INF = Integer.MAX_VALUE;
	static int result;
	
	static class Node implements Comparable<Node> {
		int r;
		int c;
		int cost;
		
		public Node(int r, int c, int cost) {
			super();
			this.r = r;
			this.c = c;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}	
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dist = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dist[i][j] = INF;
			}
		}
		
		dijkstra(0, 0);
		
		System.out.println(result);
	}
	
	private static void dijkstra(int r, int c) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(r, c, 0));
		dist[r][c] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(cur.r == N-1 && cur.c == M-1) {
				result = cur.cost;
				return;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				if(nr>=0 && nr<N && nc>=0 && nc<M) {
					if(dist[nr][nc] > dist[cur.r][cur.c] + map[nr][nc]) { // 현재 위치까지의 부순 벽의 개수 + 다음(상하좌우) 벽의 유무 < 다음 벽까지의 부순개수(INF라면 들리지 않은곳)
						dist[nr][nc] = dist[cur.r][cur.c] + map[nr][nc];
						pq.offer(new Node(nr, nc, dist[nr][nc]));
					}
				}
			}
		}
		
	}

}
