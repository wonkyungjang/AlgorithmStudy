package _01_0825;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 단어 뒤집기 2
public class Main_BOJ_17413 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		for (int i = 0, len = str.length(); i < len; i++) {
			if (str.charAt(i) == '<') {			// <를 만나는 경우 >까지 그대로 복사
				while (str.charAt(i) != '>') {
					sb.append(str.charAt(i++));
				}
				sb.append('>');
			} else if (str.charAt(i) == ' ') {	// 공백을 만나는 경우 공백을 복사
				sb.append(' ');
			} else {							// 나머지 경우는 뒤집어서 복사 
				StringBuilder tmp = new StringBuilder();
				while (i < len && str.charAt(i) != '<' && str.charAt(i) != ' ')
					tmp.append(str.charAt(i++));
				sb.append(tmp.reverse());
				i--;
			}
		}
		System.out.println(sb);
//		bw.append(sb);
//		bw.flush();
//		bw.close();
		br.close();
	}

}
