package _02_0901;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 농작물 수확하기
public class Solution_D3_2805 {

	static int T, N, sum;
	static char[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			sum = 0;
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					// 거리가 N / 2와 같거나 작을 때 수확 가능
					if (getDist(i, j) <= N / 2)
						sum += map[i][j] - '0';
				}
			}
			System.out.println("#" + t + " " + sum);
		}
	}

	public static int getDist(int r, int c) {
		return Math.abs(N / 2 - r) + Math.abs(N / 2 - c);
	}

}
