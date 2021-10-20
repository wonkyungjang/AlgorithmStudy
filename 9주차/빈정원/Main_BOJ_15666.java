package _09_1020;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

// N과 M (12)
public class Main_BOJ_15666 {

	static int N, M;
	static int[] arr;
	static LinkedHashSet<String> set = new LinkedHashSet<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		combination(0, 0, "");
		
		StringBuilder sb = new StringBuilder();
		for (String s : set) {
			sb.append(s + "\n");
		}
		System.out.println(sb);
	}

	private static void combination(int start, int cnt, String str) {
		if (cnt == M) {
			set.add(str.trim());
			return;
		}
		
		for (int i = start; i < N; i++) {
			combination(i, cnt + 1, (str + " " + arr[i]));
		}
	}

}
