import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_2477_참외밭 {

	static int K;
	static int map[][];
	static int len[];
	static int max=Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		K=Integer.parseInt(br.readLine());
		map=new int[6][2];
		for(int i=0;i<6;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
				int d=Integer.parseInt(st.nextToken());
				int size=Integer.parseInt(st.nextToken());
				map[i][0]=d;
				map[i][1]=size;
		}
		max=Integer.MIN_VALUE;
		int x=1;
		int sum=0;
		for(int i=0;i<=5;i++) {
			 x=map[i][1]*map[(i+1)%6][1];
			sum+=x;
			if(map[i][1]*map[(i+1)%6][1]>max) max=map[i][1]*map[(i+1)%6][1];
			
		}
		System.out.println((sum-2*max)*K);
		}
	}


