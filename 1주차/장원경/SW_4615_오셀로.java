import java.util.Arrays;
import java.util.Scanner;
//추후에 다시...2017 A형 기출
//행,열이 아니고 열,행으로 인덱스 됐던 것과, 흰돌돌돌돌흰 에서 흰흰흰흰흰흰 되는거 몰랐음.. 돌"들"
public class SW_4615_오셀로 {

	static int T,N,M;
	static int move[][]; //입력 받을 배열(c,r,color)
	static int map[][];
	static int dr[]= {-1,1,0,0,-1,-1,1,1};
	static int dc[]= {0,0,-1,1,-1,1,-1,1};
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
		for(int t=1;t<=T;t++) {
			N=sc.nextInt();
			M=sc.nextInt();
			move=new int[M][3];
			map=new int[N][N];
			for(int i=0;i<M;i++) {
				for(int j=0;j<2;j++)
					move[i][j]=sc.nextInt()-1;
					move[i][2]=sc.nextInt();
			}
			
			map[N/2-1][N/2-1]=2; //2는 흰돌
			map[N/2-1][N/2]=1; //1은 검은돌
			map[N/2][N/2-1]=1;
			map[N/2][N/2]=2;
			//move : 열 ,행 ,색깔
			//System.out.println(Arrays.deepToString(move));
			for(int i=0;i<M;i++) {
				int c=move[i][0];
				int r=move[i][1];
				int color=move[i][2];
				int another=0;
				if(color==2) {another=1;}
				else {another=2;}
			
				map[r][c]=color;
				
				for(int d=0;d<8;d++) {
					
					int nr=r+dr[d];
					int nc=c+dc[d];
					//another color면
					if(check(nr,nc) && map[nr][nc]==another) {
						int cr=nr;
						int cc=nc;
						//어디까지 another인지 확인
						while(check(cr,cc) && map[cr][cc]==another) {
							
							cr=cr+dr[d];
							cc=cc+dc[d];
							
						}
					int tr=cr;
					int tc=cc;
					//another 바로 다음칸이 color면 앞에거 다 바꿔주기
					if(check(tr,tc) && map[tr][tc]==color) {
					
						while(map[nr][nc]==another) {
							map[nr][nc]=color;
							nr=nr+dr[d];
							nc=nc+dc[d];
						}
					}
					}
		}
		}
			int bcnt=0;
			int wcnt=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					//검은 돌이면
					if(map[i][j]==1) {
						bcnt++;
					//흰돌이면
					}else if(map[i][j]==2) wcnt++;
				}
			}
			
			//흑돌 백돌의 개수.
			System.out.println("#"+t+" "+bcnt+" "+wcnt);
		}
	}
	private static boolean check(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<N;
	}
}
