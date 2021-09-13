import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_11286_절댓값힙 {

	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		//기본 : 작 -> 큰 오름차순 배열(앞에거-뒤에거)
			PriorityQueue<Integer> pq=new PriorityQueue<>((o1,o2) -> {
				int abs1=Math.abs(o1);
				int abs2=Math.abs(o2);
				//절대값이 같으면 숫자가 더 작은거 리턴
				if(abs1==abs2) return o1-o2;
				//절대값이 다르면 더 작은거 리턴
				return abs1-abs2;
			});
		 
		for(int i=0;i<N;i++) {
			int num=Integer.parseInt(br.readLine());
			if(num!=0) pq.add(num);
			else {
				if(pq.isEmpty()) System.out.println(0);
				else System.out.println(pq.poll());
				}
		}
	}
}
