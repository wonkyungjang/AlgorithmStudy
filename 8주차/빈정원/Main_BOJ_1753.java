package _08_1013;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 최단경로
public class Main_BOJ_1753 {
	
	static class Edge implements Comparable<Edge> {
		int id, cost;
		
		public Edge(int id, int cost) {
			this.id = id;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge e) {
			return this.cost - e.cost;
		}
	}
	
	static int V, E, K;
	static int u, v, w;
	static ArrayList<Edge>[] adjList;
	static int[] dist;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		adjList = new ArrayList[V + 1];
		dist = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			adjList[i] = new ArrayList<Edge>();
			dist[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			adjList[u].add(new Edge(v, w));
		}
		
		dijkstra(K);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			if (dist[i] == Integer.MAX_VALUE)
				sb.append("INF\n");
			else
				sb.append(dist[i] + "\n");
		}
		System.out.println(sb);
	}

	private static void dijkstra(int start) {
		// 출발지 비용을 0으로 하고 출발지를 PQ에 넣고 시작
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.add(new Edge(start, 0));
		
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			// 더 큰 가중치로 도착한 경우 continue
			if (cur.cost > dist[cur.id]) continue;
			
			// 현재 위치에 연결된 간선 탐색
			for (Edge nxt : adjList[cur.id]) {
				// cost가 더 작을때만 dist 갱신하고 PQ에 넣기
				if (dist[nxt.id] > cur.cost + nxt.cost) {
					dist[nxt.id] = cur.cost + nxt.cost;
					pq.add(new Edge(nxt.id, dist[nxt.id]));
				}
			}
		}
	}

}
