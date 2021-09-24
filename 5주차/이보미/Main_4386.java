import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_4386 {
	
	static int n;
	static int [] parents;
	
	static class position {
		double x;
		double y;
		
		public position(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int start;
		int end;
		double distance;
		
		public Edge(int start, int end, double distance) {
			super();
			this.start = start;
			this.end = end;
			this.distance = distance;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.distance, o.distance);
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		position [] star = new position[n];
		parents = new int[n];
		ArrayList<Edge> edgeList = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			star[i] = new position(x, y);
		}

		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				double dist = Math.sqrt(Math.pow(star[i].x-star[j].x, 2)+Math.pow(star[i].y-star[j].y, 2));
				edgeList.add(new Edge(i, j, dist));
			}
		}
		
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
		
		Collections.sort(edgeList);
		
		double result = 0;
		int cnt = 0;
		for (Edge edge : edgeList) {
			if(union(edge.start, edge.end)) {
				result += edge.distance;
				if(++cnt == n-1) break;
			}
		}
		
		System.out.printf("%.2f", result);	
	}
	
	private static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA == rootB) {
			return false;
		}else {
			if(rootA < rootB) {
				parents[rootB] = rootA;
			}else {
				parents[rootA] = rootB;
			}
			return true;
		}
		
	}

}
