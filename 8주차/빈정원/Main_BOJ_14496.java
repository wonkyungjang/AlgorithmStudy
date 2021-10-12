package _08_1013;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 그대, 그머가 되어
public class Main_BOJ_14496 {
	
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
	
	static int a, b, N, M;
	static ArrayList<Edge>[] adjList;
	static int[] dist;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N + 1];
		dist = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<Edge>();
			dist[i] = Integer.MAX_VALUE;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			adjList[start].add(new Edge(end, 1));
			adjList[end].add(new Edge(start, 1));
		}
		
		System.out.println(dijkstra(a));
	}

	private static int dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.add(new Edge(start, 0));
		
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if (cur.id == b) {
				return dist[cur.id];
			}
			
			if (dist[cur.id] > cur.cost) continue;
			
			for (Edge nxt : adjList[cur.id]) {
				if (dist[nxt.id] > cur.cost + nxt.cost) {
					dist[nxt.id]= cur.cost + nxt.cost;
					pq.add(new Edge(nxt.id, dist[nxt.id]));
				}
			}
		}
		return -1;
	}
}
