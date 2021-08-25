import java.util.Scanner;

public class Main_1592 {

	static int N;
	static int M;
	static int L;
	static int [] arr;
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		M = scann.nextInt();
		L = scann.nextInt();
		arr = new int[N];
	
		int i = 0;
		int count = 0;
		
		while(true) {
			arr[i]++;
			if(arr[i] == M) {
				break;
			}
			count++;
			if(arr[i] % 2 == 1) {
				i = (i+L)%N;
			}else {
				if(i-L < 0) {
					i = i-L+N;
				}else {
					i -= L;
				}
			}
		}
		
		System.out.println(count);
	}

}
