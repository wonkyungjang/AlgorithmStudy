package _01_0825;

import java.util.Scanner;

// 별삼각형1
public class Main_JO_1523 {

	static int N, M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		if (N < 0 || N > 100 || M < 1 || M > 3) {
			System.out.println("INPUT ERROR!");
		} else {
			switch (M) {
				case 1: star1(); break;
				case 2: star2(); break;
				case 3: star3(); break;
			}
		}
	}
	
	public static void star1() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++)
				System.out.print("*");
			System.out.println();
		}
	}
	
	public static void star2() {
		for (int i = 1; i <= N; i++) {
			for (int j = N; j >= i; j--)
				System.out.print("*");
			System.out.println();
		}
	}
	
	public static void star3() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N - i; j++)
				System.out.print(" ");
			for (int j = 1; j <= i * 2 - 1; j++)
				System.out.print("*");
			System.out.println();
		}
	}

}
