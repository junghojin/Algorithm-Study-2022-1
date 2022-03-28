//package week;

import java.util.Scanner;

/*
 * 2022.02.08 화요일
 * 백준 1012번 - 유기농 배추 
 * 
 * 입력:
 * T
 * M(가로) N(세로) K(배추수)
 * 배추위치... (가로, 세로)
 * 
 * 출력: 각 테스트 케이스에 필요한 최소의 배추 흰지렁이 마리 수
 */

public class DFS_boj_1012_JHJ {

	static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dc = { 0, 0, -1, 1 };
	static int M, N, K;
	static int[][] map;

	public static boolean dfs(int r, int c) {
		if (r < 0 || c < 0 || r >= N || c >= M)
			return false;

		if (map[r][c] == 1) {
			map[r][c] = 0;

			for (int i = 0; i < 4; i++) {
				dfs(r + dr[i], c + dc[i]);
			}
			return true;
		}
		return false;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			M = sc.nextInt(); // 가로
			N = sc.nextInt(); // 세로
			K = sc.nextInt(); // 배추 수
			map = new int[N][M];

			for (int i = 0; i < K; i++) {
				int c = sc.nextInt();
				int r = sc.nextInt();
				map[r][c] = 1;
			}

			// == 입력 값 모두 받아옴 ==

			// == 탐색 시작 ==
			int result = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (dfs(r, c))
						result++;
				}
			}
			System.out.println(result);
		}
		sc.close();
	}

}
