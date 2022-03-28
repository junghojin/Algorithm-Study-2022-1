package week;

/* 22.03.02. 수 - 백준 9095번 - 1,2,3 더하기 */

// dp는 점화식 발견이 중요
// d[i] = d[i-1] + d[i-2] + d[i-3]
import java.util.Scanner;

public class DP_boj_9095_JHJ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		int[] dp = new int[11];

		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for (int i = 4; i < 11; i++)
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];

		for (int tc = 0; tc < TC; tc++) {
			int N = sc.nextInt();
			System.out.println(dp[N]);
		}

		sc.close();
	}

}
