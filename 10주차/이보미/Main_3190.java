import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 뱀
public class Main_3190 {

	static int N;
	static int [][] map;
	static int K, L;
	static Queue<RInfo> que;
	static int [] dr = {-1, 1, 0, 0}; // 0 : 상, 1 : 하, 2 : 좌, 3 : 우
	static int [] dc = {0, 0, -1, 1};
	static int result;
	
	static class RInfo {
		int time;
		String dir;
		
		public RInfo(int time, String dir) {
			super();
			this.time = time;
			this.dir = dir;
		}
	}
	
	static class Info {
		int r;
		int c;
		
		public Info(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			map[x][y] = 1;
		}
		
		L = Integer.parseInt(br.readLine());
		que = new LinkedList<>();
		
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			que.add(new RInfo(time, dir));
		}
		
		start();
		
		System.out.println(result);
	}

	private static void start() {
		Deque<Info> dq = new ArrayDeque<>();
		// 꼬리
		int tr = 0; 
		int tc = 0;
		dq.add(new Info(tr, tc));
		map[tr][tc] = 2;
		
		// 머리
		int hr = tr;
		int hc = tc;
		int d = 3; // 오른쪽으로 출발
		int time = 0;
		
		while(true) {

			if(!que.isEmpty() && time == que.peek().time) {
				RInfo temp = que.poll();
				if(temp.dir.equals("D")) {
					if(d == 0) {
						d = 3;
					}else if(d == 1) {
						d = 2;
					}else if(d == 2) {
						d = 0;
					}else if(d == 3) {
						d = 1;
					}
				} else if(temp.dir.equals("L")) {
					if(d == 0) {
						d = 2;
					}else if(d == 1) {
						d = 3;
					}else if(d == 2) {
						d = 1;
					}else if(d == 3) {
						d =  0;
					}
				}
			}
			
			hr += dr[d];
			hc += dc[d];
			
			if(check(hr, hc)) {
				if(map[hr][hc] == 1) { // 사과이면
					dq.addFirst(new Info(hr, hc));
					map[hr][hc] = 2;
				} else if(map[hr][hc] == 0) { // 아무것도 없으면
					dq.addFirst(new Info(hr, hc));
					map[hr][hc] = 2;
					Info tail = dq.pollLast();
					map[tail.r][tail.c] = 0;
				} else if(map[hr][hc] == 2) { // 뱀이면
					break;
				}
				
			}else {
				break;
			}
	
			time++;
			
		}
		
		result = time + 1; // 끝난시점은 그 이전 시간을 저장하고 있으므로 +1
		
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}

}
