import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ4485_녹색옷젤다 {

	public static class rupie implements Comparable<rupie>{

		int x,y,sum=0;
		
		public rupie(int x, int y, int sum) {
			this.x = x;
			this.y = y;
			this.sum = sum;
		}

		@Override
		public int compareTo(rupie o) {
			return this.sum-o.sum;
		}
	}
	
	static int n;
	static int map[][];
	static boolean v[][];
	static int dist[][];
	static PriorityQueue<rupie> q;
	static int dr[]= {-1,1,0,0};
	static int dc[]= {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=0;
		while(true) {
		n=Integer.parseInt(br.readLine());
		t++;
		if(n==0) break;
		map=new int[n][n];
		dist=new int[n][n];
		v=new boolean[n][n];
		q=new PriorityQueue<>();
		
		for(int i=0;i<n;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				dist[i][j]=Integer.MAX_VALUE;
			}
		}
		dist[0][0]=map[0][0];
		q.add(new rupie(0,0,map[0][0]));
		v[0][0]=true;
		dijk();
		System.out.println("Problem "+t+": "+dist[n-1][n-1]);
	}
	}
	private static void dijk() {
		while(!q.isEmpty()) {
			rupie r=q.poll();
			
			if(r.x==n-1 && r.y==n-1) return;
			
			for(int d=0;d<4;d++) {
				int nr=r.x+dr[d];
				int nc=r.y+dc[d];
				
				if(!(nr>=0 && nr<n && nc>=0 && nc<n)) continue;
				
				if(!v[nr][nc] && dist[nr][nc]>map[nr][nc]+r.sum) {
					v[nr][nc]=true;
					dist[nr][nc]=map[nr][nc]+r.sum;
					q.add(new rupie(nr,nc,dist[nr][nc]));
				}
			}
		}
	}
}