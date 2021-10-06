import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main_2239 {

	static int [][] map;
	static boolean [][] row;
	static boolean [][] col;
	static boolean [][] square;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[9][9];
		row = new boolean[9][10];
		col = new boolean[9][10];
		square = new boolean[9][10];
		
		for (int i = 0; i < 9; i++) {
			String str = br.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = str.charAt(j)-'0';
				if(map[i][j] != 0) {
					row[i][map[i][j]] = true;
					col[j][map[i][j]] = true;
					square[(i/3)*3+(j/3)][map[i][j]] = true;
				}
			}
		}
		
		dfs(0);
	
	}

	private static void dfs(int cnt) {
		int x = cnt / 9; // x좌표
		int y = cnt % 9; // y좌표
		
		if(cnt == 81) {
			
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			
			System.exit(0);
			return;
		}
		
		if(map[x][y] == 0) {
			
			for (int i = 1; i < 10; i++) {
				if(!row[x][i]&& !col[y][i] && !square[(x/3)*3+(y/3)][i]) {
					row[x][i] = true;
					col[y][i] = true;
					square[(x/3)*3+(y/3)][i] = true;
					map[x][y] = i;
					dfs(cnt + 1);
					row[x][i] = false;
					col[y][i] = false;
					square[(x/3)*3+(y/3)][i] = false;
					map[x][y] = 0;
				}
			}
		}else {
			dfs(cnt+1);
		}
	}


}
