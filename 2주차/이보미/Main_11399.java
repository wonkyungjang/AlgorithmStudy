import java.util.Scanner;

public class Main_11399 {

	static int N;
	static int [] time;
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		N = scann.nextInt();
		time = new int[N];
		
		for (int i = 0; i < N; i++) {
			time[i] = scann.nextInt();
		}
		
		// 버블정렬
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-i-1; j++) {
				if(time[j] > time[j+1]) {
					int temp = time[j];
					time[j] = time[j+1];
					time[j+1] = temp;
				}
			}
		}
		
		int min = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				min += time[j];
			}
		}
		
		System.out.println(min);
	}

}
