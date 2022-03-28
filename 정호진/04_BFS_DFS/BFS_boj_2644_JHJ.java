package study05_dfs_bfs;

/*
 * 22.02.15 백준 2644 - 촌수 계산 (그래프, BFS)
 * 
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_boj_2644_JHJ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int from = sc.nextInt();
		int to = sc.nextInt();
		int relationCnt = sc.nextInt();
		int[] degrees = new int[n+1];

		boolean map[][] = new boolean[n + 1][n + 1];

		for (int i = 0; i < relationCnt; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = true;
			map[b][a] = true;
		}

		bfs(map, degrees, from, to);
	}

	private static void bfs(boolean map[][], int degrees[], int from, int to) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(from);
		while (!queue.isEmpty()) {
			int index = queue.poll();
			if (index == to) // 내가 찾고자하는 사람이 발견되었다면 
				break;
			for (int j = 1, size = degrees.length; j < size; j++) {
				if (map[index][j]) { // 방문하지 않았고, 관계가 있다면
					map[index][j] = false; // 방문처리
					map[j][index] = false; // 방문처리
					queue.offer(j);
					degrees[j] = degrees[index] + 1; // 현재 내가 가진 degree+1;
				}
			}
		}
		
		if(degrees[to] != 0) // 관계가 있다면
			System.out.println(degrees[to]);
		else // 관계가 없다면
			System.out.println(-1);
	}
}
