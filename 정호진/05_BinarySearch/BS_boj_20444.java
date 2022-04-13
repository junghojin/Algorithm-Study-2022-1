package study12_Binary;

import java.util.Scanner;

public class BS_boj_20444 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong(); // n 번의 가위질
		long k = sc.nextLong(); // k개의 색종이

		// n번의 가위질을 통해 k개의 색종이 조각을 만들 수 있는가? (결정 문제)
		// 0번 ~ n번 가로로 자르는 횟수
		// 0번 일때는 세로로 n번 자른다는 뜻
		long left = 0;
		long right = n;
		String result = null;
		while (left <= right) {
			long mid = (left + right) / 2;
			long hCnt = n - mid;

			long pieciesCnt = cutPaper(mid, hCnt);

			// k 개를 만들 수 있으면 더이상 과정을 진행할 필요가 없다.
			if (pieciesCnt == k) {
				result = "YES";
				break;
			} else if (pieciesCnt > k) {
				// k개보다 더 많이 만들 수 있다면, 많이 잘랐기 때문에 자른 횟수를 줄인다.
				right = mid - 1;
			} else {
				// k개 보다 더 작게 만들 수 있다면, 적게 잘랐기 때문에 자른 횟수를 늘린다.
				left = mid + 1;
			}
		}
		if (result == null)
			result = "NO";

		System.out.println(result);
		sc.close();
	}

	private static long cutPaper(long w, long h) {
		long cnt = (w + 1) * (h + 1);

		return cnt;
	}
} 
