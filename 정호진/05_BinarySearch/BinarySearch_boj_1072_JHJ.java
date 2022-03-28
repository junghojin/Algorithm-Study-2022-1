package week;

import java.util.Scanner;

/*
 * 22.02.22. 수  백준 1072 - 게임
 * 
 */

public class BinarySearch_boj_1072_JHJ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long totalGame = sc.nextInt(); // 최대
		long winCnt = sc.nextInt(); // 최소
		long winningRate = (winCnt * 100 / totalGame);

		long start = 0;
		long end = totalGame;

		if (winningRate >= 99) {
			System.out.println(-1);
			return;
		}

		while (start <= end) {
			long mid = (start + end) / 2;

			long ratio = (winCnt + mid) * 100 / (totalGame + mid);

			if (ratio > winningRate) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		System.out.println(start);
	}

}
