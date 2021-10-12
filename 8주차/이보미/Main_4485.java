import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 녹색 옷 입은 애가 젤다지?
public class Main_4485 {

	static int N;
	static int [][] map;
	static int [][] dist;
	static final int INF = Integer.MAX_VALUE;
	static int [] dr = {-1, 1, 0, 0};
	static int [] dc = {0, 0, -1, 1};
	static int rupee;
	static int cnt = 1;
	
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
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			N = Integer.parseInt(br.readLine());
			
			if(N == 0) break;
			
			map = new int[N][N];
			
			StringTokenizer st = null;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 최단 거리 테이블 초기화
			dist = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dist[i][j] = INF;
				}
			}
			
			// 다익스트라 알고리즘 수행
			dijkstra(0, 0);
			
			System.out.println("Problem "+cnt+": "+rupee);
			cnt++;
		}

	}

	private static void dijkstra(int r, int c) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		// 출발점 설정
		pq.offer(new Node(r, c, map[r][c]));
		dist[r][c] = map[r][c];
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(cur.r == N-1 && cur.c == N-1) {
				rupee = cur.cost;
				return;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				if(nr>=0 && nr<N && nc>=0 && nc<N) {
					if(dist[nr][nc] > map[nr][nc] + dist[cur.r][cur.c]) {
						dist[nr][nc] = map[nr][nc] + dist[cur.r][cur.c];
						pq.offer(new Node(nr, nc, dist[nr][nc]));
					}
				}
			}
		}
		
	}

}
