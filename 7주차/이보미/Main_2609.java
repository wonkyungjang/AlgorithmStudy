import java.util.Scanner;

public class Main_2609 {
	
	static int n, m;
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		n = scann.nextInt();
		m = scann.nextInt();

		int result = gcd(n, m); // 최대 공약수
		
		System.out.println(result);
		System.out.println((n * m)/result);
		
	}

	private static int gcd(int a, int b) { // 재귀 방식
		if(b == 0) {
			return a;
		}
		
		// GCD(a, b) = GCD(b, r)이므로 (r = a % b)
		return gcd(b, a % b);
	}
	
	public static int gcd1(int a, int b) { // 반복문 방식
		 
		while (b != 0) {
			int r = a % b; // 나머지를 구해준다.
 
			// GCD(a, b) = GCD(b, r)이므로 변환한다.
			a = b;
			b = r;
		}
		return a;
	}
}
