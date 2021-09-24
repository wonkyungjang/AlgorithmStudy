import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1774_우주신과의교감 {

	public static class Edge implements Comparable<Edge>{
		int start,end;
		double weight;
		
		public Edge(int start, int end, double weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			//애워!!
			return Double.compare(this.weight,o.weight);
		}		
	}
	
	static PriorityQueue<Edge> pq=new PriorityQueue<Edge>();
	static int N,M;
	static double[][] uv;
	static int[] p;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		uv=new double[N+1][2]; //우주신들의 위치 저장
		
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine());
			uv[i][0]=Double.parseDouble(st.nextToken());
			uv[i][1]=Double.parseDouble(st.nextToken());
		}
		make();
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			union(a,b);
		}
		for(int i=1;i<N;i++) {
			for(int j=i+1;j<=N;j++) {
				pq.offer(new Edge(i,j,distance(i,j)));
			}
		}
		double result=0;
		int cnt=0;
		while(!pq.isEmpty() && cnt!=N-M-1) {
			Edge edge=pq.poll();
			if(union(edge.start,edge.end)) {
				
				result+=edge.weight;
				cnt++;
			}
		}
		
		System.out.printf("%.2f",result);
		
	}
	private static void make() {
		p=new int[N+1];
		for(int i=1;i<=N;i++) {
			p[i]=i;
		}
		
	}
	private static int find(int i) {
		if(p[i]==i) return i;
		return p[i]=find(p[i]);
	}
	private static boolean union(int i, int j) {
		int roota=find(i);
		int rootb=find(j);
		if(roota==rootb) return false; 
		p[roota]=rootb;
		return true;
		
	}
	private static double distance(int i, int j) {
		double d=0;
		double x= Math.pow(uv[i][0]-uv[j][0],2);
		double y= Math.pow(uv[i][1]-uv[j][1],2);
		d=Math.sqrt(x+y);
		return d;
	}
}
