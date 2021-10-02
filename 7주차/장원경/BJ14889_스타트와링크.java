import java.util.Scanner;

public class BJ14889_스타트와링크 {

	static int N;
	static int map[][];
	static boolean v[];
	static int min=Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		map=new int[N][N];
		v=new boolean[N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		min=Integer.MAX_VALUE;
		combi(0,0);
		System.out.println(min);
	}
	private static void combi(int cnt, int start) {
		if(cnt==N/2) {
			
			int sum1=0;
			int sum2=0;
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(v[i] && v[j]) {
						sum1+=map[i][j];
					}else if(!v[i] && !v[j]) {
						sum2+=map[i][j];
					}
				}
			}
			
			if(Math.abs(sum1-sum2)<min) min=Math.abs(sum1-sum2);
			return;
		}
		
		for(int i=start;i<N;i++) {
			v[i]=true;
			combi(cnt+1,i+1);
			v[i]=false;
		}
	}
}
