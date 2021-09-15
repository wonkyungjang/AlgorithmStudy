package _02_0901;

import java.util.Scanner;

// 안경이 없어!
public class Solution_D3_7272 {

	static int T;
	static String str1, str2;
	static int[] arr = {1, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0}; // 구멍 개수
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			str1 = sc.next();
			str2 = sc.next();
			int len1 = str1.length();
			int len2 = str2.length();
			// 두 문자열의 길이가 다른 경우 DIFF
			if (len1 != len2) {
				System.out.println("#" + t + " DIFF");
				continue;
			}
			// 두 문자열의 길이가 같은 경우 한글자씩 비교
			boolean isDiff = false;
			for (int i = 0; i < len1; i++) {
				if (arr[str1.charAt(i) - 'A'] != arr[str2.charAt(i) - 'A']) {
					isDiff = true;
					break;
				}
			}
			System.out.println("#" + t + (isDiff ? " DIFF" : " SAME"));
		}
	}

}
