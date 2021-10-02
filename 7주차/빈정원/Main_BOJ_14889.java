package _07_1006;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 스타트와 링크
public class Main_BOJ_14889 {

	static int N, min;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		combination(0, 0, new int[N / 2]);
		System.out.println(min);
	}

	private static void combination(int start, int cnt, int[] startTeam) {
		if (cnt == N / 2) {
			int[] linkTeam = getLinkTeam(startTeam);
			int startScore = 0;
			int linkScore = 0;
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < N / 2; j++) {
					if (i == j) continue;
					startScore += map[startTeam[i]][startTeam[j]];
					linkScore += map[linkTeam[i]][linkTeam[j]];
				}
			}
			min = Math.min(min, Math.abs(startScore - linkScore));
			return;
		}
		for (int i = start; i < N; i++) {
			startTeam[cnt] = i;
			combination(i + 1, cnt + 1, startTeam);
		}
	}

	private static int[] getLinkTeam(int[] startTeam) {
		int[] linkTeam = new int[N / 2];
		int startIdx = 0;
		int linkIdx = 0;
		for (int i = 0; i < N; i++) {
			if (startIdx < N / 2 && startTeam[startIdx] == i) {
				startIdx++;
			} else {
				linkTeam[linkIdx++] = i;
			}
		}
		return linkTeam;
	}

}
