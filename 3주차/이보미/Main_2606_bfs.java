import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2606_bfs {

// bfs : 재귀적으로 동작하지 않음, 어떤 노드를 방문했는지 검사
//	   : 큐 사용, 두 노드사이에 최단경로 또는 임의 경로를 찾을 때 사용
	
	static int N;
	static int C;
	static int [][] network;
	static boolean [] visit;
	static int cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		C = Integer.parseInt(br.readLine());
		network = new int[N+1][N+1];
		visit = new boolean[N+1];
		cnt = 0;
		
		for (int i = 0; i < C; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int c1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			network[c1][c2] = network[c2][c1] = 1;
		}
		
		bfs(1);
		
		System.out.println(cnt);
	}

	private static void bfs(int i) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(i);
		visit[i] = true;
		
		while(!que.isEmpty()) {
			int temp = que.poll();
			for (int j = 1; j < N+1; j++) {
				if(network[temp][j] == 1 && !visit[j]) {
					que.offer(j);
					visit[j] = true;
					cnt++;
				}
			}
		}
		
	}

}
