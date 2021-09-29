import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1759 {

	static int L, C;
	static ArrayList<Integer> alpha;
	static boolean[] isM;
	
	static void combi(int start, int cnt, boolean[] v, int[] pw) {
		if(cnt == L){
			int mn = 0;
			for (int i = 0; i < L; i++) {
				if (isM[pw[i]]) mn++;
			}
			if (mn > 0 && mn < L-1) {
				for (int i = 0; i < L; i++) {
					System.out.printf("%c", 'a'+pw[i]);
				}
				System.out.println();
			}
			return;
		}
		
		for (int i = start; i < C; i++) {
			v[i]=true;
			pw[cnt]=alpha.get(i);
			combi(i+1, cnt+1, v, pw);
			v[i]=false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		L = Integer.parseInt(stn.nextToken());
		C = Integer.parseInt(stn.nextToken());
		isM = new boolean[26];
		isM['a'-'a'] = true;
		isM['e'-'a'] = true;
		isM['i'-'a'] = true;
		isM['o'-'a'] = true;
		isM['u'-'a'] = true;
		alpha = new ArrayList<>();
		ArrayList<Integer> pw = new ArrayList<>();
		
		stn = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			alpha.add(stn.nextToken().charAt(0)-'a');
		}
		Collections.sort(alpha);
		
		combi(0, 0, new boolean[C], new int[L]);
		
	}

}
