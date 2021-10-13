import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14496 {

	static int a, b, n, m;
	static Node[] nodes;
	
	public static class Node {
		int index;
		ArrayList<Integer> linked;
		
		public Node(int index) {
			this.index = index;
			this.linked = new ArrayList<>();
		}
	}
	
	public static int Dijkstra(int s, int d) {
		int[] dist = new int[n+1];
		for (int i = 1; i < n+1; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		Queue<Integer> que = new LinkedList<>();
		que.add(s);
		dist[s] = 0;
		while (!que.isEmpty()) {
			int cur = que.poll();
			for (int i = 0; i < nodes[cur].linked.size(); i++) {
				int next = nodes[cur].linked.get(i);
				if (dist[next] > dist[cur]+1) {
					dist[next] = dist[cur]+1;
					que.add(next);
				}
			}
		}
		
		if (dist[d] == Integer.MAX_VALUE) return -1;
		return dist[d];
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		a = Integer.parseInt(stn.nextToken());
		b = Integer.parseInt(stn.nextToken());
		stn = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stn.nextToken());
		m = Integer.parseInt(stn.nextToken());
		
		nodes = new Node[n+1];
		for (int i = 1; i < n+1; i++) {
			nodes[i] = new Node(i);
		}
		
		for (int i = 0; i < m ; i++) {
			stn = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(stn.nextToken());
			int d = Integer.parseInt(stn.nextToken());
			nodes[s].linked.add(d);
			nodes[d].linked.add(s);
		}
		
		System.out.println(Dijkstra(a, b));
	}

}
