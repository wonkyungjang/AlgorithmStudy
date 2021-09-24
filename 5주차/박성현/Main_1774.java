import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1774 {

	static int N, M;
	static int[] parent;
	static ArrayList<Edge> edge;
	
	static int find(int a) {
		if (a == parent[a]) return a;
		return parent[a] = find(parent[a]);
	}
	
	static void union(int a, int b) {
		int ar = find(a);
		int br = find(b);
		parent[ar] = br;
	}
	
	static double dist(int x, int y, int xx, int yy) {
		return Math.sqrt((double)(x-xx)*(x-xx) + (double)(y-yy)*(y-yy));
	}
	
	static class Edge implements Comparable<Edge>{
		int a;
		int b;
		double d;
		
		public Edge(int a, int b, double d) {
			this.a = a;
			this.b = b;
			this.d = d;
		}
		
		@Override
		public int compareTo(Edge o) {
			if (this.d - o.d >= 0) return 1;
			return -1;
		}
	}
	
	static double Kruskal() {
		double cost = 0;
		int cnum = 0;
		for (int i = 0; i < edge.size(); i++) {
			int a = find(edge.get(i).a);
			int b = find(edge.get(i).b);
			if (a != b) {
				union(a, b);
				cost += edge.get(i).d;
				cnum++;
			}
			if (cnum == N-M-1) break;
		}
		return cost;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stn.nextToken());
		M = Integer.parseInt(stn.nextToken());
		Point[] gods = new Point[N+1];
		parent = new int[N+1];
		for (int i = 0; i < N+1; i++) {
			parent[i] = i;
		}
		for (int i = 1; i < N+1; i++) {
			stn = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(stn.nextToken());
			int y = Integer.parseInt(stn.nextToken());
			gods[i] = new Point(x, y);
		}
		edge = new ArrayList<>();
		for (int i = 1; i < N+1; i++) {
			for (int j = i+1; j < N+1; j++) {
				double d = dist(gods[i].x, gods[i].y, gods[j].x, gods[j].y);
				edge.add(new Edge(i, j, d));
			}
		}
		Collections.sort(edge);
		for (int i = 0; i < M; i++) {
			stn = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stn.nextToken());
			int b = Integer.parseInt(stn.nextToken());
			union(a, b);
		}
		System.out.printf("%.2f\n", Kruskal());

	}

}
