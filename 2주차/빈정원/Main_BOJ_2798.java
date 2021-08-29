package _02_0901;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 블랙잭
public class Main_BOJ_2798 {

	static int N, M, ans;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		// 3중 for문으로 가능
		// M을 넘지 않아야 하는데 M을 넘더라도 최대한 가까우면 정답이라고 잘못읽어서 틀림
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				for (int k = j + 1; k < N; k++) {
					int sum = arr[i] + arr[j] + arr[k];
					if (sum <= M && M - sum < M - ans)
						ans = sum;
				}
			}
		}
		System.out.println(ans);
	}

}
