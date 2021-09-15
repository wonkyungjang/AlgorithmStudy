import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
5
3 1 4 3 2
*/
/*
3 3+1 3+1+4 3+1+4+3 3+1+4+3+2
왼쪽 -> 오른쪽 인덱스 순으로 가장 많이 더해짐. 즉 왼쪽 인덱스가 가장 작아야 -> 오름차순 정렬
 * */
public class BJ_11399_ATM {
	static int N;
	static int arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr=new int[N];
		StringTokenizer st= new StringTokenizer(br.readLine()," ");	
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		//오름차순 배열
		Arrays.sort(arr);
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i]*N;
			N--;
		}
		System.out.println(sum);
	}
}
