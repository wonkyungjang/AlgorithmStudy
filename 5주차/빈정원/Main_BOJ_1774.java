package _05_0924;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 우주신과의 교감
public class Main_BOJ_1774 {

	static class Edge implements Comparable<Edge> {
		int start, end;
		double dist;

		public Edge(int start, int end, double dist) {
			this.start = start;
			this.end = end;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge e) {
			return Double.compare(this.dist, e.dist);
		}
	}
	
	static int N, M;
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	static int[] p;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] v = new int[N + 1][2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			v[i][0] = Integer.parseInt(st.nextToken());
			v[i][1] = Integer.parseInt(st.nextToken());
			for (int j = 1; j < i; j++) {
				double dist = Math.sqrt(Math.pow(v[i][0] - v[j][0], 2) + Math.pow(v[i][1] - v[j][1], 2));
				pq.add(new Edge(i, j, dist));
				pq.add(new Edge(j, i, dist));
			}
		}
		
		// MST
		p = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}
		
		// 이미 연결된 통로 union
		double sum = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			union(x, y);
			sum += Math.sqrt(Math.pow(v[x][0] - v[x][0], 2) + Math.pow(v[y][1] - v[y][1], 2));
		}
		
		while (!pq.isEmpty()) {
			if (M == N - 1) break;
			Edge cur = pq.poll();
			if (find(cur.start) == find(cur.end)) continue;
			union(cur.start, cur.end);
			sum += cur.dist;
			M++;
		}
		
		System.out.printf("%.2f", sum);
	}

	public static void union(int a, int b) {
		p[find(a)] = find(b);
	}

	public static int find(int a) {
		if (p[a] == a) return a;
		return p[a] = find(p[a]);
	}

}
