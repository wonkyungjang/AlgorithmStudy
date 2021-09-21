package _05_0924;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 상근이의 여행
public class Main_BOJ_9372 {

	static int T, V, E;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			// 모든 국가를 여행하기 위한 최소 비행기 개수는 전체 국가의 수 - 1이므로 비행기의 종류는 필요 없음
			for (int i = 0; i < E; i++) br.readLine();
			System.out.println(V - 1);
		}
	}

}
