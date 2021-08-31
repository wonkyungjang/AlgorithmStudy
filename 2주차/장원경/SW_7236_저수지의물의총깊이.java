import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_7236_저수지의물의총깊이 {
	
	static char[][] map;
	static int T,N;
	static int dr[]= {-1,1,0,0,-1,-1,1,1};
	static int dc[]= {0,0,-1,1,-1,1,-1,1};
	static int max=Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
		N=Integer.parseInt(br.readLine());
		map=new char[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				map[i][j]=st.nextToken().charAt(0);
			}
		}
		int dep=0;
		max=Integer.MIN_VALUE;
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				if(map[r][c]=='W') {
					dep=go(r,c);
					if(dep>max) max=dep;
				}
			}
		}
		System.out.println("#"+t+" "+max);
		}
	}
	private static int go(int r, int c) {
		int depth=0;
		
		for(int d=0;d<8;d++) {
			
			int nr=r+dr[d];
			int nc=c+dc[d];
			if(!check(nr,nc)) continue;
			
			if(map[nr][nc]=='W') depth++;
		}
		if(depth==0) depth=1;
		return depth;
	}
	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}

}
