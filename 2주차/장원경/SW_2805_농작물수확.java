import java.util.Scanner;

public class SW_2805_농작물수확 {

	static int[][] map;
	static int T,N;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		T=sc.nextInt();
		for(int t=1;t<=T;t++) {
			N=sc.nextInt();
			map=new int[N][N];
			for(int i=0;i<N;i++) {
				char c[]=sc.next().toCharArray();
				for(int j=0;j<N;j++) {
					map[i][j]=c[j]-'0';
				}
			}
			int sum=0;
			int target=N/2;
			for(int i=0;i<=N/2;i++) {
				for(int j=N/2-i;j<N/2-i+2*i+1;j++) {
					sum+=map[i][j];
				}
				//target--;
			}
			target=1;
			for(int i=N/2+1;i<N;i++) {
				for(int j=i-N/2;j<i-N/2+2*(N-i-1)+1;j++) {
					sum+=map[i][j];
				}
				//target++;
			}
			System.out.println("#"+t+" "+sum);
		}

	}

}
