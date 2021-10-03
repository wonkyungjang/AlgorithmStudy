import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 스타트와 링크
public class Main_14889 {

	static int N;
	static int [][] map;
	static boolean [] isSelected;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		isSelected = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		combination(0, 1);
		
		System.out.println(min);
	}

	private static void combination(int cnt, int s) {
		if(cnt == N/2) {
			int sSum = 0;
			int lSum = 0;
			
			for (int i = 1; i <= N; i++) {
				for (int j = i+1; j <= N; j++) {
					if(isSelected[i] && isSelected[j]) sSum += (map[i][j] + map[j][i]);
					if(!isSelected[i] && !isSelected[j]) lSum += (map[i][j] + map[j][i]);
				}
			}

			min = Math.min(min, Math.abs(sSum-lSum));
			return;
		}
		
		for (int i = s; i <= N; i++) {
			isSelected[i] = true;
			combination(cnt+1, i+1);
			isSelected[i] = false;
		}
	}

}
