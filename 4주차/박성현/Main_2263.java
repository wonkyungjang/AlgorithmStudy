import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2263 {

	static int n;
	static int[] inOrder;
	static int[] postOrder;
	static Stack<store> stack = new Stack<>();
	
	static class store {
		int pi;
		int ii;
		int num;
		public store(int pi, int ii, int num) {
			this.pi = pi;
			this.ii = ii;
			this.num = num;
		}
	}
	
	static void preOrder(int pindex, int iindex, int num) {
		int node = postOrder[pindex];
		int pi = pindex;
		int ii = iindex;
		int n = 0;
		int cnt = 0;
		
		for (int i = 0; i < num; i++) {
			if (inOrder[ii-n] == node) {
				System.out.print(node);
				System.out.print(" ");
				if (n > 0) {
					cnt++;
					stack.push(new store(pi-1, ii, n));
					pi = pi-n-1;
					ii = ii-n-1;
					if (pi >= 0) node = postOrder[pi];

				}
				else if (i < num-1){
					pi = pi-1;
					ii = ii-1;
					if (pi >= 0) node = postOrder[pi];
				}
				n = -1;
			}
			n++;
		}
		
		for (int i = 0; i < cnt; i++) {
			store t = stack.pop();
			preOrder(t.pi, t.ii, t.num);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		inOrder = new int[n];
		postOrder = new int[n];
		StringTokenizer stn = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			inOrder[i] = Integer.parseInt(stn.nextToken());
		}
		stn = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			postOrder[i] = Integer.parseInt(stn.nextToken());
		}
		preOrder(n-1, n-1, n);
	}

}
