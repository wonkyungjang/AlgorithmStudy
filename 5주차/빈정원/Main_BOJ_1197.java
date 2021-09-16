package _05_0924;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 최소 스패닝 트리
public class Main_BOJ_1197 {

	static class Edge implements Comparable<Edge> {
		int start, end, cost;
		
		public Edge(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge e) {
			return this.cost - e.cost;
		}
	}
	
	static int V, E;
	static int[] p;
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		p = new int[V + 1];
		for (int i = 1; i <= V; i++) p[i] = i;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			pq.add(new Edge(start, end, cost));
		}
		
		int cnt = 0;
		int sum = 0;
		while (!pq.isEmpty()) {
			if (cnt == V - 1) break;
			Edge cur = pq.poll();
			if (find(cur.start) == find(cur.end)) continue;
			union(cur.start, cur.end);
			cnt++;
			sum += cur.cost;
		}
		System.out.println(sum);
	}

	public static void union(int a, int b) {
		p[find(a)] = find(b);
	}
	
	public static int find(int a) {
		if (p[a] == a) return a;
		return p[a] = find(p[a]);
	}
	
}
