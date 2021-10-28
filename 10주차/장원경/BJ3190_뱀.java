import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ3190_뱀 {

	static Deque<int[]> q;
	static int N,K,L;
	static Queue<int[]> sd; //snake direction
	static int map[][];
	static int dr[]= {0,1,0,-1}; //우하좌상
	static int dc[]= {1,0,-1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		K=Integer.parseInt(br.readLine()); //사과의 개수
		sd=new LinkedList<>();
		q=new ArrayDeque<>();
		map=new int[N][N];
		map[0][0]=1;
		for(int i=0;i<K;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			//사과의 위치를 4로 두자
			int a=Integer.parseInt(st.nextToken())-1;
			int b=Integer.parseInt(st.nextToken())-1;
			map[a][b]=4;
		}
		L=Integer.parseInt(br.readLine());
		for(int i=0;i<L;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int X=Integer.parseInt(st.nextToken());
			char C=st.nextToken().charAt(0);
			int c=0;
			if(C=='L') c=0;
			else c=1;
			sd.add(new int[] {X,c});
		}
		int r=0; int c=0;
		int sec=0; int d=0;
		//뱀이 있는 위치 저장. 오른쪽에서 왼쪽으로 넣기
		q.add(new int[] {0,0});
		while(true) {
			sec++;
		
			//d 방향으로 한 칸 이동
			int nr=r+dr[d];
			int nc=c+dc[d];
			//map밖을 벗어나거나 본인의 몸에 부딫치면
			if(nr<0 || nr>=N || nc<0 || nc>=N || map[nr][nc]==1) break;
			//사과 발견
			if(map[nr][nc]==4) {
				//사과 없애고 뱀 위치로 바꿈
				map[nr][nc]=1;
				//뱀 몸길이에 추가
				q.add(new int[] {nr,nc});
			
				//사과가 아니면
			}else {
				map[nr][nc]=1;
				q.add(new int[] {nr,nc});
				if(!q.isEmpty()) {
					//몸 길이 줄이기
					int n[]=q.poll();
					//꼬리가 위치한 칸 비워주기
					map[n[0]][n[1]]=0;
				}
			}
			
			if(!sd.isEmpty()) {
				int arr[]=sd.peek();
				if(arr[0]==sec) {
					sd.poll();
					//0이면 왼쪽 90도
					d= arr[1]==0? (d+3)%4 : (d+1)%4;
				}
			}
//			for(int i=0;i<N;i++) {
//				for(int j=0;j<N;j++) {
//					System.out.print(map[i][j]+" ");
//				}System.out.println();
//			}
//			System.out.println();
			r=nr;
			c=nc;
		}
		System.out.println(sec);
	}
}
