package _09_1020;

import java.util.Arrays;
import java.util.Scanner;

// N과 M (8)
public class Main_BOJ_15657 {

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
		
		combination(0, 0, new int[M]);
		System.out.println(sb.toString());
	}

	private static void combination(int start, int cnt, int[] nums) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[nums[i]] + " ");
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
