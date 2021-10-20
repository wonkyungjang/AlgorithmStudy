import java.util.Scanner;

public class Main_15652 {

	static int n, m;
	static int[] arr;
	static int[] num;
	static StringBuilder sb;
	
	static void nm4(int cnt, int start) {
		if (cnt == m) {
			for (int i = 0 ; i < m; i++) {
				sb.append(num[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		for (int i = start; i < n; i++) {
			num[cnt] = arr[i];
			nm4(cnt+1, i);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i+1;
		}
		num = new int[m];
		sb = new StringBuilder();
		nm4(0, 0);
		System.out.println(sb);
	}

}
