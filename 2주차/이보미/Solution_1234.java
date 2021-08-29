import java.util.Scanner;
import java.util.Stack;

public class Solution_1234 {
	
	static int T = 10;
	static int N;
	static Stack<Character> stack;
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		for (int t = 1; t <= T; t++) {
			N = scann.nextInt();
			String pwd = scann.next();
			stack = new Stack<>();
			
			for (int i = 0; i < N; i++) {
				char num = pwd.charAt(i);
				if(stack.isEmpty()) {
					stack.push(num);
				}else if(stack.peek() == num) {
					stack.pop();
				}else {
					stack.push(num);
				}
			}
			
			StringBuilder sb = new StringBuilder();
			while(!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			
			System.out.println("#"+t+" "+sb.reverse());
		}

	}

}
