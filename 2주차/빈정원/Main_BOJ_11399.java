package _02_0901;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// ATM
// {3, 1, 4, 3, 2} 일 때
//  2, 5, 1, 4, 3 순서이면 최소 -> 오름차순으로 정렬할 때가 최소
public class Main_BOJ_11399 {

	static int N, ans;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		// arr[0] -> N번, arr[1] -> N - 1번 ... arr[N - 1] -> 1번
		for (int i = 0; i < N; i++)
			ans += arr[i] * (N - i);
		System.out.println(ans);
	}

}
