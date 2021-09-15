import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2263 {

	static int N;
	static int [] in, post, pre;
	static int index;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		in = new int[N];
		post = new int[N];
		pre = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			in[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			post[i] = Integer.parseInt(st.nextToken());
		}
		
		makePreOrder(0, N-1, 0, N-1);
		
		for (int n : pre) {
			System.out.print(n+" ");
		}
	}

	private static void makePreOrder(int is, int ie, int ps, int pe) {
		if(is <= ie && ps <= pe) {
			
			pre[index++] = post[pe];
			
			int root = 0;
			for (int i = is; i <= ie; i++) {
				if(in[i] == post[pe]) {
					root = i;
					break;
				}
			}
			// 루트를 기준으로 왼쪽 중위, 후위의 시작과 끝 인덱스
			makePreOrder(is, root-1, ps, ps+root-is-1); 
			// 루트를 기준으로 오른쪽 중위, 후위의 시작과 끝 인덱스
			makePreOrder(root+1, ie, ps+root-is, pe-1);
		}
	}

}
