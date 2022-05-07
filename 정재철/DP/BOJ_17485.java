// BOJ_17485_진우의 달 여행 (Large)
// 시간 복잡도 : O(NM)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17485 {
    public static void main(String[] args) throws IOException {
        /* ==========input========== */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] feul = new int[N][M];
        int[][][] dp = new int[N][M][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                feul[i][j] = Integer.parseInt(st.nextToken());
                if (i == 0) { // 첫번째 행을 복사한다.
                    dp[i][j][0] = feul[i][j];
                    dp[i][j][1] = feul[i][j];
                    dp[i][j][2] = feul[i][j];
                } else { // 최솟값을 구하기 위해 나머지 원소는 최댓갓을 넣어준다.
                    dp[i][j][0] = Integer.MAX_VALUE; // 왼쪽 아래 방향
                    dp[i][j][1] = Integer.MAX_VALUE; // 아래 방향
                    dp[i][j][2] = Integer.MAX_VALUE; // 오른쪽 아해 방향
                }
            }
        }
        /* ==========sol========== */
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (j == 0) { // 가장 왼쪽 행은 왼쪽 아래 방향을 하지않는다.
                    dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + feul[i][j];
                    dp[i][j][2] = Math.min(dp[i - 1][j+1][0], dp[i - 1][j+1][1]) + feul[i][j];
                } else if (j == M - 1) { // 가장 오른쪽 행은 오른쪽 아래 방향을 하지않는다.
                    dp[i][j][0] = Math.min(dp[i - 1][j-1][1], dp[i - 1][j-1][2]) + feul[i][j];
                    dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + feul[i][j];
                } else {
                    dp[i][j][0] = Math.min(dp[i - 1][j-1][1], dp[i - 1][j-1][2]) + feul[i][j];
                    dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + feul[i][j];
                    dp[i][j][2] = Math.min(dp[i - 1][j+1][0], dp[i - 1][j+1][1]) + feul[i][j];
                }
            }
        }
        int result=Integer.MAX_VALUE;
        for (int dir = 0; dir < 3; dir++) {
            for (int col = 0; col < M; col++) {
                result=Math.min(result,dp[N-1][col][dir]);
            }
        }
        /* ==========output========== */
        System.out.println(result);
        br.close();
    }
}