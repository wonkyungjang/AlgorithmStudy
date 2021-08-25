import java.util.Scanner;

public class Main_jungol_1523 {
	
	static int n, m;
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		n = scann.nextInt();
		m = scann.nextInt();
		
		if(n > 0 && n <= 100) {
			switch (m) {
			case 1: print1(n);
				break;
			case 2: print2(n);
				break;
			case 3: print3(n);
				break;
			default:
				System.out.println("INPUT ERROR!");
				break;
			}
		}else {
			System.out.println("INPUT ERROR!");
		}
	}

	private static void print3(int n) { // 이등변삼각형
		for (int i = 1; i <= n; i++) {
			for (int j = i; j < n; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 2*i-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void print2(int n) { // 역삼각형
		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= n; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	} 

	private static void print1(int n) { // 직각삼각형
		for (int i = 1; i <= n; i++) {
			for (int j = n-i; j < n; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
