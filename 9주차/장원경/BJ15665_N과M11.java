import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;
//Linkedhashset : 순서 관리 set(넣은 순서대로)
public class BJ15665_N과M11 {

	static int N,M;
	static int arr[], real[];
	static LinkedHashSet<String> hs;
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr=new int[M];
		real=new int[N];
		hs=new LinkedHashSet<>();
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			real[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(real);
		combi(0,0);
		for(String s : hs) {
		 System.out.println(s);
	}

	}
	private static void combi(int cnt,int start) {
		if(cnt==M) {
			sb=new StringBuilder();
			for(int i:arr)
				sb.append(i+" ");
			
			hs.add(sb.toString());

			return;
		}
		
		for(int i=0;i<N;i++) {

			arr[cnt]=real[i];
			
			combi(cnt+1,i+1);
		}
	}
}
