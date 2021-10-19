import java.util.Arrays;
import java.util.Scanner;

// N과 M (6)
public class Main_15655 {

	static int N, M;
	static int [] nums;
	static int [] inputs;
	static boolean [] visit;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		N = scann.nextInt();
		M = scann.nextInt();
		
		nums = new int[M];
		inputs = new int[N];
		visit = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			inputs[i] = scann.nextInt();
		}
		
		Arrays.sort(inputs);
		
		combination(0, 0);

		System.out.println(sb.toString());
	}

	private static void combination(int cnt, int start) {
		if(cnt == M) {
			
			for (int i = 0; i < M; i++) {
				sb.append(nums[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start; i < N; i++) {
			if(visit[i]) continue;
			
			nums[cnt] = inputs[i];
			visit[i] = true;
			combination(cnt+1, i+1);
			visit[i] = false;
		}
	}

}
