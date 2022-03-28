// 백준 1049번_기타줄
// 화요일_JHJ

import java.util.Scanner;

public class greedy_boj_1049_JHJ {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] pack = new int[M];
		int[] each = new int[M];

		int p_min = Integer.MAX_VALUE;
		int e_min = Integer.MAX_VALUE;
		for (int i = 0; i < M; i++) {
			pack[i] = sc.nextInt();
			each[i] = sc.nextInt();
			p_min = Integer.min(pack[i], p_min); // 낱개 중 최솟 가격
			e_min = Integer.min(each[i], e_min); // 패키지 중 최소 가격
		}

		int[] options = new int[3];
		options[0] = e_min * N; // 낱개로만 살 때
		options[1] = p_min * (N / 6 + 1); // 패키지로만 살 때
		options[2] = p_min * (N / 6) + e_min * (N % 6); // 패키지로 산 뒤, 나머지를 낱개로 살 때

		int result = Integer.min(options[0], options[1]);
		result = Integer.min(result, options[2]);

		System.out.println(result);

	}

}
