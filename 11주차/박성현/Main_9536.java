import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_9536 {

	static int t;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		
		for (int i = 0 ; i < t; i++) {
			String[] sounds = br.readLine().split(" ");
			HashMap<String, Integer> animals = new HashMap<String, Integer>();
			while (true) {
				String s = br.readLine();
				if (s.equals("what does the fox say?")) break;
				String[] ss = s.split(" ");
				animals.put(ss[2], 1);
			}
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < sounds.length; j++) {
				if (animals.containsKey(sounds[j])) continue;
				sb.append(sounds[j]).append(" ");
			}
			System.out.println(sb);
		}

	}

}
