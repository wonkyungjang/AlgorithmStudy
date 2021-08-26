package _02_0901;

import java.util.Scanner;

// 별삼각형2
public class Main_JO_1719 {

	static int N, M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		if (N < 0 || N > 100 || N % 2 == 0 || M < 1 || M > 4) {
			System.out.println("INPUT ERROR!");
		} else {
			switch (M) {
				case 1: star1(); break;
				case 2: star2(); break;
				case 3: star3(); break;
				case 4: star4(); break;
			}
		}
	}
	
	public static void star1() {
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j <= i; j++)
				System.out.print("*");
			System.out.println();
		}
		for (int i = N / 2; i < N; i++) {
			for (int j = 0; j < N - i; j++)
				System.out.print("*");
			System.out.println();
		}
	}
	
	public static void star2() {
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < N / 2 - i; j++)
				System.out.print(" ");
			for (int j = 0; j <= i; j++)
				System.out.print("*");
			System.out.println();
		}
		for (int i = N / 2; i < N; i++) {
			for (int j = 0; j < i - N / 2; j++)
				System.out.print(" ");
			for (int j = 0; j < N - i; j++)
				System.out.print("*");
			System.out.println();
		}
		
	}
	
	public static void star3() {
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < i; j++)
				System.out.print(" ");
			for (int j = 0; j < N - i * 2; j++)
				System.out.print("*");
			System.out.println();
		}
		for (int i = N / 2; i < N; i++) {
			for (int j = 0; j < N - i - 1; j++)
				System.out.print(" ");
			for (int j = 0; j < (i - N / 2) * 2 + 1; j++)
				System.out.print("*");
			System.out.println();
		}
	}
	
	public static void star4() {
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < i; j++)
				System.out.print(" ");
			for (int j = 0; j < N / 2 - i + 1; j++)
				System.out.print("*");
			System.out.println();
		}
		for (int i = N / 2; i < N; i++) {
			for (int j = 0; j < N / 2; j++)
				System.out.print(" ");
			for (int j = N / 2; j <= i; j++)
				System.out.print("*");
			System.out.println();
		}
	}

}
