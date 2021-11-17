package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_완전이진트리_재귀_9935 {
	static int K;
	static StringBuilder Answer;
	static StringBuilder[] List;
	static int[] Nums;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Answer = new StringBuilder();
		
		K = Integer.parseInt(br.readLine());
		Nums = new int[(int)Math.pow(2, K)-1];
		
		List = new StringBuilder[K];
		for (int i = 0; i < K; i++) {
			List[i] = new StringBuilder();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < Nums.length; i++) {
			Nums[i] = Integer.parseInt(st.nextToken());
		}
		
		middle(Nums,0);
		for (int i = 0; i < K; i++) {
			Answer.append(List[i]).append("\n");
		}
		System.out.println(Answer);	
	}

	private static void middle(int[] arr, int level) {
		// 배열이 크기가 1라면 끝
		if(arr.length == 1) {
			List[level].append(arr[0]+" ");
			return;
		}
		// 가운데 추출
		int mid = arr.length/2;
		List[level].append(arr[mid]+" ");
		//양쪽 보내기
		middle(Arrays.copyOfRange(arr, 0, mid), level+1);
		middle(Arrays.copyOfRange(arr, mid+1, arr.length), level+1);
	}
}
