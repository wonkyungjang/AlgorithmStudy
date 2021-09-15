package _04_0915;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 트리의 순회
public class Main_BOJ_2263 {

	static int N, idx;
	static int[] pre, in, post; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pre = new int[N];
		in = new int[N];
		post = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			in[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			post[i] = Integer.parseInt(st.nextToken());
		
		preorder(0, N - 1, 0, N - 1);
		
		for (int i = 0; i < N; i++)
			System.out.print(pre[i] + " ");
	}

	public static void preorder(int inStart, int inEnd, int postStart, int postEnd) {
		if (inStart <= inEnd && postStart <= postEnd) {
			pre[idx++] = post[postEnd];
			int root = inStart;
			for (int i = inStart; i <= inEnd; i++) {
				if (in[i] == post[postEnd]) {
					root = i;
					break;
				}
			}
			preorder(inStart, root - 1, postStart, postStart + root - inStart - 1);	// 왼쪽
			preorder(root + 1, inEnd, postStart + root - inStart, postEnd - 1);	// 오른쪽
		}
	}

}
