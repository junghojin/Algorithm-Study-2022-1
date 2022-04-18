package study13_TwoPointer;

import java.util.Scanner;

public class BS_boj_2467 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] items = new int[N];

		for (int i = 0; i < N; i++) {
			items[i] = sc.nextInt();
		}

		// 1. 정렬 (필요 XX) - 이미 오름차순으로 입력이 주어진다.

		int left = 0; // 배열 왼쪽 끝 index
		int right = N - 1; // 배열 오른쪽 끝 index

		int ans1 = 0, ans2 = 0; // 출력할 두 수 

		int min = Integer.MAX_VALUE; // 0에 가까운 값 (절댓값)

		// 2. 이분탐색 
		// left가 커지고 right가 줄어들다보면 left == right가 같아지는 순간이 온다.
		// left와 right가 같아질 경우 같은 수를 가리키는 것을 의미하기 때문에
		// left <= right 가 아닌, left < right 가 되어야 한다.
		while (left < right) {
			int sum = items[left] + items[right]; // 두 인덱스의 합

			if (min > Math.abs(sum)) { 
				// 절댓값을 이용하지 않으면, min은 -가 될 수 있다.
				// -든 +든 0에 가까운 값을 찾는 것이므로 절댓값을 취해준다. 
				min = Math.abs(sum);
				ans1 = items[left];
				ans2 = items[right];
			}

			// sum이 0보다 작았다는 것은 왼쪽 값이 오른쪽 값보다 절댓값을 취했을 때 크다는 것을 의미한다.
			// 왼쪽을 증가시켜 sum의 수를 줄인다. 
			if (sum < 0)
				left++;
			else
				right--;
			// sum이 0보다 크다는 것은 오른쪽 값이 왼쪽 값보다 절댓값을 취했을 때 크다는 것을 의미한다.
			// 오른쪽을 감소시켜 sum의 수를 줄인다. (sum의 수를 줄여야 0에 가까운 값을 찾을 수 있다.)
		}

		System.out.println(ans1 + " " + ans2);
	}
}
