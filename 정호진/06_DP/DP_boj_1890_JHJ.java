package week;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 22.03.04.금 - 백준 1890번 - 점프 */

public class DP_boj_1890_JHJ {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][] dp = new long[N][N]; // 각 좌표의 값 = 나를 몇 번 방문하였는가?
		int[][] map = new int[N][N];

		for (int r = 0; r < N; r++) {
			String[] temp = br.readLine().split(" ");
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(temp[c]);
			}
		}
		// ======= input end =========
		dp[0][0] = 1;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (dp[r][c] != 0 && map[r][c] != 0) {
					int nr = r + map[r][c];
					if (nr >= 0 && nr < N) {
						dp[nr][c] += dp[r][c];
					}

					int nc = c + map[r][c];
					if (nc >= 0 && nc < N) {
						dp[r][nc] += dp[r][c];
					}
				}
			}
			for (long[] each : dp)
				System.out.println(Arrays.toString(each));
			System.out.println();
		}
		System.out.println(dp[N - 1][N - 1]);

	}

}
