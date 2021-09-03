import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_2606_바이러스 {

	static int C,N;
	static int map[][];
	static Queue<Integer> q;
	static boolean v[];
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		C=sc.nextInt();
		N=sc.nextInt();
		v=new boolean[C+1];
		q=new LinkedList<Integer>();
		map=new int[C+1][C+1]; //인덱스 1부터 시작
		for(int i=0;i<N;i++) {
			int start=sc.nextInt();
			int end=sc.nextInt();
			map[start][end]=1;
			map[end][start]=1;
		}
		int cnt=0;
		q.add(1);
		v[1]=true;
		while(!q.isEmpty()) {
			int pol=q.poll();
			for(int i=1;i<C+1;i++) {
				if(map[pol][i]==1 && !v[i]) {
					q.add(i);
					v[i]=true;
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
