import java.util.Scanner;

public class Main_2798 {

	static int N;
	static int M;
	static int [] card;
	static int min;
	static int result;
	static int R = 3;
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		N = scann.nextInt();
		M = scann.nextInt();
		card = new int[N];
		
		for (int i = 0; i < N; i++) {
			card[i] = scann.nextInt();
		}
		
		min = Integer.MAX_VALUE;
		result = 0;
		combination(0, 0, 0);
		
		System.out.println(result);
	}

	private static void combination(int start, int cnt, int sum) {
		if(cnt == R) {
			if(M >= sum && (M-sum) < min) {
				min = M-sum;
				result = sum;
			}
			return;
		}
		
		for (int i = start; i < N; i++) {
			combination(i+1, cnt+1, sum+card[i]);
		}
	}

}
