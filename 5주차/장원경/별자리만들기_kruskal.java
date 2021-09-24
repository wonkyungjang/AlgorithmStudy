import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 별자리만들기_kruskal {

	public static class Edge implements Comparable<Edge>{
		int start,end;
		float weight;
		
		public Edge(int start, int end, float weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Float.compare(this.weight, o.weight);
		}
	}
	static int n;
	static float[][] star;
	static int p[];
	static PriorityQueue<Edge> pq;
	public static void main(String[] args) throws IOException,NumberFormatException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		star=new float[n][2];
		pq=new PriorityQueue<Edge>();
		p=new int[n+1];
		for(int i=0;i<n;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			star[i][0]=Float.parseFloat(st.nextToken());
			star[i][1]=Float.parseFloat(st.nextToken());
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				pq.offer(new Edge(i,j,getdistance(i,j)));
			}
		}
		make();
		float result=0;
		while(!pq.isEmpty()) {
			Edge edge=pq.poll();
			if(union(edge.start,edge.end)) {
				result+=edge.weight;
			}
		}
		System.out.println(Math.round(result*100)/100.0);
}
	
	private static boolean union(int a, int b) {
		if(find(a)==find(b)) return false;
		p[find(a)]=find(b); return true;
	}
	
	private static int find(int a) {
		if(p[a]==a) return a;
		return p[a]=find(p[a]);
	}

	private static void make() {
		for(int i=1;i<=n;i++)
			p[i]=i;
	}

	private static float getdistance(int r, int c) {
		float d=0;
		float x=(float) Math.pow(star[r][0]-star[c][0], 2);
		float y=(float) Math.pow(star[r][1]-star[c][1], 2);
		d=(float) Math.sqrt(x+y);
		return d;
	}
}
