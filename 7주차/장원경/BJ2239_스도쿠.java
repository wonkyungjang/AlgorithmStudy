import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

public class BJ2239_스도쿠 {

	static int map[][];
	static Point point;
	static ArrayList<Point> list;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		map=new int[9][9];
		list=new ArrayList<>();
		for(int i=0;i<9;i++) {
			char c[]=(sc.next()).toCharArray();
			for(int j=0;j<9;j++) {
				map[i][j]=c[j]-'0';
				if(map[i][j]==0) list.add(new Point(i,j));
			}
		}
		go(0);
		

	}
	private static void go(int idx) {

		//0의 위치가 담긴 list가 모두 비워지면 끝
		if(list.size()==idx) {
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					System.out.print(map[i][j]);
				}System.out.println();
			}
			return;
			//System.exit(0);
		}
				Point p=list.get(idx);
				int x=p.x;
				int y=p.y;
		
				boolean[] v=new boolean[10];
				
				//행,열,박스 안의 쓰여진 숫자들을 true처리
				//행 확인
				for(int j=0;j<9;j++) {
					if(map[x][j]!=0) {
						v[map[x][j]]=true;
					}
				}
				
				//열 확인
				for(int j=0;j<9;j++) {
					if(map[j][y]!=0) {
						v[map[j][y]]=true;
					}
				}
				
				//3*3 확인
				int startx=(x/3) * 3;
				int starty=(y/3) * 3;
				
				for(int j=startx; j<startx+3;j++) {
					for(int k=starty;k<starty+3;k++) {
						if(map[j][k]!=0) v[map[j][k]]=true;
					}
				}

				//v가 true인거 제외하고 넣어보기
				for(int j=1;j<10;j++) {
					if(!v[j]) {
						map[x][y]=j;
						go(idx+1);
						map[x][y]=0;
					}	
				}		
			}		
		}
