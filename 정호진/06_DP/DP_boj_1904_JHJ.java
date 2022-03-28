package week;

import java.util.Scanner;

/* 22.03.03. 목 - 백준 1904번 - 01타일 */

public class DP_boj_1904_JHJ {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long dp[] = new long[N + 1]; // i자리 타일을 만들 수 있는 경우의 수
		dp[0] = 1;
		dp[1] = 1;

		// dp[i] = dp[i-1] + dp[i-2]
		if (N >= 2) {
			for (int i = 2; i <= N; i++)
				dp[i] = (dp[i - 1] + dp[i - 2]) % 15746; // 수가 너무 커질 수 있으므로 모듈러 연산을 미리 행한다.
		}
		System.out.println(dp[N]);
		sc.close();
	}

}
