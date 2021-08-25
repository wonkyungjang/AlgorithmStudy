import java.util.Scanner;
import java.util.Stack;
//고려해야 할 예시 조건이 많아서 정리가 안됐음....
//stringbuilder reverse : 뒤집기
public class BJ_17413_단어뒤집기2 {

	static Stack<Character> stack;
	static boolean istag;
	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		String s=sc.nextLine();
		stack=new Stack<Character>();
		
		for(int i=0;i<s.length();i++) {
			//오픈태그를 만나면 그 전에 스택에 있던거 모두 출력
			if(s.charAt(i)=='<') {
				
				while(!stack.isEmpty()) {
					System.out.print(stack.pop());
				}
				//태그 안임
				istag=true;
			}
			//클로즈태그를 만나면
			else if(s.charAt(i)=='>') {
				//태그 밖임
				istag=false;
				System.out.print(s.charAt(i));
			}
			//공백이고 태그 안일 때
			else if(s.charAt(i)==' ' && istag==true)
				System.out.print(' ');
			//공백이고 태그 밖일 때, 스택 모두 pop 후 공백 출력
			else if(s.charAt(i)==' ' && istag==false) {
				while(!stack.isEmpty()) {
					System.out.print(stack.pop());
				}
				System.out.print(' ');
			}
			//태그 밖이고 공백이 아니고 클로즈 태그도 아니면 스택에 추가
			if(istag==false && s.charAt(i)!=' ' && s.charAt(i)!='>')
				stack.add(s.charAt(i));
			//태그 안이고 공백이 아니고 클로즈 태그도 아니면 출력
			else if(istag==true && s.charAt(i)!=' ' && s.charAt(i)!='>')
				System.out.print(s.charAt(i));
			
			
			if(i==s.length()-1) {
				while(!stack.isEmpty()) {
					System.out.print(stack.pop());
				}
			}
		}
	}
}
