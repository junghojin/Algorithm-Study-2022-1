import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 22.04.09.금 - SWExpert 2112번 - 보호필름
 */

public class Implementation_SWExpert_2112 {

	static int R, C, K, minCnt;
	static boolean visited[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(stk.nextToken());
			C = Integer.parseInt(stk.nextToken());
			K = Integer.parseInt(stk.nextToken());
			int[][] map = new int[R][C];
			visited = new boolean[R];
			minCnt = Integer.MAX_VALUE;

			for (int r = 0; r < R; r++) {
				stk = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < C; c++) {
					map[r][c] = Integer.parseInt(stk.nextToken());
				}
			}
			// --------------- input end ---------------------------

			subset(0, 0, map);
			System.out.println("#" + tc + " " + minCnt);
		}
	}

	private static void subset(int L, int start, int[][] map) {
		if (L > R || L > K)
			return;

		if (checkSafety(map)) {
			minCnt = Math.min(L, minCnt);
			return;
		}

		for (int i = start; i < R; i++) {
			if (visited[i])
				continue;

			// A 약품 투입
			visited[i] = true;
			int[][] copiedMap = copyMap(map);
			spray(i, 0, copiedMap);
			subset(L + 1, i + 1, copiedMap);

			// B 약품 투입
			spray(i, 1, copiedMap);
			subset(L + 1, i + 1, copiedMap);
			visited[i] = false;
		}
	}

	// 안전성을 검사한다.
	private static boolean checkSafety(int[][] map) {
		boolean flags[] = new boolean[C];
		for (int c = 0; c < C; c++) {
			int count = 1;
			for (int r = 1; r < R; r++) {
				if (map[r-1][c] == map[r][c]) {
					count++;
				} else {
					count = 1;
				}
				if (count >= K) {
					flags[c] = true;
					break;
				}
			}
			if (!flags[c])
				return false;
		}
		return true;
	}

	// 약품 뿌리기
	private static void spray(int row, int value, int[][] copiedMap) {
		for (int c = 0; c < C; c++) {
			copiedMap[row][c] = value;
		}
	}

	// 지도 복사
	private static int[][] copyMap(int[][] map) {
		int[][] copy = new int[R][C];
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				copy[r][c] = map[r][c];
			}
		}
		return copy;
	}
}

//1
//6 8 3
//0 0 1 0 1 0 0 1
//0 1 0 0 0 1 1 0
//0 0 0 0 0 0 0 0
//1 1 1 1 0 0 0 1
//0 1 1 0 1 0 0 1
//1 1 1 1 1 1 1 1