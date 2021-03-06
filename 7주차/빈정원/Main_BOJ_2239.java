package _07_1006;

import java.util.Scanner;

// 스도쿠
public class Main_BOJ_2239 {

	static int[] map = new int[81];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 9; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < 9; j++) {
				int idx = i * 9 + j;
				map[idx] = str.charAt(j) - '0';
			}
		}
		
		for (int i = 0; i < 81; i++) {
			if (map[i] == 0) {
				sudoku(i);
				break;
			}
		}
	}

	private static void sudoku(int idx) {
		if (idx == 81) {
			for (int i = 0; i < 81; i++) {
				System.out.print(map[i]);
				if (i % 9 == 8) System.out.println();
			}
			System.exit(0);
		}

		if (map[idx] != 0)
			sudoku(idx + 1);
		else {
			for (int i = 1; i <= 9; i++) {	
				if (check(idx, i)) {
					map[idx] = i;
					sudoku(idx + 1);
					map[idx] = 0;
				}
			}			
		}
	}
	
	private static boolean check(int idx, int num) {
		int r = idx / 9;
		int c = idx % 9;
		
		// 행, 열 검사
		for (int i = 0; i < 9; i++) {
			if (map[r * 9 + i] == num || map[i * 9 + c] == num)
				return false;
		}
		
		// 같은 칸 검사
		int startR = 0;
		int startC = 0;
		
		if (r < 3) startR = 0;
		else if (r < 6) startR = 3;
		else startR = 6;
		
		if (c < 3) startC = 0;
		else if (c < 6) startC = 3;
		else startC = 6;
		
		for (int i = startR; i < startR + 3; i++) {
			for (int j = startC; j < startC + 3; j++) {
				if (map[i * 9 + j] == num)
					return false;
			}
		}
		
		return true;
	}
	
}
