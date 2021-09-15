import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main_1764 {

	static int n, m;
	static Map<String, Integer> names = new HashMap<>();
	static PriorityQueue<String> dbnames = new PriorityQueue<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		n = Integer.parseInt(nm[0]);
		m = Integer.parseInt(nm[1]);
		
		for (int i = 0; i < n; i++) {
			names.put(br.readLine(), 1);
		}
		for (int i = 0; i < m; i++) {
			String name = br.readLine();
			if (names.containsKey(name)) {
				dbnames.add(name);
			}
		}
		System.out.println(dbnames.size());
		while (dbnames.size() > 0) {
			System.out.println(dbnames.poll());
		}

	}

}
