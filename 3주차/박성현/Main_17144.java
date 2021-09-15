import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17144 {
	
	static int r, c, t;
	static int[][] mp;
	static int g;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	static boolean check(int cr, int cc) {
		if (r > cr && c > cc && cc >= 0 && cr >= 0) return true;
		else return false;
	}
	
	static void mh() {
		int[][] tmp = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (mp[i][j] > 0) {
					int m = mp[i][j]/5;
					tmp[i][j] += mp[i][j];
					for (int k = 0; k < 4; k++) {
						int cx = i + dx[k];
						int cy = j + dy[k];
						if (check(cx, cy) && mp[cx][cy] != -1) {
							tmp[cx][cy] += m;
							tmp[i][j] -= m;
						}
					}
				}
			}
		}
		for (int i = 0; i < r; i++) {
			System.arraycopy(tmp[i], 0, mp[i], 0, c);
		}
		mp[g-1][0] = -1;
		mp[g][0] = -1;
	}
	
	static void wind() {
		for (int i = g-3; i >= 0; i--) {
			mp[i+1][0] = mp[i][0];
		}
		for (int i = 1; i < c; i++) {
			mp[0][i-1] = mp[0][i];
		}
		for (int i = 1; i < g; i++) {
			mp[i-1][c-1] = mp[i][c-1];
		}
		for (int i = c-2; i > 0; i--) {
			mp[g-1][i+1] = mp[g-1][i];
		}
		mp[g-1][1] = 0;
		for (int i = g+2; i < r; i++) {
			mp[i-1][0] = mp[i][0];
		}
		for (int i = 1; i < c; i++) {
			mp[r-1][i-1] = mp[r-1][i];
		}
		for (int i = r-2; i >= g; i--) {
			mp[i+1][c-1] = mp[i][c-1];
		}
		for (int i = c-2; i > 0; i--) {
			mp[g][i+1] = mp[g][i];
		}
		mp[g][1] = 0;
 	}
	
	static long summ() {
		long sc = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0 ; j < c; j++) {
				sc += mp[i][j];
			}
		}
		return sc;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		r = Integer.parseInt(stn.nextToken());
		c = Integer.parseInt(stn.nextToken());
		t = Integer.parseInt(stn.nextToken());
		mp = new int[r][c];
		for (int i = 0; i < r; i++) {
			stn = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				mp[i][j] = Integer.parseInt(stn.nextToken());
				if (mp[i][j] == -1) g = i;
			}
		}
		for (int i = 0; i < t; i++) {
			mh();
			wind();
		}
		
		System.out.println(summ()+2);
	}

}
