import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//bfs로 풀기
//최단문제 -> 가중치 o : 다익스트라, 가중치 x : bfs
public class BJ14496_그대그머가되어_bfs {

	static Queue<int[]> q;
	static int start, end;
	static int v,e; //정점과 간선의 개수
	static int map[][];
	static int res;
	static boolean visit[];
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		start=Integer.parseInt(st.nextToken());
		end=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		v=Integer.parseInt(st.nextToken());
		e=Integer.parseInt(st.nextToken());
		map=new int[v+1][v+1];
		q=new LinkedList<int[]>();
		visit=new boolean[v+1];
		for(int i=0;i<e;i++) {
			st=new StringTokenizer(br.readLine());
			int ss=Integer.parseInt(st.nextToken());
			int ee=Integer.parseInt(st.nextToken());
			map[ss][ee]=1;
			map[ee][ss]=1;
	}
		for(int i=1;i<=v;i++) {
			if(map[start][i]==1) {
				visit[i]=true;
				q.add(new int[]{i,1}); //정점, 카운트
			}
		}
		if(start==end) res=0;
		else res=bfs();
		System.out.println(res);
	}
	private static int bfs() {
		
		while(!q.isEmpty()) {
			int[] arr=q.poll();
	
			if(arr[0]==end) {
				return arr[1];
			}
			
			for(int i=1;i<=v;i++) {
				if(map[arr[0]][i]==1 && !visit[i]) {
					q.add(new int[] {i,arr[1]+1});
					visit[i]=true;
				}
			}
		}
		return -1;
	}
}