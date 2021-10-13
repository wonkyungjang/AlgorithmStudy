package _08_1013;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 녹색 옷 입은 애가 젤다지?
public class Main_BOJ_4485 {
	
	static class Edge implements Comparable<Edge> {
		int r, c, cost;

		public Edge(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge e) {
			return Integer.compare(this.cost, e.cost);
		}
	}

	static int N;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] dist;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 0;
		while (++t > 0) {
			N = Integer.parseInt(br.readLine());
			if (N == 0) break;
			map = new int[N][N];
			dist = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			
			System.out.println("Problem " + t + ": " + dijkstra());
		}
	}

	private static int dijkstra() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		dist[0][0] = map[0][0];
		pq.add(new Edge(0, 0, dist[0][0]));
		
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if (cur.r == N - 1 && cur.c == N - 1)
				return dist[cur.r][cur.c];
			
			if (cur.cost > dist[cur.r][cur.c]) continue;
			
			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if (dist[nr][nc] > cur.cost + map[nr][nc]) {
					dist[nr][nc] = cur.cost + map[nr][nc];
					pq.add(new Edge(nr, nc, dist[nr][nc]));
				}
			}
		}
		
		return 0;
	}

}
