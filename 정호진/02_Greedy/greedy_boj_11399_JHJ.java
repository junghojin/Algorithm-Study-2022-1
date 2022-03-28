import java.util.Arrays;

//백준 11399번_ATM
//수요일_JHJ

import java.util.Scanner;

public class greedy_boj_11399_JHJ {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] time = new int[N];
		for(int i = 0; i < N; i++) {
			time[i] = sc.nextInt();
		}
		
		// 대기 시간이 짧은 사람 순으로 ATM 사용시 - 기다리는 시간도 짧아진다. 
		// (= 대기시간이 긴 사람은 늦게 사용하는 것이 유리하다.)
		Arrays.sort(time);
		
		int w_time = 0; // 각 사람들의 대기시간을 구한다.
		int result = 0; // 모든 사람들의 대기시간을 더한다.
		for(int i = 0; i < N; i++) {
			w_time += time[i];
			result += w_time;
		};
		System.out.println(result);
		sc.close();
	}
}
