import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15650_N과M2 {

	static int arr[];
	static int real[];
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr=new int[M];
		real=new int[N];
		for(int i=0;i<N;i++) {
			real[i]=i+1;
		}
		combi(0,0);
		

	}
	private static void combi(int cnt, int start) {
		if(cnt==M) {
			for(int i:arr)
				System.out.print(i+" ");
			System.out.println();
			return;
		}
		
		for(int i=start;i<N;i++) {
			arr[cnt]=real[i];
			combi(cnt+1,i+1);
		}
		
	}

}
