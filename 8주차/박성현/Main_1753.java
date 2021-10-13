import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753 {

	static int V, E;
	static int K;
	static ArrayList<Node>[] graph;
	
	static class Node implements Comparable<Node> {
		int index;
		int cost;
		
		public Node(int index, int cost) {
			this.index = index;
			this.cost =  cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}

	}
	
	static void dijkstra(int k) {
		int[] dist = new int[V+1];
		for (int i = 1; i < V+1; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(k, 0));
		dist[k] = 0;
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if (dist[cur.index] < cur.cost) continue;
			for (int i = 0; i < graph[cur.index].size(); i++) {
				Node next = graph[cur.index].get(i);
				if (dist[next.index] > cur.cost + next.cost) {
					dist[next.index] = cur.cost + next.cost;
					pq.add(new Node(next.index, dist[next.index]));
				}
			}
		}
		
		for (int i = 1; i < V+1; i++) {
			if (dist[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(dist[i]);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		V = Integer.parseInt(stn.nextToken());
		E = Integer.parseInt(stn.nextToken());
		K = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[V+1];
		for (int i = 1; i < V+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			stn = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(stn.nextToken());
			int d = Integer.parseInt(stn.nextToken());
			int c = Integer.parseInt(stn.nextToken());
			graph[s].add(new Node(d, c));
		}
		dijkstra(K);
	}

}
