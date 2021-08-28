package _02_0901;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 크로아티아 알파벳
public class Main_BOJ_2941 {

	// 교체할 크로아티아 알파벳 미리 저장
	static String[] strArr = new String[] {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		// 크로아티아 알파벳들을 찾아서 겹치지 않는 한글자(a)로 바꿔줌
		for (int i = 0; i < strArr.length; i++)
			str = str.replaceAll(strArr[i], "a");
		// 바꾼 문자열의 길이 = 크로아티아 알파벳의 개수
		System.out.println(str.length());
	}

}
