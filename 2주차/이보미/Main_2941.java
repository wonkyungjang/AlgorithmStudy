import java.util.Scanner;

public class Main_2941 {

	static String [] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		String str = scann.next();
		
		for (int i = 0; i < croatia.length; i++) {
			if(str.contains(croatia[i])) {
				str = str.replace(croatia[i], "*");
			}
		}
		
		System.out.println(str.length());
	}

}
