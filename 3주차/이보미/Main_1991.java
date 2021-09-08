import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1991 {

	static int N;
	static public class Node {
		char data;
		Node left, right;
		
		public Node (char data) {
			this.data = data;
		}
	}
	
	static public class Tree {
		Node root;
		
		public void createNode(char data, char leftData, char rightData) {
			if(root == null) {
				root = new Node(data);
				root.left = leftData != '.' ? new Node(leftData) : null;
				root.right = rightData != '.' ? new Node(rightData) : null;
			}else {
				searchNode(root, data, leftData, rightData);
			}
		}

		private void searchNode(Node node, char data, char leftData, char rightData) {
			if( node == null) {
				return;
			}else if(node.data == data) {
				node.left = leftData != '.' ? new Node(leftData) : null;
				node.right = rightData != '.' ? new Node(rightData) : null;
			}else {
				searchNode(node.left, data, leftData, rightData); 
	            searchNode(node.right, data, leftData, rightData);
			}
			
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		Tree tree = new Tree();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			tree.createNode(st.nextToken().charAt(0), st.nextToken().charAt(0), st.nextToken().charAt(0));
			
		}
		
		preOrder(tree.root);
		System.out.println();
		inOrder(tree.root);
		System.out.println();
		postOrder(tree.root);
	}

	private static void preOrder(Node node) {
		if(node != null) {
			System.out.print(node.data);
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	private static void inOrder(Node node) {
		if(node != null) {
			inOrder(node.left);
			System.out.print(node.data);
			inOrder(node.right);
		}
	}

	private static void postOrder(Node node) {
		if(node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node.data);
		}
	}
}
