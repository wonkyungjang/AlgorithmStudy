import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BJ9536_여우는어떻게울지2_set {

	static int T;
	static HashSet<String> hs;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			String cry[]=br.readLine().split(" ");
			hs = new HashSet<String>();
			
			while (true) {
				String str = br.readLine();
				if (str.equals("what does the fox say?")) break;
				
				String s[] = str.split(" ");
				hs.add(s[2]);
			}
			StringBuilder sb=new StringBuilder();
			for(String c :cry) {
				if(hs.contains(c)) continue;
				sb.append(c).append(" ");
			}	
			System.out.println(sb);
		}	
	}
}