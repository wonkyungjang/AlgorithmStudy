package _03_0908;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 바이러스
public class Main_BOJ_2606 {
	
	static int N, M;
	static ArrayList<Integer>[] adjList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		// 인접리스트 초기화
		adjList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			adjList[i] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			// 양방향으로 넣어주기
			adjList[start].add(end);
			adjList[end].add(start);
		}
		System.out.println(bfs(new boolean[N + 1]));
	}

	public static int bfs(boolean[] v) {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		v[1] = true;
		int ans = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			int len = adjList[cur].size();
			for (int i = 0; i < len; i++) {
				int nxt = adjList[cur].get(i);
				if (!v[nxt]) {
					q.add(nxt);
					v[nxt] = true;
					ans++;
				}
			}
		}
		return ans;
	}

}
