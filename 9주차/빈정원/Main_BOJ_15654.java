package _09_1020;

import java.util.Arrays;
import java.util.Scanner;

// N과 M (5)
public class Main_BOJ_15654 {

	static int N, M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		permutation(0, new int[M], new boolean[N]);
		System.out.println(sb.toString());
	}

	private static void permutation(int cnt, int[] nums, boolean[] v) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[nums[i]] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (v[i]) continue;
			v[i] = true;
			nums[cnt] = i;
			permutation(cnt + 1, nums, v);
			v[i] = false;
		}
	}
}
