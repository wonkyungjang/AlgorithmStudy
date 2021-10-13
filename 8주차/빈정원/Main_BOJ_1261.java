package _08_1013;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 알고스팟
public class Main_BOJ_1261 {

	static class Edge implements Comparable<Edge> {
		int r, c, cost;

		public Edge(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge n) {
			return Integer.compare(this.cost, n.cost);
		}

	}
	
	static int M, N;
	static int[][] map;
	static int[][] dist;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dist = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str.charAt(j) + "");
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		
		dijkstra();
		
		System.out.println(dist[N - 1][M - 1]);

	}

	private static void dijkstra() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(0, 0, 0));
		dist[0][0] = 0;
		
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if (cur.r == N - 1 && cur.c == M - 1) break;
			
			if (dist[cur.r][cur.c] < cur.cost) continue;
			
			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if (dist[nr][nc] > cur.cost + map[nr][nc]) {
					dist[nr][nc] = cur.cost + map[nr][nc];
					pq.add(new Edge(nr, nc, dist[nr][nc]));
				}
			}
		}
	}

}
