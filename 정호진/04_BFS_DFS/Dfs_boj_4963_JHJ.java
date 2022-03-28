package week;

import java.util.Scanner;

public class Dfs_boj_4963_JHJ {

	static int W, H;
	static int[][] map;
	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 }; // 좌상 -> 우하
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

	static boolean dfs(int r, int c) {

		if (r < 0 || c < 0 || r >= H || c >= W)
			return false;

		if(map[r][c] == 1) {
			map[r][c] = 0;
			
			for(int i = 0; i < 8; i++) {
				dfs(r+dr[i], c+dc[i]);
			}
			return true;
		}

		return false;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			W = sc.nextInt();
			H = sc.nextInt();
			if(W == 0 && H == 0) break;

			map = new int[H][W];

			for (int r = 0; r < H; r++) {
				for (int c = 0; c < W; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			// === 입력 값 받아옴 ===

			// === 탐색 시작 ===
			int result = 0;
			for (int r = 0; r < H; r++) {
				for (int c = 0; c < W; c++) {
					if (dfs(r, c))
						result++;
				}
			}
			System.out.println(result);
		}

		sc.close();
	}
}
