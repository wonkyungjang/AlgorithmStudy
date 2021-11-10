import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthSpinnerUI;

// 감시
public class Main_15683 {

	static int N, M;
	static int [][] map;
	static int min = Integer.MAX_VALUE;
	static int [] dr = {-1, 0, 1, 0};
	static int [] dc = {0, 1, 0, -1};
	static int[][][] ccDir = { // 각 cctv가 볼 수 있는 영역(회전)
	            {{0}},
	            {{1}, {2}, {3}, {0}}, // 1번 cctv
	            {{1, 3}, {0, 2}}, // 2번 cctv
	            {{0, 1}, {1, 2}, {2, 3}, {3, 0}}, // 3번 cctv
	            {{0, 1, 3}, {0, 1, 2}, {1, 2, 3}, {2, 3, 0}}, // 4번 cctv
	            {{0, 1, 2, 3}} // 5번 cctv
	            };

	static ArrayList<ccInfo> cclist = new ArrayList<>();
	
	static class ccInfo {
		int n;
		int r;
		int c;
		
		public ccInfo(int n, int r, int c) {
			super();
			this.n = n;
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > 0 && map[i][j] < 6) {
					cclist.add(new ccInfo(map[i][j], i, j));
				}
			}
		}
		
		perm(0, map);
		
		System.out.println(min);
	}

	private static void perm(int cnt, int [][] map) {
		if(cnt == cclist.size()) {
			
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == 0) count++;
				}
			}
	
			min = Math.min(min, count);
			return;
		}
		
		ccInfo cctv = cclist.get(cnt);
		
		int [][] temp = new int[N][M];
		copy(temp, map);
		
		for (int i = 0; i < ccDir[cctv.n].length; i++) { // 리스트안의 cctv 타입의 방향 개수
			for (int j = 0; j < ccDir[cctv.n][i].length; j++) { // cctv의 여러 방향 탐색
				int d = ccDir[cctv.n][i][j];
				monitoring(cctv.r, cctv.c, d, temp);
			}
			perm(cnt+1, temp);

			copy(temp, map); // 새로운 방향을 위해 temp를 처음 받은 map으로 되돌리기
		}
		
	}

	private static void copy(int[][] temp, int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = map[i][j];
			}
		}
		
	}

	private static void monitoring(int r, int c, int d, int[][] temp) {
		
		 while(true) {
	            
	            r += dr[d];
	            c += dc[d];
	            
	            // 범위를 벗어나거나 벽이 있다면
	            if(r < 0 || r >= N || c < 0 || c >= M || temp[r][c] == 6) break;
	            // 다른 CCTV가 있거나 이미 감시된 영역일 경우 pass
	            if((temp[r][c] >= 1 && temp[r][c] <= 5) || temp[r][c] == 7) continue;
	            // 빈 칸일 경우
	            temp[r][c] = 7;
	        }
		
	}

}
