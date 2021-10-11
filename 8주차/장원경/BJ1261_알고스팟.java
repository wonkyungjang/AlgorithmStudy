import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ1261_알고스팟 {

	public static class algo implements Comparable<algo> {

		int r, c, cost = 0;

		public algo(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}

		@Override
		public int compareTo(algo o) {
			return this.cost-o.cost;
		}
	}

	static int N, M;
	static int dr[] = { -1,1,0,0 };
	static int dc[] = { 0,0,-1,1 };
	static int map[][];
	static int dist[][];
	static PriorityQueue<algo> q;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		map = new int[N][M];
		dist = new int[N][M];
		q = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			char c[] = str.toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = c[j] - '0';
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		dist[0][0] = 0;
		q.add(new algo(0, 0, 0));
		dijk();
		System.out.println(dist[N-1][M-1]);
	}

	private static void dijk() {
		while(!q.isEmpty()) {
			algo a=q.poll();
			
			if(a.r==N-1 && a.c==M-1) return;
			
			for(int d=0;d<4;d++) {
				int nr=a.r+dr[d];
				int nc=a.c+dc[d];
				
				if(!(nr>=0 && nr<N && nc>=0 && nc<M)) continue;
				
				if(dist[nr][nc]>a.cost+map[nr][nc]) {
					dist[nr][nc]=a.cost+map[nr][nc];
					q.add(new algo(nr,nc,dist[nr][nc]));
				}
			}
		}		
	}
}