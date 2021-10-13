package _08_1013;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 알고스팟
public class Main_BOJ_1261 {

	static class Edge implements Comparable<Edge> {
		int id, cost;

		public Edge(int id, int cost) {
			this.id = id;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge e) {
			return Integer.compare(this.cost, e.cost);
		}
		
	}
	
	static int M, N;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static ArrayList<Edge>[] adjList;
	static int[] dist;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		adjList = new ArrayList[N * M];
		dist = new int[N * M];
		for (int i = 0; i < N * M; i++) {
			adjList[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str.charAt(j) + "");
			}
		}
		
		mapToGraph();
		
		dijkstra();
		
		System.out.println(dist[N * M - 1]);

	}

	private static void dijkstra() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(0, 0));
		dist[0] = 0;
		
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if (cur.id == N * M - 1) break;
			
			if (dist[cur.id] < cur.cost) continue;
			
			for (Edge nxt : adjList[cur.id]) {
				if (dist[nxt.id] > cur.cost + nxt.cost) {
					dist[nxt.id] = cur.cost + nxt.cost;
					pq.add(new Edge(nxt.id, dist[nxt.id]));
				}
			}
		}
		
	}

	private static void mapToGraph() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
					adjList[r * M + c].add(new Edge(nr * M + nc, map[nr][nc]));
				}
			}
		}
	}

}
