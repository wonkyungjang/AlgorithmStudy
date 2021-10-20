import java.util.Arrays;
import java.util.Scanner;

public class Main_15656 {

	static int n, m;
	static int[] arr;
	static int[] num;
	static StringBuilder sb;
	
	static void nm7(int cnt) {
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				sb.append(num[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		for (int i = 0; i < n; i++) {
			num[cnt] = arr[i];
			nm7(cnt+1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		num = new int[m];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		sb = new StringBuilder();
		nm7(0);
		System.out.println(sb);
	}

}
