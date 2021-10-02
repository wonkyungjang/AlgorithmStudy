import java.util.Scanner;

public class BJ16463_13일의금요일 {

	static int N;
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		int day[]= {31,28,31,30,31,30,31,31,30,31,30,31};
		int cnt=0;
		int date=13;
		//2019년 1월 1일은 화요일
		for(int i=2019;i<=N;i++) {
			if((i%400==0) || (i%100!=0 && i%4==0)) day[1]=29; 
			else day[1]=28;
			
			for(int j=0;j<12;j++) {
				//13일의 금요일인지 확인
				if(date%7==4) cnt++;
				date+=day[j];
			}	
		}
		System.out.println(cnt);

	}
}