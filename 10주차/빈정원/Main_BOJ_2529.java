package _10_1027;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 부등호
public class Main_BOJ_2529 {

	static int k;
	static char[] arr;
	static String min = String.valueOf(Long.MAX_VALUE);
	static String max = String.valueOf(Long.MIN_VALUE);
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		arr = new char[k];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		permutation(0, new StringBuilder(), new boolean[10]);
		
		System.out.println(max);
		System.out.println(min);
	}

	private static void permutation(int cnt, StringBuilder nums, boolean[] v) {
		if (cnt == k + 1) {
			long number = Long.parseLong(nums.toString());
			if (Long.parseLong(min) > number) {
				min = nums.toString();
			}
			if (Long.parseLong(max) < number) {
				max = nums.toString();
			}
			return;
		}
		
		for (int i = 0; i < 10; i++) {
			if (v[i] || !check(cnt, i, nums)) continue;
			v[i] = true;
			permutation(cnt + 1, nums.append(i), v);
			nums.deleteCharAt(nums.length() - 1);
			v[i] = false;
		}
	}

	private static boolean check(int cnt, int cur, StringBuilder nums) {
		if (cnt == 0) {
			return true;
		}
		int prev = nums.charAt(cnt - 1) - '0';
		char c = arr[cnt - 1];
		if ((prev < cur && c == '<') || (prev > cur && c == '>')) {
			return true;
		}
		return false;
	}

}
