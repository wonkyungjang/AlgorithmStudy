package _05_0924;

import java.util.PriorityQueue;
import java.util.Scanner;

// 별자리 만들기
public class Main_BOJ_4368 {
	
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

	static int N;
	static double[][] star;
	static int[] p;
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		star = new double[N][2];
		p = new int[N];
		for (int i = 0; i < N; i++) {
			star[i][0] = sc.nextDouble();
			star[i][1] = sc.nextDouble();
			// 각각의 별 사이의 거리를 계산해서 간선리스트에 추가
			for (int j = 0; j < i; j++) {
				double dist = Math.sqrt(Math.pow(star[i][0] - star[j][0], 2) + Math.pow(star[i][1] - star[j][1], 2));
				pq.add(new Edge(i, j, dist));
				pq.add(new Edge(j, i, dist));
			}
		}
		
		// MST
		for (int i = 0; i < N; i++) p[i] = i;
		int cnt = 0;
		double ans = 0;
		while (!pq.isEmpty()) {
			if (cnt == N - 1) break;
			Edge cur = pq.poll();
			if (find(cur.start) == find(cur.end)) continue;
			union(cur.start, cur.end);
			ans += cur.dist;
			cnt++;
		}
		System.out.printf("%.2f", ans);
	}
	
	public static void union(int a, int b) {
		p[find(a)] = find(b);
	}
	
	public static int find(int a) {
		if (p[a] == a) return a;
		return p[a] = find(p[a]);
	}

}
