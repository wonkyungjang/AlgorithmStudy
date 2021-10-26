import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2529 {

	static int k;
	static int[] bu;
	static int[] nums;
	static int[] fnums;
	static boolean[] visited = new boolean[10];
	static boolean isFind = false;
	
	static void solution(int cnt) {
		if (cnt == k+1) {
			if (!isFind) {
				for (int i = 0; i < k+1; i++) {
					System.out.print(nums[i]);
				}
				System.out.println();
				isFind = true;
				System.arraycopy(nums, 0, fnums, 0, k+1);
				return;
			}
			System.arraycopy(nums, 0, fnums, 0, k+1);
			return;
		}
		if (bu[cnt-1] == 1) {
			for (int i = 9; i > nums[cnt-1]; i--) {
				if (visited[i]) continue;
				visited[i] = true;
				nums[cnt] = i;
				solution(cnt+1);
				visited[i] = false;
			}
		}
		else {
			for (int i = nums[cnt-1]-1; i >= 0; i--) {
				if (visited[i]) continue;
				visited[i] = true;
				nums[cnt] = i;
				solution(cnt+1);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		bu = new int[k];
		nums = new int[k+1];
		fnums = new int[k+1];
		StringTokenizer stn = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			char b = stn.nextToken().charAt(0);
			if (b == '<') bu[i] = 1;
		}
		for (int i = 9; i >= 0; i--) {
			visited[i] = true;
			nums[0] = i;
			solution(1);
			visited[i] = false;
		}
		for (int i = 0; i < k+1; i++) {
			System.out.print(fnums[i]);
		}
		System.out.println();
	}

}
