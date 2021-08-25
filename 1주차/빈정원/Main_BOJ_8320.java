package _01_0825;

import java.util.Scanner;

// 1 : (1,1)
// 2 : (1,2)
// 3 : (1,3)
// 4 : (1,4), (2,2)
// 5 : (1,5)
// 6 : (1,6), (2,3)
// 7 : (1,7)
// 8 : (1,8), (2,4)
// 9 : (1,9), (3,3)
// 12 : (1,12), (2,6), (3,4)
// 16 : (1,16), (2,8), (4,4)
// 규칙 : Math.ceil(약수의 개수 / 2)

// 직사각형을 만드는 방법
public class Main_BOJ_8320 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int ans = 0;
		for (int i = 1; i <= N; i++) {
			int cnt = 0;
			for (int j = 1; j <= i; j++)
				if (i % j == 0) cnt++;
			ans += Math.ceil(cnt / 2.0);
		}
		System.out.println(ans);
	}

}
