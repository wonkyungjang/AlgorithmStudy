import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2636_치즈 {

	static int R,C;
	static int map[][];
	//static boolean v[][];
	static int dr[]= {-1,1,0,0};
	static int dc[]= {0,0,-1,1};
	//static Queue<int[]> q;
	static int cnt,time;
	static int[][] mapcopy; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		map=new int[R][C];
		//v=new boolean[R][C];
		for(int i=0;i<R;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
//바깥공기 부분 -1로 변경
		loop:
		for(int r=0;r<R;r++) {
			for(int c=0;c<C;c++) {
				 if(map[r][c]==0) {
					 map[r][c]=-1;
					 outside(r,c);
					 break loop;
				 }
			 }
		}
		//q=new LinkedList<int[]>();
		//녹는 치즈 큐에 추가하기
		time=0;
		int prev=0;
		while(true) {
			cnt=0;
			for(int r=0;r<R;r++) {
				for(int c=0;c<C;c++) {
					if(map[r][c]==1) cnt++;
				}
			}
			if(cnt==0) break;
			
			//mapcopy : 한시간에 녹아야 될 치즈는 녹은 배열
			mapcopy=new int[R][];
			for (int i = 0; i < map.length; i++) {
				mapcopy[i]=map[i].clone();
			}
			
			for(int r=0;r<R;r++) {
				for(int c=0;c<C;c++) {
					if(map[r][c]==1) {
						if(ismelting(r,c)) {
							mapcopy[r][c]=-1;
							ischeck(r,c);
						}
					}
				}
			}
			map=mapcopy;
			time++;
			prev=cnt;
		}
		System.out.println(time);
		System.out.println(prev);
	}

//엣지 치즈인가?
	private static boolean ismelting(int r, int c) {
		
		for(int d=0;d<4;d++) {
			int nr=r+dr[d];
			int nc=c+dc[d];
			
			if(!(nr>=0 && nr<R && nc>=0 && nc<C)) continue;
			
			if(map[nr][nc]==-1) return true;
		}
		return false;
	}


	private static void outside(int r, int c) {
		
		for(int d=0;d<4;d++) {
			int nr=r+dr[d];
			int nc=c+dc[d];
			
			if(!(nr>=0 && nr<R && nc>=0 && nc<C)) continue;
			
			if(map[nr][nc]==0) {
				map[nr][nc]=-1;
				outside(nr,nc);
			}
		}
	}

	//내부공기가 외부공기가 되는지 dfs
	private static void ischeck(int r, int c) {
		for(int d=0;d<4;d++) {
			int nr=r+dr[d];
			int nc=c+dc[d];
			
			if(!(nr>=0 && nr<R && nc>=0 && nc<C)) continue;
			
			if(mapcopy[nr][nc]==0) {
				mapcopy[nr][nc]=-1;
				ischeck(nr,nc);
			}
		}
	}
}
