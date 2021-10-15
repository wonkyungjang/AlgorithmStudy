import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ15654_N과M5 {

	static int N,M;
	static int arr[], real[];
	static boolean v[];
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr=new int[M];
		real=new int[N];
		v=new boolean[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			real[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(real);
		perm(0);
		System.out.println();
	}
	private static void perm(int cnt) {
		if(cnt==M) {
			//자바는 출력할때 매우 느리므로
			//sb에 담았다가 한번에 출력하는 게 훨씬 빠르다
			for(int i: arr) {
				sb.append(i+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(v[i]) continue;
			
			v[i]=true;
			arr[cnt]=real[i];
			
			perm(cnt+1);
			v[i]=false;
		}
		
	}

}
