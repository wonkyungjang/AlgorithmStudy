import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class SW_1234_비밀번호 {

	static Stack<Character> stack,answer;
	static int N;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		for(int t=1;t<=10;t++) {
			stack=new Stack<Character>();
			answer=new Stack<Character>();
			N=sc.nextInt();
			String s=sc.next();
			char[] c=s.toCharArray();
			
			//하나 먼저 추가
			stack.push(c[0]);
			
			for(int i=1;i<c.length;i++) {
				if(!stack.isEmpty()) {
					if(c[i]==stack.peek()) {
						stack.pop();
						continue;
					}
				}
					stack.push(c[i]);	
			}
			
			while(!stack.isEmpty()) {
				answer.push(stack.pop());
			}
			System.out.print("#"+t+" ");
			while(!answer.empty()) {
				System.out.print(answer.pop());
			}
			System.out.println();
			/*ArrayList<Character> list=new ArrayList<>();
			while(!stack.isEmpty()) {
				list.add(stack.pop());
			}
			Collections.reverse(list);
			System.out.print("#"+t+" ");
			for(int i=0;i<list.size();i++) 
				System.out.print(list.get(i));
			System.out.println();*/
		}
		}
	}
