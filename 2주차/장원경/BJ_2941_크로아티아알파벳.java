import java.util.Scanner;

public class BJ_2941_크로아티아알파벳 {

	static String str;
	static int cnt;
	static String[] s= {"c=","c-","dz=","d-","lj","nj","s=","z="};
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		str=sc.next();
		
		for(int i=0;i<s.length;i++) {
			//입력받은 문자열에 s에 해당하는 워드가 있다면 단어 전체를 * 하나로 치환
			if(str.contains(s[i])) {
				str=str.replaceAll(s[i], "*");
			}
		}
		System.out.println(str.length());	
	}
}

