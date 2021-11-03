import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 여우는 어떻게 울지?
public class Main_9536 {

	static int T;
	static String [] record;
	static ArrayList<String> result;
	static final String ENDSTR = "what does the fox say?";
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			
			record = br.readLine().split(" ");
			result = new ArrayList<>();
			
			ArrayList<String> soundList = new ArrayList<>();
			String str = "";
			
			while(true) {
				str = br.readLine();
				
				if(str.equals(ENDSTR)) break;
				
				String [] animal = str.split(" ");
				soundList.add(animal[animal.length-1]);
			}
			
			for (int i = 0; i < record.length; i++) {
				if(!soundList.contains(record[i])) {
					result.add(record[i]);
				}
			}
			
			StringBuilder sb = new StringBuilder();
			for (String fox : result) {
				sb.append(fox).append(" ");
			}
			
			System.out.println(sb.toString());
		}

	}

}
