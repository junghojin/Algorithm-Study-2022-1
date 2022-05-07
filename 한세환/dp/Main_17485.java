package dp;

import java.io.*;
import java.util.StringTokenizer;

public class Main_17485 {
    static int n, m;
    static int arr[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp();

    }

    public static void dp() {
        int dp[][][] = new int[n][m][3];
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            dp[0][i][0] = arr[0][i];
            dp[0][i][1] = arr[0][i];
            dp[0][i][2] = arr[0][i];
        }

        for (int i = 0; i < n; i++) {
            dp[i][0][0] = Integer.MAX_VALUE;
            dp[i][m - 1][2] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    dp[i][j][1] += dp[i - 1][j + 1][0] + arr[i][j]; // ↙에서 ↓
                    dp[i][j][2] += dp[i - 1][j + 1][0] + arr[i][j]; // ↙에서 ↘

                    dp[i][j][2] = dp[i][j][2] == 0 ? dp[i - 1][j][1] + arr[i][j] : Math.min(dp[i][j][2], dp[i - 1][j][1] + arr[i][j]); // ↓에서 ↘
                } else if (j == m - 1) {
                    dp[i][j][1] += dp[i - 1][j - 1][2] + arr[i][j]; // ↘에서 ↓
                    dp[i][j][0] += dp[i - 1][j][1] + arr[i][j]; // ↓에서 ↙

                    dp[i][j][0] = dp[i][j][0] == 0 ? dp[i - 1][j - 1][2] + arr[i][j] : Math.min(dp[i][j][0], dp[i - 1][j - 1][2] + arr[i][j]); // ↘에서 ↙
                } else {
                    dp[i][j][0] += dp[i - 1][j - 1][2] + arr[i][j]; // ↘에서 ↙
                    dp[i][j][1] += dp[i - 1][j - 1][2] + arr[i][j]; // ↘에서 ↓
                    dp[i][j][2] += dp[i - 1][j][1] + arr[i][j]; // ↓에서 ↘

                    dp[i][j][0] = dp[i][j][0] == 0 ? dp[i - 1][j][1] + arr[i][j] : Math.min(dp[i][j][0], dp[i - 1][j][1] + arr[i][j]); // ↓에서 ↙
                    dp[i][j][1] = dp[i][j][1] == 0 ? dp[i - 1][j + 1][0] + arr[i][j] : Math.min(dp[i][j][1], dp[i - 1][j + 1][0] + arr[i][j]); // ↙에서 ↓
                    dp[i][j][2] = dp[i][j][2] == 0 ? dp[i - 1][j + 1][0] + arr[i][j] : Math.min(dp[i][j][2], dp[i - 1][j + 1][0] + arr[i][j]); // ↙에서 ↘
                }
            }
        }
        for (int j = 0; j < m; j++) {
            for (int k = 0; k < 3; k++) {
                if (dp[n - 1][j][k] == 0) {
                    continue;
                }
                answer = Math.min(answer, dp[n - 1][j][k]);
            }
        }

        System.out.println(answer);

    }
}