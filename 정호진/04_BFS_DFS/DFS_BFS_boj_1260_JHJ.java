//package week;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class DFS_BFS_boj_1260_JHJ {

	static int[] visited;

	public static void bfs(int[][] map, int n, int start) {

		visited[start] = 1;
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(start);
		while (!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current + " ");
			for (int i = 1; i <= n; i++) { // queue의 사이즈가 아닌 n인 이유는 모든 노드와의 관계성 조사를 위해서
				if (visited[i] == 0 && map[current][i] != 0) {
					visited[i] = 1;
					queue.offer(i);
				}
			}
		}
	}

	public static void dfs(int[][] map, int n, int start) {

		if (visited[start] == 0) {
			System.out.print(start + " ");
			visited[start] = 1;
		}
		else
			return;

		for (int i = 1; i <= n; i++) {
			if (visited[i] == 0 && map[start][i] != 0)
				dfs(map, n, i);
		
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int start = sc.nextInt();
		visited = new int[n + 1];

		int[][] map = new int[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			map[r][c] = 1;
			map[c][r] = 1;
		}

		dfs(map, n, start);
		Arrays.fill(visited, 0);
		System.out.println();
		bfs(map, n, start);

	}
}
