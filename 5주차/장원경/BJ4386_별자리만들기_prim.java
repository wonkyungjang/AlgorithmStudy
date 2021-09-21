import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ4386_별자리만들기_prim {
	static int n;
	static float[][] star;
	static float[][] adjmatrix;
	static float[] minedge;
	static boolean[] v;
	public static void main(String[] args) throws IOException,NumberFormatException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		star=new float[n][2];
		adjmatrix=new float[n][n];
		v=new boolean[n];
		minedge=new float[n];
		for(int i=0;i<n;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			star[i][0]=Float.parseFloat(st.nextToken());
			star[i][1]=Float.parseFloat(st.nextToken());
			minedge[i]=Integer.MAX_VALUE;
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				adjmatrix[i][j]=getdistance(i,j);
			}
		}
		
		float result=0;
		minedge[0]=0;//임의의 시작점 0의 간선비용을 0으로 세팅
		for(int i=0;i<n;i++) {
			//신장트리에 포함되지않은 정점 중 최소간선비용의 정점 찾기
			float min=Integer.MAX_VALUE;
			int minvertex=-1; //최소간선비용의 정점 번호
			for(int j=0;j<n;j++) {
				if(!v[j] && min>minedge[j]) {
					min=minedge[j];
					minvertex=j;
				}
			}
			v[minvertex]=true;
			result+=min;
			
			//선택된 정점 기준으로 신장트리에 연결되지 않은 타 정점과의 간선비용
			//최소로 업데이트
			for(int j=0;j<n;j++) {
				if(!v[j] && adjmatrix[minvertex][j]!=0
						&& minedge[j]>adjmatrix[minvertex][j]) {
					minedge[j]=adjmatrix[minvertex][j];
				}
			}
		}
		//System.out.println(Math.round(result*100)/100.0);
		System.out.println(String.format("%.2f", result));
	}
	private static float getdistance(int r, int c) {
		float d=0;
		float x=(float) Math.pow(star[r][0]-star[c][0], 2);
		float y=(float) Math.pow(star[r][1]-star[c][1], 2);
		d=(float) Math.sqrt(x+y);
		return d;
	}

}
