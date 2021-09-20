import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1197_최소스패닝트리 {

	static int V,E;
	static int[] p;
	static Edge[] edgelist;
	static class Edge implements Comparable<Edge>{
		int v;
		int e;
		int w;
		
		public Edge(int v,int e, int w) {
			this.v=v;
			this.e=e;
			this.w=w;
		}
	
	//정렬할때 사용
	@Override
	public int compareTo(Edge o) {
		return this.w-o.w;
		}
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		p=new int[V+1];
		edgelist=new Edge[E];
		for(int i=0;i<E;i++) {
			st=new StringTokenizer(br.readLine());
			int v=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			Edge edge=new Edge(v, e, w);
			edgelist[i]=edge;
		}
		Arrays.sort(edgelist);
		make();
		int i,cnt,result;
		i=cnt=result=0;
		while(cnt<V-1) {
			if(union(edgelist[i].v,edgelist[i].e)){
				cnt++;
				result+=edgelist[i].w;
			}
			i++;
		}
		System.out.println(result);
	}
	private static boolean union(int a, int b) {
		int roota=find(a);
		int rootb=find(b);
		if(roota==rootb) return false; // 이미 한 부모임!
		p[roota]=rootb;
		return true;
	}
	private static int find(int i) {
		if(p[i]==i) return i;
		return p[i]=find(p[i]);
		
	}
	private static void make() {
		for(int i=1;i<=V;i++) {
			p[i]=i;
		}	
	}
}

