import java.util.Scanner;
 
public class Solution_2805 {
 
    public static int T;
    public static int N;
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
         
        for (int i = 0; i < T; i++) {
            N = sc.nextInt();
            int b = N/2;
            int value = 0;
            for (int j = 0; j < N; j++) {
                String row = sc.next();
                for (int k = Math.abs(b); k < N-Math.abs(b); k++) {
                    value += (row.charAt(k) - '0');
                }
                b--;
            }
            System.out.printf("#%d %d\n", i+1, value);      
        }
    }
}
