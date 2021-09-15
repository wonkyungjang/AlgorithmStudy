import java.util.Scanner;

public class Main_jungol_1719 {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		int n = scann.nextInt();
		int m = scann.nextInt();
		
		if(n>0 && n <= 100 && n % 2 == 1) {
			switch (m) {
			case 1: print1(n);
				break;
			case 2: print2(n);
				break;
			case 3: print3(n);
				break;
			case 4: print4(n);
				break;
			default: System.out.println("INPUT ERROR!");
				break;
			}
		}else {
			System.out.println("INPUT ERROR!");
		}
	}

	private static void print1(int n) {
		int k = 0;
		for (int i = 0; i <= n/2; i++) {
			k++;
			for (int j = 0; j < k; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for (int i = 0; i < n/2; i++) {
			k--;
			for (int j = 0; j < k; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void print2(int n) {
		int k = n/2;
		for (int i = 0; i <= n/2; i++) {
			for (int j = 0; j < k; j++) {
				System.out.print(" ");
			}
			for (int j = k; j <= n/2; j++) {
				System.out.print("*");
			}
			System.out.println();
			k--;
		}
		k++;
		for (int i = 0; i < n/2; i++) {
			k++;
			for (int j = 0; j < k; j++) {
				System.out.print(" ");
			}
			for (int j = k; j <= n/2; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void print3(int n) {
		for (int i = 0; i <= n/2; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = i; j < n-i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = n/2-1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = i; j < n-i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void print4(int n) {
		for (int i = 0; i <= n/2; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = i; j <= n/2; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 1; i <= n/2; i++) {
			for (int j = 0; j < n/2; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
