import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2606 {

	static int n, c;
	static boolean[][] com;
	
	public static void dfs() {
		int num = 0;
		boolean[] visited = new boolean[n+1];
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		visited[1] = true;
		while (stack.size() > 0) {
			int c = stack.pop();
			if (!visited[c]) num++;
			visited[c] = true;
			for (int i = 1; i < n+1; i++) {
				if (!visited[i] && com[c][i]) {
					stack.push(i);
				}
			}
		}
		System.out.println(num);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		c = Integer.parseInt(br.readLine());	
		com = new boolean[n+1][n+1];
		for (int i = 0; i < c; i++) {
			StringTokenizer stn = new StringTokenizer(br.readLine());
			int c1 = Integer.parseInt(stn.nextToken());
			int c2 = Integer.parseInt(stn.nextToken());
			com[c1][c2] = true;
			com[c2][c1] = true;
		}
		dfs();
	}

}
