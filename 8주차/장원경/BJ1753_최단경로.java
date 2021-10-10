import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1753_최단경로 {
	
	public static class E implements Comparable<E>{
		int ver, cost=0;
		
		public E(int ver, int cost) {
			super();
			this.ver = ver;
			this.cost = cost;
		}

		@Override
		public int compareTo(E o) {
			return this.cost-o.cost;
		}
	}
	
	static int V,E;
	static int start;
	static ArrayList<E>[] map;
	static boolean visit[];
	static int dist[]; //출발지에서 자신으로 오는 최소비용
	static final int INF=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		
		dist=new int[V];
		visit=new boolean[V];
		start=Integer.parseInt(br.readLine())-1;
		map=new ArrayList[V];
		
		for(int i=0;i<V;i++) {
			map[i]=new ArrayList<E>();
		}
		
		Arrays.fill(dist, INF);
		for(int i=0;i<E;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken())-1;
			int e=Integer.parseInt(st.nextToken())-1;
			int w=Integer.parseInt(st.nextToken());
			map[s].add(new E(e,w));
		}
		dist[start]=0;
		visit[start]=true;
		dijkstra();
		for(int i : dist) {
			if(i==INF) System.out.println("INF");
			else System.out.println(i);
		}
	
	}
	private static void dijkstra() {
		PriorityQueue<E> q=new PriorityQueue<>();
		q.add(new E(start,0));
		
		while(!q.isEmpty()) {
			E e=q.poll();

			for(E o : map[e.ver]) {
				if(!visit[o.ver] && dist[o.ver]>dist[e.ver]+o.cost) {
					visit[e.ver]=true;
					dist[o.ver]=dist[e.ver]+o.cost;
					q.add(new E(o.ver,dist[o.ver]));
				}
			}
		}
	}
}