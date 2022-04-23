package study13_TwoPointer;

/*
 * 22.04.22. 금 - 백준 2473 세용액
 */

import java.util.Arrays;
import java.util.Scanner;

public class BS_boj_2473 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		long[] items = new long[N];

		for (int i = 0; i < N; i++) {
			items[i] = sc.nextLong();
		}

		// 1. 이진 탐색을 위한 정렬
		Arrays.sort(items);

		long ans1 = 0, ans2 = 0, ans3 = 0; // 출력할 세 수

		long min = Long.MAX_VALUE; // 0에 가까운 값 (절댓값)

		// 2. 탐색 시작
		for (int i = 0; i < N - 2; i++) { // 고정된 하나의 위치
			int left = i + 1; // 고정된 위치 다음 index
			int right = N - 1; // 배열 오른쪽 끝 index
			while (left < right) {
				long sum = items[i] + items[left] + items[right]; // 세 인덱스의 합

				if (min > Math.abs(sum)) { // 세 인덱스의 합이 기존의 최솟값보다 작을 경우 경우 갱신
					min = Math.abs(sum);
					ans1 = items[i];
					ans2 = items[left];
					ans3 = items[right];
				}

				if (sum < 0)
					left++;
				else
					right--;
			}
		}

		System.out.println(ans1 + " " + ans2 + " " + ans3);

	}

}
