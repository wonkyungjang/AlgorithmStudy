import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4615 {

	static int T;
	static int n, m;
	static int[][] mp;
	static int w, b;
	static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
	static int[] dy = {0, 0, 1, -1, 1, -1, -1, 1};
	
	public static boolean check(int x, int y) {
		if (x < n && y < n && x >= 0 && y >= 0) return true;
		else return false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			StringTokenizer stn = new StringTokenizer(br.readLine());
			n = Integer.parseInt(stn.nextToken());
			m = Integer.parseInt(stn.nextToken());
			mp = new int[n][n];
			
			mp[n/2-1][n/2-1] = 2;
			mp[n/2][n/2] = 2;
			mp[n/2-1][n/2] = 1;
			mp[n/2][n/2-1] = 1;
			
			for (int i = 0; i < m; i++) {
				stn = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(stn.nextToken()) - 1;
				int y = Integer.parseInt(stn.nextToken()) - 1;
				int kind = Integer.parseInt(stn.nextToken());
				mp[x][y] = kind;			
				for (int k = 0; k < 8; k++) {
					int cx = x + dx[k];
					int cy = y + dy[k];
					int num = 0;
					while (check(cx, cy)) {
						if (mp[cx][cy] == kind) {
							for (int kk = 0; kk < num; kk++) {
								mp[x + (kk+1)*dx[k]][y + (kk+1)*dy[k]] = kind;
							}
							break;
						}
						else if (mp[cx][cy] == 0) {
							break;
						}
						cx += dx[k];
						cy += dy[k];
						num++;
					}
				}
				
			}
			
			w = 0;
			b = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (mp[i][j] == 1) {
						b++;
					}
					else if (mp[i][j] == 2) {
						w++;
					}
				}
			}
			
			System.out.printf("#%d %d %d\n", t+1, b, w);
		}
	}

}
