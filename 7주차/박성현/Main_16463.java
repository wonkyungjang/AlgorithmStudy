import java.util.Scanner;

public class Main_16463 {

	static int n;
	static int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	static boolean isYun(int y) {
		if (y%4 == 0) {
			if (y%400 == 0) return true;
			else if (y%100 == 0) return false;
			return true;
		}
		return false;
	}
	
	static int fNum(int y) {
		int num = 0;
		int d = 4;
		for (int i = 2019; i <= y; i++) {
			if (!isYun(i)) month[1] = 28;
			else month[1] = 29;
			for (int m = 0; m < 12; m++) {
				while (d <= month[m]) {
					if (d == 13) num++;
					d += 7;
				}
				d %= month[m];
			}
		}
		return num;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		System.out.println(fNum(n));
	}

}
