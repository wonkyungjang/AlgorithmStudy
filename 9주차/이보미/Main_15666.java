import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

// N과 M (12)
public class Main_15666 {
	
	static int N, M;
	static int [] nums;
	static int [] inputs;
	// LinkedHashSet : 중복되는 값은 저장하지 않고 입력순으로 정렬
	static LinkedHashSet<String> result;
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		N = scann.nextInt();
		M = scann.nextInt();
		
		nums = new int[M];
		inputs = new int[N];
		result = new LinkedHashSet<>();
		
		for (int i = 0; i < N; i++) {
			inputs[i] = scann.nextInt();
		}
		
		Arrays.sort(inputs);
		combination(0, 0);

		for (String str : result) {
			System.out.println(str);
		}
	}

	private static void combination(int cnt, int start) {
		if(cnt == M) {
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < M; i++) {
				sb.append(nums[i]+" ");
			}
			result.add(sb.toString());
			return;
		}
		
		for (int i = start; i < N; i++) {
			
			nums[cnt] = inputs[i];
			combination(cnt+1, i);
			
		}
	}

}

