package _07_1006;

import java.util.Scanner;

// 최대공약수와 최소공배수
public class Main_BOJ_2609 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.printf("%d\n%d", gcd(a, b), lcm(a, b));
	}

	private static int gcd(int a, int b) {
		if (b == 0) return a;
		return gcd(b, a % b);
	}
	
	private static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}
	
}
