import java.util.Scanner;

public class JUNGOL_1329_별삼각형3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		
		if(N%2==0||N<1||N>100) {
			System.out.println("INPUT ERROR!");
		}else {
			
			int point=N/2;
			
			for(int i=0;i<=point;i++) {
				for(int j=0;j<i;j++) {
					System.out.print(" ");
				}
				for(int j=0;j<2*i+1;j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			for(int i=point+1;i<N;i++) {
				for(int j=0;j<N-1-i;j++) {
					System.out.print(" ");
				}
				for(int j=0;j<2*(N-1-i)+1;j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			
			
			
			
			
			
		}

	}

}
