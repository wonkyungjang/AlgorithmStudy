import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2567_색종이2 {
	
	static int N;
	static int map[][];
	static int dr[]= {-1,1,0,0};
	static int dc[]= {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int[102][102];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int x=Integer.parseInt(st.nextToken())+1;
			int y=Integer.parseInt(st.nextToken())+1;
			for(int r=x;r<x+10;r++) {
				for(int c=y;c<y+10;c++) {
					map[r][c]=1;
				}
			}
		}
		int cnt=0;
		int r=0; int c=0;
		for(int i=0;i<102;i++) {
			for(int j=0;j<102;j++) {
				if(map[i][j]==1) {
					r=i;
					c=j;
					for(int d=0;d<4;d++) {
						int nr=r+dr[d];
						int nc=c+dc[d];
						if(map[nr][nc]==0) cnt++;
					}
				}
				
			}
		}
		System.out.println(cnt);

	}

}
