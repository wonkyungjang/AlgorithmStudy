import java.util.Scanner;

public class Main_jungol_1329 {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		int n = scann.nextInt();
		
		if(n>0 && n <= 100 && n % 2 ==1) {
			for (int i = 0; i <= n/2; i++) {
				for (int j = 0; j < i; j++) {
					System.out.print(" ");
				}
				for (int j = 0; j < 2*i+1; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			
			for (int i = n/2-1; i >=0; i--) {
				for (int j = 0; j < i; j++) {
					System.out.print(" ");
				}
				for (int j = 0; j < 2*i+1; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}else {
			System.out.println("INPUT ERROR!");
		}

	}

}
