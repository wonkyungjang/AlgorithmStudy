import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

// HashSet : 중복없이 저장할수있는 자료구조, add() 함수는 중복일시 false, 아닐시 값을 넣고 true 반환

public class Main_1764 {

	static int N;
	static int M;
	static HashSet<String> list;
	static ArrayList<String> result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new HashSet<>();
		result = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			String name = br.readLine();
			list.add(name);
		}
		
		for (int i = 0; i < M; i++) {
			String name = br.readLine();
			if(!list.add(name)) {
				result.add(name);
			}
		}
		
		Collections.sort(result);
		
		System.out.println(result.size());
		for (String name : result) {
			System.out.println(name);
		}

	}

}
