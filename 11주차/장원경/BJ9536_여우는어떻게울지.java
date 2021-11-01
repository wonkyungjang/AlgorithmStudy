import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ9536_여우는어떻게울지 {

	static List<String> animal;
	static int T;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			animal = new ArrayList<String>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens())
				animal.add(st.nextToken());

			while (true) {
				String str = br.readLine();
				if (str.equals("what does the fox say?"))
					break;
				String s[] = str.split(" ");
				String cry = s[2];

				for (int i = animal.size() - 1; i >= 0; i--) {
					if (animal.get(i).equals(cry))
						animal.remove(i);
				}
			}

			for (String ss : animal)
				System.out.print(ss + " ");
		}

	}

}
