import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_1234 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 0; t < 10; t++) {
			String[] s = br.readLine().split(" ");
			String pw = s[1];
			Deque<Character> deque = new ArrayDeque<>();
			for (int i = 0; i < pw.length(); i++) {
				if (deque.size() > 0) {
					if (deque.peekLast() == pw.charAt(i)) {
						deque.pollLast();
					}
					else {
						deque.offer(pw.charAt(i));
					}
				}
				else {
					deque.offer(pw.charAt(i));
				}
			}
			System.out.print("#" + (t+1) + " ");
			int n = deque.size();
			for (int i = 0; i < n; i++) {
				System.out.print(deque.pollFirst());
			}
			System.out.println();
		}
	}

}
