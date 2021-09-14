import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2263_트리의순회 {

	static int n;
	static int in[];
	static int post[];
	static int in_position[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		in=new int[n];
		post=new int[n];
		in_position=new int[n+1];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			in[i]=Integer.parseInt(st.nextToken());
		}
		StringTokenizer ss=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			post[i]=Integer.parseInt(ss.nextToken());
		}
		//인오더배열의 값 <-> 인덱스해서 x의 인덱스 빠르게 구하기 위함
		for(int i=0;i<n;i++) {
			in_position[in[i]]=i;
		}
		preorder(0,n-1,0,n-1);
	}
	private static void preorder(int is, int ie, int ps, int pe) {
		
		if(ie<is || pe<ps) return;
		int root=post[pe];
		System.out.print(root+" ");
		int idx=in_position[root];
		int left=idx-is;
		//왼쪽노드 탐색
		preorder(is,idx-1,ps,ps+left-1);
		
		//오른쪽노드 탐색
		preorder(idx+1,ie,ps+left,pe-1);
	}

}
