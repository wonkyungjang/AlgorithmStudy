package _02_0901;

import java.util.Arrays;
import java.util.Scanner;

// 크로스워드 만들기
public class Main_BOJ_2804 {

	static String A, B;
	static int idxA, idxB;
	static char[][] board;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		board = new char[B.length()][A.length()];
		for (idxA = 0; idxA < A.length(); idxA++) {
			// B에서 A의 i번째 글자가 위치하는 idx을 찾으면 break
			if ((idxB = B.indexOf(A.charAt(idxA))) != -1) break;
		}
		
		for (int i = 0; i < B.length(); i++) {
			// B가 A와 처음 만나는 행은 A로 채워주고, 이외의 경우는 .으로 채워줌
			if (i == idxB)
				board[i] = A.toCharArray();
			else
				Arrays.fill(board[i], '.');
		}
		for (int i = 0; i < B.length(); i++) {
			for (int j = 0; j < A.length(); j++) {
				// A가 B와 처음 만나는 열은 B로 출력하고, 이외의 경우는 board에 있는 그대로 출력
				if (j == idxA)
					System.out.print(B.charAt(i));
				else
					System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

}
