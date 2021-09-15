import java.util.Scanner;

public class JUNGOL_1719_별삼각형2 {

	static int n,m;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		//
		if(n%2==1 && (n>=1 && n<=100) && m==1) {
			star1();
		}else if(n%2==1 && (n>=1 && n<=100) && m==2) {
			star2();
		}else if(n%2==1 && (n>=1 && n<=100) && m==3) {
			star3();
		}else if(n%2==1 && (n>=1 && n<=100) && m==4) {
			star4();
		}else
			System.out.println("INPUT ERROR!");

	}
	private static void star4() {
		int point=n/2;
		for(int i=0;i<=point;i++) {
			for(int j=0;j<i;j++) {
				System.out.print(" ");
			}
			for(int j=0;j<n-point-i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=point+1;i<n;i++) {
			for(int j=0;j<point;j++) {
				System.out.print(" ");
			}
			for(int j=0;j<i-point+1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	private static void star3() {
		int point=n/2;
		for(int i=0;i<=point;i++) {
			for(int j=0;j<i;j++) {
				System.out.print(" ");
			}for(int j=0;j<2*(point-i)+1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=point+1;i<n;i++) {
			for(int j=0;j<n-1-i;j++) {
				System.out.print(" ");
			}for(int j=0;j<2*(i-point)+1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
	private static void star2() {
		int point=n/2;
		for(int i=0;i<=point;i++) {
			for(int j=0;j<point-i;j++) {
				System.out.print(" ");
			}
			for(int j=0;j<i+1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=point+1;i<n;i++) {
			for(int j=0;j<i-point;j++) {
				System.out.print(" ");
			}
			for(int j=0;j<n-i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	private static void star1() {
		int point = n/2;
		for(int i=0;i<=point;i++) {
			for(int j=0;j<i+1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=point+1;i<n;i++) {
			for(int j=0;j<n-i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
