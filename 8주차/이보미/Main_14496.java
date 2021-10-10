import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 그대, 그머가 되어
public class Main_14496 {

	static int a, b;
	static int n, m;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	static int [] d;
	static final int INF = Integer.MAX_VALUE;
	
	static class Node implements Comparable<Node> {
		int index;
		int distance;
		
		public Node(int index, int distance) {
			super();
			this.index = index;
			this.distance = distance;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.distance, o.distance);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// 그래프 초기화
		for (int i = 0; i < n+1; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		// 간선 정보 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			graph.get(start).add(new Node(end, 1));
			graph.get(end).add(new Node(start, 1));
		}
		
		// 최단 거리 테이블 초기화
		d = new int[n+1];
		Arrays.fill(d, INF);
		
		// 다익스트라 알고리즘 수행
		dijkstra(a);
		
		if(d[b] == INF) {
			System.out.println(-1);
		}else {
			System.out.println(d[b]);
		}
	}

	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		d[start] = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int dist = node.distance;
			int cur = node.index;
			
			if(d[cur] < dist) continue;
			
			for (int i = 0; i < graph.get(cur).size(); i++) {
				int cost = d[cur] + graph.get(cur).get(i).distance;
				
				if(cost < d[graph.get(cur).get(i).index]) {
					d[graph.get(cur).get(i).index] = cost;
					pq.offer(new Node(graph.get(cur).get(i).index, cost));
				}
			}
		}
	}

}
