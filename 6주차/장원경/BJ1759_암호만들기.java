import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1759_암호만들기 {
	static int L,C;
	static char[] pass;
	static char jjin[];
	static int ja,mo;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		L=Integer.parseInt(st.nextToken()); //몇 개 뽑기
		C=Integer.parseInt(st.nextToken()); //주어지는 암호 수
		pass=new char[C];
		jjin=new char[L];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<C;i++) {
			pass[i]=st.nextToken().charAt(0);
		}
		
		Arrays.sort(pass);
		ja=0; mo=0;
		//조합
		combi(0,0);
	}
	private static void combi(int cnt,int start) {
		
		if(cnt==L) {
			ja=0; mo=0;
			for(int i=0;i<jjin.length;i++) {
				if(jjin[i]=='a' || jjin[i]=='e' || jjin[i]=='i'
						|| jjin[i]=='o' || jjin[i]=='u') {
					mo++;
				}else 
					ja++;
			}
				if(mo>=1 && ja>=2) {
					for(int i=0;i<jjin.length;i++)
						System.out.print(jjin[i]);
					System.out.println();
				}
				return;
			
		}
		for(int i=start;i<C;i++) {
			jjin[cnt]=pass[i];
			combi(cnt+1,i+1);
			
		}
	}
}
