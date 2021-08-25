import java.util.Scanner;
import java.util.Stack;

public class Main_17413 {

	static Stack<Character> stack;
	 
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		stack = new Stack<>();
		String str = scann.nextLine();
		boolean check = false;
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c == '<') {
				reverse();
				check = true;
				System.out.print(c);
			}else if(c == '>') {
				check = false;
				System.out.print(c);
			}else if(check) {
				System.out.print(c);
			}else {
				if(c == ' ') {
					reverse();
					System.out.print(c);
				}else {
					stack.push(c);
				}
			}
		}
		reverse();

	}

	private static void reverse() {
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}

}
