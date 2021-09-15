import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// dfs : 모든 관계를 다 살펴봐야 할 경우
// bfs : 특정한 노드의 가까운 관계부터 탐색할 경우
public class Main_2606 {

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
			network[c1][c2] = 1;
			network[c2][c1] = 1;
		}

		dfs(1);
		
		System.out.println(cnt-1);
	}

	private static void dfs(int i) {
		visit[i] = true;
		cnt++;
		
		for (int j = 1; j < N+1; j++) {
			if(network[i][j] == 1 && visit[j] == false) {
				dfs(j);
			}
		}
	}

}
