import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1197 {
	
	static int V, E;
	static int[] parent;
	
	static class Edge implements Comparable<Edge> {
		int a;
		int b;
		int w;
		
		public Edge(int a, int b, int w) {
			this.a = a;
			this.b = b;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
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

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		V = Integer.parseInt(stn.nextToken());
		E = Integer.parseInt(stn.nextToken());
		parent = new int[V+1];
		for (int i = 0; i < V+1; i++) {
			parent[i] = i;
		}
		Edge[] edge = new Edge[E];
		for (int i = 0; i < E; i++) {
			stn = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stn.nextToken());
			int b = Integer.parseInt(stn.nextToken());
			int w = Integer.parseInt(stn.nextToken());
			edge[i] = new Edge(a, b, w);
		}
		Arrays.sort(edge);
		long tw = 0;
		for (int i = 0; i < E; i++) {
			int a = find(edge[i].a);
			int b = find(edge[i].b);
			if (a != b) {
				union(a, b);
				tw += edge[i].w;
			}
		}
		System.out.println(tw);
	}

}
