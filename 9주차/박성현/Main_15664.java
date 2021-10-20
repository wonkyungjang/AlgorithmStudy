import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main_15664 {

	static int n, m;
	static List<Integer> arr;
	static Set<Integer> arrSet;
	static int[] num;
	static StringBuilder sb;
	static int[] arrNums = new int[10001];
	static int[] useNums = new int[10001];
	
	static void nm10(int cnt, int start) {
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				sb.append(num[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		for (int i = start; i < arr.size(); i++) {
			if (useNums[arr.get(i)] == arrNums[arr.get(i)]) continue;
			useNums[arr.get(i)]++;
			num[cnt] = arr.get(i);
			nm10(cnt+1, i);
			useNums[arr.get(i)]--;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new ArrayList<>();
		num = new int[m];
		for (int i = 0; i < n; i++) {
			arr.add(sc.nextInt());
			arrNums[arr.get(i)]++;
		}
		arrSet = new HashSet<>(arr);
		arr = new ArrayList<>(arrSet);
		Collections.sort(arr);
		sb = new StringBuilder();
		nm10(0, 0);
		System.out.println(sb);
	}

}

