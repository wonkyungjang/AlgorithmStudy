import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BJ2529_부등호 {
	
	static int k;
	static boolean v[];
	static char bu[];
	static ArrayList<String> list;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		k=sc.nextInt();
		bu=new char[k];
		v=new boolean[10];
		list=new ArrayList<>();
		for(int i=0;i<k;i++) {
			bu[i]=sc.next().charAt(0);
		}
	
		dfs("",0);
		Collections.sort(list);
		
		System.out.println(list.get(list.size()-1));
		System.out.println(list.get(0));
	}
	private static void dfs(String num,int cnt) {
		
		if(cnt==k+1) {
			
			list.add(num);
			
			return;
		}
		
			for(int j=0;j<10;j++) {
				
				if(v[j]) continue;

				if(cnt==0 || ck(Character.getNumericValue(num.charAt(cnt-1)), bu[cnt-1], j)) {
					v[j]=true;
					dfs(num+j,cnt+1);
					v[j]=false;
				}
			}
		}
	
	private static boolean ck(int a, char b, int c) {

		if(b=='<') {
			if(a<c) return true;
		}else {
			if(a>c) return true;
		}
		return false;
	}
}
