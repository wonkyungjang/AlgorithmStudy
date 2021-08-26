import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*REPUBLIKA HRVATSKA*/
public class BJ_2804_크로스워드만들기 {

	static char[][] map;
	static int r,c;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		String str1=st.nextToken();
		String str2=st.nextToken();
		map=new char[str2.length()][str1.length()];
		for(int i=0;i<str2.length();i++) {
			Arrays.fill(map[i], '.');
		}
		//System.out.println(Arrays.deepToString(map));
		Loop1 :
		for(int i=0;i<str1.length();i++) {
			for(int j=0;j<str2.length();j++) {
				if(str1.charAt(i)==str2.charAt(j)) {
					r=j; 
					c=i; 
					break Loop1;
				}
			}
			}
		
		for(int i=0;i<str1.length();i++)
			map[r][i]=str1.charAt(i);
		
		for(int i=0;i<str2.length();i++)
			map[i][c]=str2.charAt(i);
		
		for(int i=0;i<str2.length();i++) {
			for(int j=0;j<str1.length();j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
