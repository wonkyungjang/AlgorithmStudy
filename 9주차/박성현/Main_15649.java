import java.util.Scanner;

public class Main_15649 {

	static int n, m;
	static int[] arr;
	static int[] num;
	static StringBuilder sb;
	
	static void nm1(int cnt, boolean[] v) {
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				sb.append(num[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		for (int i = 0; i < n; i++) {
			if (v[i]) continue;
			num[cnt] = arr[i];
			v[i] = true;
			nm1(cnt+1, v);
			v[i] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		num = new int[m];
		for (int i = 0; i < n; i++) {
			arr[i] = i+1;
		}
		sb = new StringBuilder();
		nm1(0, new boolean[n]);
		System.out.println(sb);
	}

}
