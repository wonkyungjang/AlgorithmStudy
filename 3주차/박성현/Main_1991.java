import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1991 {

	static int n;
	
	static class Node {
		char data;
		Node l;
		Node r;
		public Node(char d) {
			data = d; 
			l = null;
			r = null;
		}
		public void addLeft(Node l) {
			this.l = l;
		}
		public void addright(Node r) {
			this.r = r;
		}
	}
	
	public static void preOrder(Node node) {
		if (node == null) return;
		System.out.print(node.data);
		preOrder(node.l);
		preOrder(node.r);
	}
	
	public static void inOrder(Node node) {
		if (node == null) return;
		inOrder(node.l);
		System.out.print(node.data);
		inOrder(node.r);
	}
	
	public static void postOrder(Node node) {
		if (node == null) return;
		postOrder(node.l);
		postOrder(node.r);
		System.out.print(node.data);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		Node[] tree = new Node[n];
		for (int i = 0; i < n; i++) {
			tree[i] = new Node((char)('A'+i));
		}
		for (int i = 0; i < n; i++) {
			StringTokenizer stn = new StringTokenizer(br.readLine());
			char d = stn.nextToken().charAt(0);
			char l = stn.nextToken().charAt(0);
			if (l != '.') {
				tree[d-'A'].addLeft(tree[l-'A']);
			}
			char r = stn.nextToken().charAt(0);
			if (r != '.') {
				tree[d-'A'].addright(tree[r-'A']);
			}
		}
		preOrder(tree[0]);
		System.out.println();
		inOrder(tree[0]);
		System.out.println();
		postOrder(tree[0]);
		System.out.println();
	}

}
