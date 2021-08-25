import java.util.Scanner;

public class JUNGGOL_1523_별삼각형1 {

	static int N,M;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		
		if(M==1 && N>=1 && N<=100) star1(N);
		else if(M==2 && N>=1 && N<=100) star2(N);
		else if(M==3 && N>=1 && N<=100) star3(N);
		else { 
			System.out.println("INPUT ERROR!");
		}	
		}
	private static void star1(int n) {
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<i+1;j++)
				System.out.print("*");
			System.out.println();
		}
		
	}
	private static void star2(int n) {
		
		for(int i=n;i>0;i--) {
			for(int j=0;j<i;j++)
				System.out.print("*");
			System.out.println();
		}
		
	}
	private static void star3(int n) {
		
		for(int i=0;i<n;i++) {
			for(int j=1;j<n-i;j++)
				System.out.print(" ");
			
			
			for(int j=0;j<i*2+1;j++)
				System.out.print("*");
			System.out.println();
		}
		
	}
	

}
