package week;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 22.02.22. 화  백준 2805 - 나무자르기
 * 
 * 절단기에 설정할 수 있는 높이 0 또는 양의 정수
 * 절단기에 설정할 수 있는 높이의 최댓값
 * 
 */

public class BinarySearch_boj_2805_JHJ {

	static int N;
	static long M, trees[], maxCut;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextLong();
		trees = new long[N];
		for (int i = 0; i < N; i++) {
			trees[i] = sc.nextLong();
		}
		Arrays.sort(trees);
		System.out.println(binarySearch(0, trees[N - 1]));
	}

	private static long binarySearch(long start, long end) {
		if (start > end)
			return maxCut;

		long sum = 0;
		long mid = (start + end) / 2;
		for(long each:trees) {
			if(each < mid) continue;
			sum += each - mid;
		}
		
		if(sum >= M) {
			maxCut = mid;
			return binarySearch(mid+1, end);
		}
		else {
			return binarySearch(start, mid-1);
		}
	}
}
