import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_3190 {

	static int n, k, l;
	static int[][] map;
	static Snack snack;
	static int time;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static Map<Integer, Integer> dirChData;
	
	static class Snack {
		Point head;
		Point tail;
		int dir;
		int slen;
		
		public Snack() {
			head = new Point(0, 0);
			tail = new Point(0, 0);
			dir = 0;
			slen = 1;
		}
	}
	
	static boolean check(int x, int y) {
		if (x < n && x >= 0 && y < n && y >= 0) return true;
		else return false;
	}
	
	static void go() {
		while (true) {
			time++;
			int cx = snack.head.x + dx[snack.dir];
			int cy = snack.head.y + dy[snack.dir];
			if (!check(cx, cy)) return;
			else if (map[cx][cy] == -1) {
				snack.slen = (snack.slen+1)%100000;
				map[cx][cy] = snack.slen;
				snack.head.x = cx;
				snack.head.y = cy;
			}
			else if (map[cx][cy] == 0){
				snack.slen = (snack.slen+1)%100000;
				map[cx][cy] = snack.slen;
				snack.head.x = cx;
				snack.head.y = cy;
				for (int i = 0; i < 4; i++) {
					int tx = snack.tail.x + dx[i];
					int ty = snack.tail.y + dy[i];
					if (check(tx, ty) && map[tx][ty] == (map[snack.tail.x][snack.tail.y] + 1)%100000) {
						map[snack.tail.x][snack.tail.y] = 0;
						snack.tail.x = tx;
						snack.tail.y = ty;
						break;
					}
				}
			}
			else return;
			
			if (dirChData.containsKey(time)) {
				snack.dir = snack.dir+dirChData.get(time);
				if (snack.dir < 0) snack.dir = 3;
				else if (snack.dir > 3) snack.dir %= 4;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		map = new int[n][n];
		snack = new Snack();
		map[0][0] = 1;
		for (int i = 0; i < k; i++) {
			StringTokenizer stn = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(stn.nextToken());
			int y = Integer.parseInt(stn.nextToken());
			map[x-1][y-1] = -1;
		}
		l = Integer.parseInt(br.readLine());
		dirChData = new HashMap<Integer, Integer>();
		for (int i = 0; i < l; i++) {
			StringTokenizer stn = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(stn.nextToken());
			char c = stn.nextToken().charAt(0);
			if (c == 'L') dirChData.put(x, -1);
			else dirChData.put(x, 1);
			
		}
		
		time = 0;
		go();		
		System.out.println(time);

	}

}
