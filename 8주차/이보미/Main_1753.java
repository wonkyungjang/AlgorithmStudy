import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 최단 경로
// 다익스트라 : 한 노드에서 모든 노드로 가는 최단 경로 구할 수 있는 알고리즘
public class Main_1753 {

	static int V, E;
	static int K;
	static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
	static int [] dist;
	static final int INF = Integer.MAX_VALUE;
	
	static class Edge implements Comparable<Edge> {
		int index;
		int distance;
		
		public Edge(int index, int distance) {
			super();
			this.index = index;
			this.distance = distance;
		}

		@Override
		public int compareTo(Edge o) { // 거리(비용)가 짧은 것이 우선순위를 가지도록 설정
			return Integer.compare(this.distance, o.distance);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		// 그래프 초기화
		for (int i = 0; i < V+1; i++) {
			graph.add(new ArrayList<Edge>());
		}
		
		// 모든 간선 정보 입력받기
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			// u정점에서 v정점까지 가는 비용 w
			graph.get(u).add(new Edge(v, w));
		}
		
		// 최단 거리 테이블 초기화
		dist = new int[V+1];
		Arrays.fill(dist, INF);
		
		// 다익스트라 알고리즘 수행
		dijkstra(K);
		
		// 모든 노드로 가기 위한 최단 거리를 출력
		for (int i = 1; i < V+1; i++) {
			if(dist[i] == INF) { // 도달할 수 없는 경우
				System.out.println("INF");
			}else {
				System.out.println(dist[i]);
			}
		}
	}

	private static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		// 시작노드로 가기 위한 최단 경로는 0으로 설정하여 큐에 삽입
		pq.offer(new Edge(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			// 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
			Edge edge = pq.poll();
			int distance = edge.distance;
			int cur = edge.index;
			
			// 현재 노드가 이미 처리된적이 있는 노드라면 무시
			if(dist[cur] < distance) continue;
			// 현재 노드와 연결된 다른 인접한 노드들 확인
			for (int i = 0; i < graph.get(cur).size(); i++) {
				int cost = dist[cur] + graph.get(cur).get(i).distance;
				
				// 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
				if(cost < dist[graph.get(cur).get(i).index]) {
					dist[graph.get(cur).get(i).index] = cost;
					pq.offer(new Edge(graph.get(cur).get(i).index, cost));
				}
			}
		}
	}

}
