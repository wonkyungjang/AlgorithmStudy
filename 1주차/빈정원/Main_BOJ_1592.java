package _01_0825;

import java.util.Scanner;

// 영식이와 친구들
public class Main_BOJ_1592 {
	
	static int N, M, L;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		L = sc.nextInt();
		arr = new int[N];
		int idx = 0;
		int cnt = 0;
		while (arr[idx] != M - 1) {
			cnt++;
			if (++arr[idx] % 2 == 1)
				idx = (idx + L) % N;	// 홀수면 시계방향
			else
				idx = (idx - L + N) % N;	// 짝수면 반시계방향
		}
		System.out.println(cnt);
	}

}
