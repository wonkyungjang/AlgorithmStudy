import java.util.Scanner;

public class Main_8320 {

	static int N;
	static int cnt;
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		N = scann.nextInt();
		cnt = 0;
		
		for (int i = 1; i <= N; i++) { // 가로
			for(int j = i; i*j <= N; j++) { // 가로*세로
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
