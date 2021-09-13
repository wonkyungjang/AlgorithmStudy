package _04_0915;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 음유시인 영재
public class Main_BOJ_19948 {

	static String poem;
	static int spaceCnt;
	static int[] alphaCnt = new int[26];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		poem = br.readLine().replaceAll("[ ]{1,}", " ");	// 공백이 연속으로 2번 이상 나올 경우 " "로 치환
		spaceCnt = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 26; i++)
			alphaCnt[i] = Integer.parseInt(st.nextToken());
		
		sb.append(poem.charAt(0));	// 시의 첫글자는 제목의 첫글자이므로 더해줌
		typing(poem.charAt(0), 0);
		for (int i = 1; i < poem.length(); i++) {
			if (poem.charAt(i - 1) != poem.charAt(i))	// 이전 글자와 같은 경우 typing하지 않아도 됨
				typing(poem.charAt(i), i);
		}
		
		String title = sb.toString().toUpperCase();
		if (--alphaCnt[title.charAt(0) - 'A'] < 0 || spaceCnt < 0) {
			System.out.println(-1);
			return;
		}
		for (int i = 1; i < title.length(); i++) {
			if (title.charAt(i - 1) != title.charAt(i))
				typing(title.charAt(i), i);
		}
		System.out.println(title);
	}

	// 소문자, 대문자, 공백으로 케이스를 나눠서 타이핑이 가능하면 true, 불가능하면 false를 return
	public static void typing(char c, int idx) {
		boolean isPossible = true;
		if ('a' <= c && c <= 'z') {
			if (--alphaCnt[c - 'a'] < 0)
				isPossible = false;
		} else if ('A' <= c && c <= 'Z') {
			if (--alphaCnt[c - 'A'] < 0 )
				isPossible = false;
		} else {
			if (--spaceCnt < 0)
				isPossible = false;
			sb.append(poem.charAt(idx + 1));	// 시작과 끝은 공백이 아니므로 공백 다음 글자는 무조건 제목에 들어감
		}
		if (!isPossible) {
			System.out.println(-1);
			System.exit(0);	// 프로그램 종료
		}
	}

}
