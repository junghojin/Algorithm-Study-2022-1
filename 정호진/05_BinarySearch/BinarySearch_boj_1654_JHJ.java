package week;

import java.util.Arrays;
import java.util.Scanner;

/*
 	***** N개보다 많이 만드는 것도 N개를 만드는 것에 포함 *****
 */

public class BinarySearch_boj_1654_JHJ {
	static int K, N;
	static long mid, lans[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		N = sc.nextInt();
		lans = new long[K];
		//maxLength = Integer.MIN_VALUE;
		for (int i = 0; i < K; i++) {
			lans[i] = sc.nextLong();
		}
		// == 입력 값 모두 받아옴 ==
		Arrays.sort(lans);
		System.out.println(cutMaxLength(1, lans[K - 1]));
		// 최소길이가 0일경우 
	}

	private static long cutMaxLength(long start, long end) {
		
		// start가 end보다 커지면 구간이 형성되지 않으므로 종료
		// start > end라는 말은 end가 start보다 더 작은 길이임을 의미하므로 start가 아닌 end를 최상위 범위로  return
		if (start > end)
			return end; 

		mid = (start + end) / 2; 
		int cnt = 0;
		for (int i = 0; i < K; i++) {
			cnt += lans[i] / mid; // 각각의 선을 mid의 길이로 몇 개 자를 수 있는가
		}
		
		if (cnt < N) {
			// N개보다 적은 수의 랜선으로 잘라졌다면, 잘라야하는 랜선의 길이를 줄여야한다
			return cutMaxLength(start, mid - 1);
		} else {
			// N개보다 더 많거나 같은 수의 랜선으로 잘라졌다면, 잘라야하는 랜선의 길이를 늘려야한다.
			// N개와 같은 수의 랜선으로 잘라졌더라도 찾고자하는 것은 최대의 랜선 길이 
			return cutMaxLength(mid + 1, end);
		}
	}
}