import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1389_케빈베이컨의6단계법칙 {

	static int N,M;
	static int map[][];
	static int INF=10000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][N];
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken())-1;
			int end=Integer.parseInt(st.nextToken())-1;
			map[start][end]=1;
			map[end][start]=1;
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i!=j && map[i][j]==0) {
					map[i][j]=INF;
				}
			}
		}
		
		//경출도
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][k]+map[k][j]<map[i][j]) {
						map[i][j]=map[i][k]+map[k][j];
					}
				}
			}
		}
		int sum=0,res=0,min=Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sum+=map[i][j];
			}
			if(sum<min) {
				min=sum;
				res=i+1;
			}
			sum=0;
		}
	
		System.out.println(res);
		
	}

}
