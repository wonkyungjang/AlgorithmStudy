import java.util.Scanner;

public class Main_2609 {
	
	static int gcd(int a, int b) {
		if (a < b) {
			int t = a;
			a = b;
			b = t;
		}
		if (a%b == 0) return b;
		return gcd(b, a%b);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int g = gcd(a, b);
		System.out.println(g);
		System.out.println(a*b/g);

	}

}
