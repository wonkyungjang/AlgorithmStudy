import java.util.Scanner;

// 신나는 함수 실행
public class Main_9184 {

	static int [][][] dp = new int[21][21][21];
	
	public static void main(String[] args) {
		
		Scanner scann = new Scanner(System.in);
		
		while(true) {
			
			int a = scann.nextInt();
			int b = scann.nextInt();
			int c = scann.nextInt();
			
			if(a == -1 && b == -1 && c == -1) {
				break;
			}
			
			System.out.println("w(" + a + ", " + b + ", " + c +") = " + cal(a, b, c));
		}

	}

	private static int cal(int a, int b, int c) {
		// a, b, c가 범위를 벗어나지 않으면서 메모이제이션이 되어있는 경우
		if(check(a, b, c) && dp[a][b][c] != 0) {
				return dp[a][b][c];
		}
				
		if(a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}
				
		if(a > 20 || b > 20 || c > 20) {
			return dp[20][20][20] = cal(20, 20, 20);
		}
				
		if(a < b && b < c) {
			return dp[a][b][c] = cal(a, b, c - 1) + cal(a, b - 1, c - 1) - cal(a, b - 1, c);
		}
				
		return dp[a][b][c] = cal(a - 1, b, c) + cal(a - 1, b - 1, c) + cal(a - 1, b, c - 1) - cal(a - 1, b - 1, c - 1);
		
	}
	
	private static boolean check(int a, int b, int c) {
		return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20; 
	}

}
