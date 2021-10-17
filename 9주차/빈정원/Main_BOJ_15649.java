package _09_1020;

import java.util.Scanner;

// N과 M (1)
public class Main_BOJ_15649 {

	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		permutation(0, new int[M], new boolean[N]);
		System.out.println(sb.toString());
	}

	private static void permutation(int cnt, int[] nums, boolean[] v) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(nums[i] + 1 + " ");
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
