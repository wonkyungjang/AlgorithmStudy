import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;
//해시가 생각이 안남....문자열 중복 얘기하면 떠올려야하나
//해시셋!!! 중복x, 순서 x
//리스트 소트는 Collections
public class BJ_1764_듣보잡 {
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		HashSet<String> hs=new HashSet<String>();
		List<String> list=new ArrayList<String>();
		
		for(int i=0;i<N;i++) {
			hs.add(br.readLine());
		}
		for(int i=0;i<M;i++) {
			String str=br.readLine();
			if(hs.contains(str)){
				list.add(str);
			}
		}
		//리스트 소트
		Collections.sort(list);
		System.out.println(list.size());
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
	}

}
