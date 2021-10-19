import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

// N과 M (9)
public class Main_15663 {
	
	static int N, M;
	static int [] nums;
	static int [] inputs;
	static boolean [] visit;
	// LinkedHashSet : 중복되는 값은 저장하지 않고 입력순으로 정렬
	static LinkedHashSet<String> result;
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		N = scann.nextInt();
		M = scann.nextInt();
		
		nums = new int[M];
		inputs = new int[N];
		visit = new boolean[N];
		result = new LinkedHashSet<>();
		
		for (int i = 0; i < N; i++) {
			inputs[i] = scann.nextInt();
		}
		
		Arrays.sort(inputs);
		permutation(0);

		for (String str : result) {
			System.out.println(str);
		}
	}

	private static void permutation(int cnt) {
		if(cnt == M) {
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < M; i++) {
				sb.append(nums[i]+" ");
			}
			result.add(sb.toString());
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(visit[i]) continue;
			
			nums[cnt] = inputs[i];
			visit[i] = true;
			permutation(cnt+1);
			visit[i] = false;
		}
	}

}
