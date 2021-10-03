import java.util.Scanner;

// 13일의 금요일
public class Main_16463 {

	static int N;
	static int [] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	static int cnt;
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		N = scann.nextInt();
		
		int startY = 2019;
		int day = 12; // 1일부터 경과된 날짜
		
		for (int y = startY; y <= N; y++) {
			for (int m = 1; m <= 12; m++) {
				if(day % 7 == 3) cnt++; // 금요일
				day += months[m];
				if(m == 2 && (y % 400 == 0 || (y % 4 == 0 && y % 100 != 0))) day++; // 윤년
			}
		}
		
		System.out.println(cnt);
	}

}
