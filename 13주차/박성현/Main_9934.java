import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9934 {

	static int k;
	static int[] buildings;
	static Queue<arr> queue = new LinkedList<>();
	static Queue<Integer> ans = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	
	static class arr {
		int start;
		int len;
		
		public arr(int start, int len) {
			this.start = start;
			this.len = len;
		}
	}
	
	static void insertQueue() {
		queue.offer(new arr(0, buildings.length));
		while (!queue.isEmpty()) {
			arr carr = queue.poll();
			int root = (carr.start*2 + carr.len)/2;
			ans.offer(buildings[root]);
			if (carr.len > 1) {
				queue.offer(new arr(carr.start, carr.len/2));
				queue.offer(new arr(root+1, carr.len/2));
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		StringTokenizer stn = new StringTokenizer(br.readLine());
		buildings = new int[(int)Math.pow(2, k)-1];
		for (int i = 0; i < buildings.length; i++) {
			buildings[i] = Integer.parseInt(stn.nextToken());
		}
		insertQueue();
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < Math.pow(2, i); j++) {
				sb.append(ans.poll()).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}

}
