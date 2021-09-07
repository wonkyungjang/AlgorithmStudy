import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17144_미세먼지안녕 {

	static int R,C,T;
	static int room[][];
	static int a,b; //공기청정기 아래쪽 위치 저장
	//상우하좌(시계)
	static int[] dr= {-1,0,1,0};
	static int[] dc= {0,1,0,-1};
	//하우상좌(반시계)
	static int[] dr2= {1,0,-1,0};
	static int[] dc2= {0,1,0,-1};
	static int temp[][];
	static int sum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		T=Integer.parseInt(st.nextToken());
		room= new int[R][C];
		temp= new int[R][C];
		for(int i=0;i<R;i++) {
			StringTokenizer sp=new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				room[i][j]=Integer.parseInt(sp.nextToken());
				if(room[i][j]==-1) {
					a=i; b=j; //공기청정기의 아래 위치 저장
				}
			}
		}
		for(int t=1;t<=T;t++) {
			temp[a][b]=-1;
			temp[a-1][b]=-1;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(room[i][j]>0) diffusion(i,j);
			}
		}
		//공기청정기 가동(위, 아래)
		//공기청정기 위치에 덮어 씌이는 것 방지 a-2, a+1
		upperclean(a-2,b);
		lowerclean(a+1,b);
		
		//먼지의 합 구하기
		sum=0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				room[i][j]=temp[i][j]; //temp배열을 room배열에 복사
				if(temp[i][j]>0) sum+=temp[i][j];
			}
		}
		//temp배열 초기화
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				temp[i][j]=0;
			}
		}
		}
		System.out.println(sum);
	}
	
	private static void lowerclean(int r, int c) {
		int d=0;
		while(temp[r][c]!=-1) {
			int nr=r+dr2[d];
			int nc=c+dc2[d];
			while(!check3(nr,nc)) {
				d++;
				nr=r+dr2[d];
				nc=c+dc2[d];
			}
			if(temp[nr][nc]==-1) temp[r][c]=0;
			else temp[r][c]=temp[nr][nc];
			r=nr;
			c=nc;
		}
	}

	private static void upperclean(int r, int c) {
		int d=0;
		while(temp[r][c]!=-1) {
			int nr=r+dr[d];
			int nc=c+dc[d];
			while(!check2(nr,nc)) {
				d++;
				nr=r+dr[d];
				nc=c+dc[d];
			}
			if(temp[nr][nc]==-1) temp[r][c]=0;
			else temp[r][c]=temp[nr][nc];
			r=nr;
			c=nc;
		}
	}
	
	private static void diffusion(int r, int c) {
		int dust=room[r][c]/5; //확산되는 먼지의 양
		int cnt=0; //확산되는 방향의 수
		for(int d=0;d<4;d++) {
			int nr=r+dr[d];
			int nc=c+dc[d];
			//범위체크+위치가 -1이면 공기청정기 위치라 안됨
			if(!check(nr,nc) || room[nr][nc]==-1) continue;
			//비어있지않으면 temp에 dust를 더함. 동시에 발생하므로 temp배열 생성
			temp[nr][nc]+=dust;
			cnt++;
		}
		temp[r][c]+=room[r][c]-(dust*cnt);
	}
	private static boolean check(int nr, int nc) {
		return nr>=0 && nr<R && nc>=0 && nc<C;
	}
	
	private static boolean check2(int nr, int nc) {
		return nr>=0 && nr<=a-1 && nc>=0 && nc<C;
	}
	
	private static boolean check3(int nr, int nc) {
		return nr>=a && nr<R && nc>=0 && nc<C;
	}
}
