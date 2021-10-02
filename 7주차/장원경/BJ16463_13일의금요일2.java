import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class BJ16463_13일의금요일2 {

	static int N;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		int cnt=0;
		for(int i=2019;i<=N;i++) {
			for(int j=1;j<=12;j++) {
				if(LocalDate.of(i, j, 13).getDayOfWeek()==DayOfWeek.FRIDAY) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

}
