import java.util.Scanner;

// N과 M (3)
public class Main_15651 {

	static int N, M;
	static int [] nums;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		N = scann.nextInt();
		M = scann.nextInt();
		
		nums = new int[M];
		
		permutation(0);
		
		System.out.println(sb.toString());
	}

	private static void permutation(int cnt) {
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(nums[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 1; i < N+1; i++) {
			
			nums[cnt] = i;
			permutation(cnt+1);
			
		}
		
	}

}
