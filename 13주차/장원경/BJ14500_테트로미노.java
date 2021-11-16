import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
/*https://velog.io/@skyepodium/%EB%B0%B1%EC%A4%80-14500-%ED%85%8C%ED%8A%B8%EB%A1%9C%EB%AF%B8%EB%85%B8*/
public class BJ14500_테트로미노 {
	static int map[][];
	
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static boolean v[][];
	static int N, M;
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		v = new boolean[N][M];
		max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				v[i][j] = true;
				check(i, j);
				dfs(i, j, 1, map[i][j]);
				v[i][j] = false;
			}
		}
		System.out.println(max);
	}
	//ㅗ모양 체크
	private static void check(int i, int j) {
	
		if(i+1<N && j+2<M) {
			int sum=map[i][j]+map[i][j+1]+map[i][j+2]+map[i+1][j+1];
			if(max<sum) max=sum;
		}
		
		if(i+2<N && j+1<M) {
			int sum=map[i][j]+map[i+1][j]+map[i+2][j]+map[i+1][j+1];
			if(max<sum) max=sum;
		}
		
		if(i-1>=0 && j+2<M) {
			int sum=map[i][j]+map[i][j+1]+map[i][j+2]+map[i-1][j+1];
			if(max<sum) max=sum;
		}
		
		if(i-1>=0 && i+1<N && j+1<M) {
			int sum=map[i][j]+map[i-1][j+1]+map[i][j+1]+map[i+1][j+1];
			if(max<sum) max=sum;
		}
		
	}

	public static void dfs(int r, int c, int cnt, int sums) {

		if (cnt == 4) {
			if (sums > max)
				max = sums;
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nr >= N || nc < 0 || nc >= M)
				continue;

			if (!v[nr][nc]) {
				v[nr][nc] = true;
				dfs(nr, nc, cnt + 1, sums + map[nr][nc]);
				v[nr][nc] = false;
			}
		}
	}
}