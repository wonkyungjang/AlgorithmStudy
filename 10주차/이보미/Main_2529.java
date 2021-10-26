import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 부등호
public class Main_2529 {
	
	static int K;
	static String [] sign;
	static boolean [] visit;
	static int [] nums;
	static long max = Long.MIN_VALUE;
	static long min = Long.MAX_VALUE;
	static String minStr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(br.readLine());
		sign = new String[K];
		nums = new int[K+1];
		visit = new boolean[10];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			sign[i] = st.nextToken();
		}
		
		perm(0);

		System.out.println(max);
		System.out.println(minStr);
	}

	private static void perm(int cnt) {
		if(cnt == K+1) {
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < K+1; i++) {
				sb.append(nums[i]).append("");
			}
			
			long temp = Long.parseLong(sb.toString());
			max = Math.max(max, temp);
					
			if(min > temp) {
				min = temp;
				minStr = sb.toString();
			}
			
			return;
		}
		
		for (int i = 0; i < 10; i++) {
			if(visit[i]) continue;
			
			nums[cnt] = i;
			
			if(cnt > 0) {
				if(sign[cnt-1].equals("<")) {
					if(nums[cnt-1] > nums[cnt]) continue;
				} else if(sign[cnt-1].equals(">")) {
					if(nums[cnt-1] < nums[cnt]) continue;
				}
			}
			
			visit[i] = true;
			perm(cnt+1);
			visit[i] = false;
		}
	}

}
