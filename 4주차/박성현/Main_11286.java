import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_11286 {

	static int n;
	static PriorityQueue<Integer> mi = new PriorityQueue<>(Collections.reverseOrder());
	static PriorityQueue<Integer> pi = new PriorityQueue<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			int cal = Integer.parseInt(br.readLine());
			if (cal > 0) {
				pi.offer(cal);
			}
			else if (cal < 0) {
				mi.offer(cal);
			}
			else {
				if (pi.size() > 0 && mi.size() > 0) {
					int p = pi.peek();
					int m = (-1) * mi.peek();
					if (p < m) {
						System.out.println(pi.poll());
					}
					else System.out.println(mi.poll());
					
				}
				else if (pi.size() > 0) System.out.println(pi.poll());
				else if (mi.size() > 0) System.out.println(mi.poll());
				else System.out.println(0);
			}
		}

	}

}
