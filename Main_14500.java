import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 테트로미노
public class Main_14500 {
	
	static int N, M;
	static int [][] map;
	static boolean [][] v;
	static int [] dr = {-1, 1, 0, 0};
	static int [] dc = {0, 0, -1, 1};
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		v = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				v[i][j] = true;
				dfs(i, j, 0, map[i][j]);
				v[i][j] = false;
			}
		}
		
		// ㅗ모양 완탐
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				search(i, j, map[i][j]);
			}
		}
		
		System.out.println(max);
	}

	private static void search(int r, int c, int sum) {
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int d = 0; d < 4; d++) { // 4방 탐색으로 값을 list에 넣어줌
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if (nr>=0 && nr<N && nc>=0 && nc<M) {
				list.add(map[nr][nc]);
			}
		}
		
		if (list.size() == 3) { // 자기 자신 sum 포함 3개여야 ㅗ 모양
			for (int i = 0; i < list.size(); i++) {
				sum += list.get(i);
			}
		}else if (list.size() == 4) {
			Collections.sort(list);
			for (int i = list.size()-1; i > 0; i--) {
				sum += list.get(i);
			}
		}
		
		max = Math.max(max, sum);
	}

	private static void dfs(int r, int c, int cnt, int sum) {
		// ㅗ 모양 빼고 dfs를 통해 테트로미노 탐색 가능
		if(cnt == 3) {
			max = Math.max(max, sum);
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if (nr>=0 && nr<N && nc>=0 && nc<M && !v[nr][nc]) {
				v[nr][nc] = true;
				dfs(nr, nc, cnt+1, sum+map[nr][nc]);
				v[nr][nc] = false;
			}
		}
		
	}

}
