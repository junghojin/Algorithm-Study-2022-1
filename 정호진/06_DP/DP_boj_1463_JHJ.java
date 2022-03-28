package week;

/* 22.03.01. 화 - 백준 1463번 - 1로 만들기 */

import java.util.Scanner;

public class DP_boj_1463_JHJ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N + 1];

		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + 1;

			if (i % 2 == 0)
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);

			if (i % 3 == 0)
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
		}

		System.out.println(dp[N]);

		sc.close();
	}

}
