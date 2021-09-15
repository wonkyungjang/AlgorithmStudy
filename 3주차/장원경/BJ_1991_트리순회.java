import java.util.Arrays;

import java.util.Scanner;

public class BJ_1991_트리순회 {
	static int N;
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		N= sc.nextInt();
		arr=new int[26][2];
		for(int i=0;i<N;i++) {
			char node=sc.next().charAt(0);
			char left=sc.next().charAt(0);
			char right=sc.next().charAt(0);
			
			if(left!='.') arr[node-'A'][0]=left-'A';
			else arr[node-'A'][0]=-1;
			
			if(right!='.')arr[node-'A'][1]=right-'A';
			else arr[node-'A'][1]= -1;
		}
		preorder(0);
		System.out.println();
		inorder(0);
		System.out.println();
		postorder(0); 
		}
	//전위 순회 : root > 왼 > 오
	private static void preorder(int i) {
		System.out.print((char)(i+65));
		if(arr[i][0]!=-1) preorder(arr[i][0]);
		if(arr[i][1]!=-1)preorder(arr[i][1]);
	}
	//중위 순회 : 왼 > root >오
	private static void inorder(int i) {
		if(arr[i][0]!=-1) inorder(arr[i][0]);
		System.out.print((char)(i+65));
		if(arr[i][1]!=-1) inorder(arr[i][1]);
	}
	//후위 순회 : 왼 > 오 > root
	private static void postorder(int i) {
		if(arr[i][0]!=-1) postorder(arr[i][0]);
		if(arr[i][1]!=-1) postorder(arr[i][1]);
		System.out.print((char)(i+65));
	}
	}


