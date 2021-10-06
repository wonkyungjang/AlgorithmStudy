import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_2239 {

	static int[][] sdk = new int[9][9];
	static ArrayList<Point> zeros;
	static boolean complete;
	
	static boolean check(int x, int y, int num) {
		int cx = x/3*3;
		int cy = y/3*3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (sdk[cx+i][cy+j] == num) return false;
			}
		}
		for (int i = 0; i < 9; i++) {
			if (sdk[x][i] == num) return false;
		}
		for (int i = 0; i < 9; i++) {
			if (sdk[i][y] == num) return false;
		}
		return true;
	}
	
	static void solve(int cnt) {
		if (cnt == zeros.size()) {
			complete = true;
			return;
		}
		int cx = zeros.get(cnt).x;
		int cy = zeros.get(cnt).y;
		for (int i = 1; i < 10; i++) {
			if (check(cx, cy, i)) {
				sdk[cx][cy] = i;
				solve(cnt+1);
			}
			if (complete) return;
			else sdk[cx][cy] = 0;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		zeros = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			String s = br.readLine();
			for (int j = 0; j < 9; j++) {
				sdk[i][j] = s.charAt(j)-'0';
				if (sdk[i][j] == 0) zeros.add(new Point(i, j));
			}
		}
		complete = false;
		solve(0);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(sdk[i][j]);
			}
			System.out.println();
		}
	}

}
