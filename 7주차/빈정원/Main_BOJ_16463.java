package _07_1006;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

// 13일의 금요일
public class Main_BOJ_16463 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		int ans = 0;
		for (int i = 2019; i <= year; i++) {
			for (int j = 1; j <= 12; j++) {
				if (LocalDate.of(i, j, 13).getDayOfWeek() == DayOfWeek.FRIDAY)
					ans++;
			}
		}
		System.out.println(ans);
	}

}
