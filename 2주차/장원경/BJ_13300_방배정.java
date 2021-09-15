import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_13300_방배정 {

	static int female[];
	static int male[];
	static int N,K;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		female=new int[7];
		male=new int[7];
		for(int i=0;i<N;i++) {
			StringTokenizer sp=new StringTokenizer(br.readLine()," ");
			int S=Integer.parseInt(sp.nextToken());
			int Y=Integer.parseInt(sp.nextToken());
			//여자면
			if(S==0) female[Y]++;
			//남자면
			else male[Y]++;
		}
		int cnt=0;
		//여자배열
		for(int i=1;i<7;i++) {
			if(female[i]==0) continue;
			int mok=female[i]/K;
			int nam=female[i]%K;
			if(mok==0) cnt+=1;
			else if(mok>=1 && nam!=0) cnt+=mok+1;
			else if(mok>=1 && nam==0) cnt+=mok;
		}
		//남자배열
		for(int i=1;i<7;i++) {
			if(male[i]==0) continue;
			int mok=male[i]/K;
			int nam=male[i]%K;
			if(mok==0) cnt+=1;
			else if(mok>=1 && nam!=0) cnt+=mok+1;
			else if(mok>=1 && nam==0) cnt+=mok;
		}

		System.out.println(cnt);
	}

}
