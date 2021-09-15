import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2798_블랙잭 {
	
	static int arr[];
	static int p[];
	static int N,S;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		S=Integer.parseInt(st.nextToken());
		arr=new int[N];
		p=new int[3];
		StringTokenizer sb=new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(sb.nextToken());
		}
		max=Integer.MIN_VALUE;
		combi(0,0,0);
		System.out.println(max);
	}
	private static void combi(int cnt, int start, int sum) {
		
		if(cnt==3) {
			
			if(sum<=S && max<=sum) max=sum; 
			return;
		}
		
		for(int i=start;i<N;i++) {
			
			combi(cnt+1,i+1,sum+arr[i]);
			
		}
		
	}

}
