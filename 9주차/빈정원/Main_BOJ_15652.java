package _09_1020;

import java.util.Scanner;

// N과 M (4)
public class Main_BOJ_15652 {

	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		combination(0, 0, new int[M]);
		System.out.println(sb.toString());
	}

	private static void combination(int start, int cnt, int[] nums) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(nums[i] + 1 + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start; i < N; i++) {
			nums[cnt] = i;
			combination(i, cnt + 1, nums);
		}
	}

}
