import java.util.Scanner;

public class Main_2567 {

	static int N;
	static int [][] map;
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		N = scann.nextInt();
		map = new int[101][101];
		
		for (int i = 0; i < N; i++) {
			int x = scann.nextInt();
			int y = scann.nextInt();
			painting(x, y);
		}
		
		int round = 0;
		for (int i = 0; i < 101; i++) {  // 색종이 붙이는 위치는 자연수이므로 0부터 카운트 상관 없음
			for (int j = 0; j < 101; j++) {
				if(map[i][j] == 1) {
					if(map[i-1][j] == 0) round++;
					if(map[i+1][j] == 0) round++;
					if(map[i][j-1] == 0) round++;			
					if(map[i][j+1] == 0) round++;
				}
			}
		}
		
		System.out.println(round);
	}

	private static void painting(int x, int y) {
		for (int i = x; i < x+10; i++) {
			for (int j = y; j < y+10; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
				}
			}
		}
	}

}
