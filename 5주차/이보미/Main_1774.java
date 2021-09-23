import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1774 {
	
	static int N, M;
	static int [] parents;
	
	static class position {
		int x;
		int y;
		
		public position(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	static class Edge implements Comparable<Edge> {
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
			// TODO Auto-generated method stub
			return Double.compare(this.distance, o.distance);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		position [] star = new position[N+1];
		parents = new int[N+1];
		ArrayList<Edge> edgeList = new ArrayList<>();
		
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			star[i] = new position(x, y);
			parents[i] = i;
		}
	
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			union(start, end);
		}
		
		for (int i = 1; i < N+1; i++) {
			for (int j = i+1; j < N+1; j++) {
				double dist = Math.sqrt(Math.pow(star[i].x-star[j].x, 2)+Math.pow(star[i].y-star[j].y, 2));
				edgeList.add(new Edge(i, j, dist));
			}
		}
		
		Collections.sort(edgeList);

		int cnt = 0;
		double result = 0;
		for (Edge edge : edgeList) {
			if(union(edge.start, edge.end)) {
				result += edge.distance;
				if(++cnt == N-1-M) break;
			}
		}
		
		System.out.printf("%.2f", result);

	}

	private static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) {
			return false;
		}else {
			if(aRoot < bRoot) {
				parents[bRoot] = aRoot;
			}else {
				parents[aRoot] = bRoot;
			}
			return true;
		}
	}

}
