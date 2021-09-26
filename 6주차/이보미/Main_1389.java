import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1389 {

	static int N, M;
	static int [][] graph;
	static int INF = 1000000000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N+1][N+1];
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				if(i == j) {
					graph[i][j] = 0;
				}else {
					graph[i][j] = INF;
				}
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			graph[start][end] = graph[end][start] = 1;	
		}

		for (int k = 1; k < N+1; k++) {
			for (int i = 1; i < N+1; i++) {
				for (int j = 1; j < N+1; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		int sum = 0;
		int result = 0;
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				sum += graph[i][j];
			}
			if(sum < min) {
				min = sum;
				result = i;
			}
			sum = 0;
		}
		
		System.out.println(result);
	}

}
