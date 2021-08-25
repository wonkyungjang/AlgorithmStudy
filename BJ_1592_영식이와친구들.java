import java.util.Scanner;

public class BJ_1592_영식이와친구들 {

	static int N,M,L;
	static int v[];
	static int cnt; // 총 공을 몇번 던져야하냐
	public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt(); //애들 수
		M=sc.nextInt(); //공 몇번 받아야 함?
		L=sc.nextInt(); //시계,반시계로 얼만큼?
		v=new int[N+1]; //애들 번호로 인덱스 쓰기
		
		v[1]=1; //1번에 먼저 공 한번 주기
		int idx=1;
		while(v[1]!=M) {
			int ball=v[idx]; //n번이 받은 공 횟수를 저장
			if(ball%2==0) {//공 받은 횟수가 짝수라면
			//반시계 방향 L번째 전달
				if(idx-L>0)
					idx=idx-L;
				else
					idx=N+idx-L;
				v[idx]++;
			//시계 방향이면	공 받은 애가 cnt++
			}else {
				idx=(idx+L)%N;
				if(idx==0) idx=N;
				v[idx]++;
			}
			cnt++;
		}
		System.out.println(cnt);
	}
}
