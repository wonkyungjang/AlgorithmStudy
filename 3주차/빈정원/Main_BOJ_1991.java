package _03_0908;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 트리 순회
public class Main_BOJ_1991 {
	
	static final int LEFT = 0, RIGHT = 1;

	static int N;
	static int[][] tree;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tree = new int[26][2];	// 완전이진트리가 아니므로 노드의 최대 개수인 26으로 선언
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int root = st.nextToken().charAt(0) - 'A';
			tree[root][LEFT] = st.nextToken().charAt(0) - 'A';
			tree[root][RIGHT] = st.nextToken().charAt(0) - 'A';
		}

		sb = new StringBuilder();
		preorder(0);
		sb.append('\n');
		inorder(0);
		sb.append('\n');
		postorder(0);
		System.out.println(sb);
	}

	public static void preorder(int root) {
		sb.append((char)('A' + root));										// root
		if (tree[root][LEFT] != '.' - 'A') preorder(tree[root][LEFT]);		// left
		if (tree[root][RIGHT] != '.' - 'A') preorder(tree[root][RIGHT]);	// right
	}
	
	public static void inorder(int root) {
		if (tree[root][LEFT] != '.' - 'A') inorder(tree[root][LEFT]);		// left
		sb.append((char)('A' + root));										// root
		if (tree[root][RIGHT] != '.' - 'A') inorder(tree[root][RIGHT]);		// right
	}
	
	public static void postorder(int root) {
		if (tree[root][LEFT] != '.' - 'A') postorder(tree[root][LEFT]);		// left
		if (tree[root][RIGHT] != '.' - 'A') postorder(tree[root][RIGHT]);	// right
		sb.append((char)('A' + root));										// root
	}
	
}
