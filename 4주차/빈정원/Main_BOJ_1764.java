import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

// 듣보잡
public class Main_BOJ_1764 {

	static int N, M;
	static TreeMap<String, Boolean> map = new TreeMap<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			map.put(br.readLine(), false);
		}
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			String name = br.readLine();
			if (map.containsKey(name)) {
				map.put(name, true);
				cnt++;
			} else {
				map.put(name,  false);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(cnt + "\n");
		for (String name : map.keySet()) {
			if (map.get(name))
				sb.append(name + "\n");
		}
		System.out.println(sb);
	}

}
