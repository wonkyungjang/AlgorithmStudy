import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import sun.awt.EventQueueDelegate;

public class Main_1197 {

	static int N;
	static int E;
	static int [] parents;
	
	static class Edge implements Comparable<Edge> {

		int start;
		int end;
		int weight;
		
		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight-o.weight;
		}
		
	}
	
	static Edge [] edgeList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		edgeList = new Edge[E];
		parents = new int[N+1];
		
		for (int i = 1; i < N+1; i++) {
			parents[i] = i;
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			edgeList[i] = new Edge(start, end, weight);
		}
		
		Arrays.sort(edgeList);
		
		int result = 0;
		int cnt = 0;
		for (Edge edge : edgeList) {
			if(union(edge.start, edge.end)) {
				result += edge.weight;
				if(++cnt == N-1) break; // 최소신장트리의 간선의 개수는 정점-1개이므로 더 찾아보지 않도록 break
			}
		}

		System.out.println(result);
	}
	
	private static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		else {
			if(aRoot < bRoot) {
				parents[bRoot] = aRoot;
			}else {
				parents[aRoot] = bRoot;
			}
			return true;
		}
	}

}
