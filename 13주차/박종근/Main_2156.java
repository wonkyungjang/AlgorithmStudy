package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_포도주시식_완탐_2156 {

	static int[] Wine;
	static int Max, N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Max = Integer.MIN_VALUE;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Wine = new int[N];
		for (int i = 0; i < N; i++) {
			Wine[i] = Integer.parseInt(br.readLine());
		}

		Subset(0,0,0);
		System.out.println(Max);

	}

	private static void Subset(int cnt, int continuity, int sum) {
		if(continuity == 3) return;
		else if(cnt == N) {
			Max = Math.max(Max, sum);
			return;
		}
		// 먹는경우
		Subset(cnt+1,continuity+1,sum+Wine[cnt]);
		//안먹는 경우
		Subset(cnt+1,0,sum);
	}

}
