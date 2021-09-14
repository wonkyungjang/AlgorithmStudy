package _04_0915;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 절댓값 힙
public class Main_BOJ_11286 {
	
	static int N;
	static PriorityQueue<Integer> pq;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pq = new PriorityQueue<>((n1, n2) -> {
			if (Math.abs(n1) == Math.abs(n2)) return n1 - n2;
			return Math.abs(n1) - Math.abs(n2);
		});
				
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				if (pq.size() == 0) sb.append("0\n");
				else sb.append(pq.poll() + "\n");
			} else {				
				pq.add(num);
			}
		}
		System.out.println(sb);
	}
	
}
