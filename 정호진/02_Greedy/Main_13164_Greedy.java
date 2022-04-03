import java.util.Arrays;
import java.util.Scanner;

/*
 * 22. 04. 02. 토
 * 백준 13164 - 행복 유치원
 * 
 */

public class Main_13164_Greedy {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 원생의 수
		int K = sc.nextInt(); // 만들 조의 수

		/**
		 * 구해야 할 것 : 가장 키가 큰 원생과 가장 키가 작은 원생의 키 차이
		 */

		int[] heights = new int[N]; // 원생의 키
		int[] diffs = new int[N - 1]; // 각 원생 사이의 키 차이
		for (int i = 0; i < N; i++) {
			heights[i] = sc.nextInt();
		}
		// ============== input end ===================

		for (int i = 1; i < N; i++) {
			diffs[i - 1] = heights[i] - heights[i - 1];
		}
		Arrays.sort(diffs);

		int result = 0;
		for (int i = 0; i < N - K; i++) {
			result += diffs[i];
		}

		System.out.println(result);

		sc.close();
	}
}
