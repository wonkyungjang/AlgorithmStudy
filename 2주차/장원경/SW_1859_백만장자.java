import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class SW_1859_백만장자 {
	static int T,N;
	static int day[];
	static int max=Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			N=Integer.parseInt(br.readLine());
			day=new int[N];
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			for(int i=0;i<N;i++) {
				day[i]=Integer.parseInt(st.nextToken());
			}
			long sum=0;
			int max=day[N-1];
			
			for(int i=N-2;i>=0;i--) {
				max=day[i]>max? day[i] : max;
					sum+=max-day[i];
			}
			System.out.println("#"+t+" "+sum);

		}
		
	}
}

