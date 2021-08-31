import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_7272_노안경 {

	static int T;
	static String result="SAME";
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			String str1=st.nextToken();
			String str2=st.nextToken();
			int s1[] =new int[str1.length()];
			int s2[] =new int[str2.length()];
			
			for(int i=0; i<str1.length(); i++) {
				if(str1.charAt(i)=='B') s1[i]=2;
				else if(str1.charAt(i)=='A' || str1.charAt(i)=='D' ||
						str1.charAt(i)=='O' || str1.charAt(i)=='P'
						||str1.charAt(i)=='Q' ||str1.charAt(i)=='R') {
					s1[i]=1;
				}
			}
			
			for(int i=0; i<str2.length(); i++) {
				if(str2.charAt(i)=='B') s2[i]=2;
				else if(str2.charAt(i)=='A' || str2.charAt(i)=='D' ||
						str2.charAt(i)=='O' || str2.charAt(i)=='P'
						||str2.charAt(i)=='Q' ||str2.charAt(i)=='R') {
					s2[i]=1;
				}
			}
			result="SAME";
			//배열 크기가 다르면 diff
			if(s1.length!=s2.length) result="DIFF";
			//배열 크기가 같으면 same
			else {
				for(int i=0;i<s1.length;i++) {
					if(s1[i]!=s2[i]) result="DIFF";
				}
			}
			System.out.println("#"+t+" "+result);
		}
		

	}

}
