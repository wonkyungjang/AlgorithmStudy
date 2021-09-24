import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_4386 {
	
	static int N, M;
	static int[] parent;
	static ArrayList<Edge> edge;
	
	static class Star {
		double x;
		double y;
		
		public Star(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int a;
		int b;
		double w;
		
		public Edge(int a, int b, double w) {
			this.a = a;
			this.b = b;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			if (this.w - o.w >= 0) return 1;
			return -1;
		}
	}
	
	static void union(int a, int b) {
		int ar = find(a);
		int br = find(b);
		if (ar != br) parent[br] = ar;
		else return;
	}
	
	static int find(int a) {
		if (a == parent[a]) return a;
		return parent[a] = find(parent[a]);
	}
	
	static double dist(double x, double y, double xx, double yy) {
		return Math.sqrt((x-xx)*(x-xx) + (y-yy)*(y-yy));
	}
	
	static double Kruskal() {
		double minCost = 0;
		int cnum = 0;
		for (int i = 0; i < edge.size(); i++) {
			int a = edge.get(i).a;
			int b = edge.get(i).b;
			if (find(a) != find(b)) {
				union(a, b);
				minCost += edge.get(i).w;
				cnum++;
			}
			if (cnum == N-1) break;
		}
		
		return minCost;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		parent = new int[N];
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
		
		Star[] star = new Star[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer stn = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(stn.nextToken());
			double y = Double.parseDouble(stn.nextToken());
			star[i] = new Star(x, y);
		}
		
		edge = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				double d = dist(star[i].x, star[i].y, star[j].x, star[j].y);
				edge.add(new Edge(i, j, d));
			}
		}
		
		Collections.sort(edge);
		
		System.out.println(Kruskal());
	}

}
