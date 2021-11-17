import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15683 {

	static int n, m;
	static int[][] room;
	static int min;
	static ArrayList<CCTV> cctv = new ArrayList<>();
	static ArrayList<CCTV> cctvs = new ArrayList<>();
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	static class CCTV {
		Point p;
		int k;
		int d;
		public CCTV(Point p, int k) {
			super();
			this.p = p;
			this.k = k;
			this.d = -1;
		}
	}
	
	static boolean check(int x, int y) {
		if (x >= 0 && x < n && y >= 0 && y < m) return true;
		else return false;
	}
	
	static void findMax(int cnt) {
		if (cnt == cctv.size()) {
			for (int i = 0; i < cctvs.size(); i++) {
				fill(cctvs.get(i).k, cctvs.get(i).p, cctvs.get(i).d);
			}
			int count = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (room[i][j] == 0) count++;
					else if (room[i][j] == -1) room[i][j] = 0;
				}
			}
			if (min > count) min = count;
			return;
		}
		CCTV c = cctv.get(cnt);
		if (c.k == 2) {
			for (int i = 0; i < 2; i++) {
				c.d = i;
				cctvs.add(c);
				findMax(cnt+1);
				cctvs.remove(cctvs.size()-1);
			}
		}
		else if (c.k == 5) {
			c.d = 0;
			cctvs.add(c);
			findMax(cnt+1);
			cctvs.remove(cctvs.size()-1);
		}
		else {
			for (int i = 0; i < 4; i++) {
				c.d = i;
				cctvs.add(c);
				findMax(cnt+1);
				cctvs.remove(cctvs.size()-1);
			}
		}
	}
	
	static void fill(int k, Point cp, int d) {
		int cx = cp.x;
		int cy = cp.y;
		if (k < 5) {
			cx += dx[d];
			cy += dy[d];
			while (check(cx, cy) && room[cx][cy] != 6) {
				if (room[cx][cy] == 0) room[cx][cy] = -1;
				cx += dx[d];
				cy += dy[d];
			}
			if (k == 2 || k == 4) {
				cx = cp.x + dx[(d+2)%4];
				cy = cp.y + dy[(d+2)%4];
				while (check(cx, cy) && room[cx][cy] != 6) {
					if (room[cx][cy] == 0) room[cx][cy] = -1;
					cx += dx[(d+2)%4];
					cy += dy[(d+2)%4];
				}
			}
			if (k == 3 || k == 4) {
				cx = cp.x + dx[(d+3)%4];
				cy = cp.y + dy[(d+3)%4];
				while (check(cx, cy) && room[cx][cy] != 6) {
					if (room[cx][cy] == 0) room[cx][cy] = -1;
					cx += dx[(d+3)%4];
					cy += dy[(d+3)%4];
				}
			}
		}
		else {
			for (int i = 0; i < 4; i++) {
				cx = cp.x + dx[i];
				cy = cp.y + dy[i];
				while (check(cx, cy) && room[cx][cy] != 6) {
					if (room[cx][cy] == 0) room[cx][cy] = -1;
					cx += dx[i];
					cy += dy[i];
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stn.nextToken());
		m = Integer.parseInt(stn.nextToken());
		room = new int[n][m];
		min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			stn = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				room[i][j] = Integer.parseInt(stn.nextToken());
				if (room[i][j] > 0 && room[i][j] < 6) cctv.add(new CCTV(new Point(i, j), room[i][j]));
			}
		}
		findMax(0);
		System.out.println(min);
	}

}
