package _02_0901;

import java.util.Scanner;

// 별삼각형3
public class Main_JO_1329 {

	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		if (N < 0 || N > 100 || N % 2 == 0) {
			System.out.println("INPUT ERROR!");
		} else {
			star();
		}
	}
	
	public static void star() {
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < i; j++)
				System.out.print(" ");
			for (int j = 0; j < i * 2 + 1; j++)
				System.out.print("*");
			System.out.println();
		}
		for (int i = N / 2; i < N; i++) {
			for (int j = i; j < N - 1; j++)
				System.out.print(" ");
			for (int j = 0; j < (N - i) * 2 - 1; j++)
				System.out.print("*");
			System.out.println();
		}
	}

}
