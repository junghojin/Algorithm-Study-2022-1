package week;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/*
 * 2022.02.10 목요일
 * 백준 2178번 - 미로탐색
 * 
 */


public class BFS_boj_2178_JHJ {

	static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String temp = sc.nextLine();
		int N = Integer.parseInt(temp.split(" ")[0]);
		int M = Integer.parseInt(temp.split(" ")[1]);

		char[][] map = new char[N][M];

		for (int i = 0; i < N; i++) {
			map[i] = sc.nextLine().toCharArray();
		}
		// == 입력값 받아옴 ==

		bfs(N, M, map);
	}

	static void bfs(int r, int c, char[][] map) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(new Node(0, 0));
		map[0][0] = '0'; // 방문한 경우 0 처리를 해준다.
		int cnt = 0;
		out: while (!queue.isEmpty()) {
			int length = queue.size();
			cnt++;
			for (int l = 0; l < length; l++) {
				Node n = queue.poll();
				//System.out.println(n.r + ":" + n.c);
				if (n.r == r-1 && n.c == c-1) // 도착
					break out;

				for (int i = 0; i < 4; i++) {
					int next_r = n.r + dr[i];
					int next_c = n.c + dc[i];
					if (next_r < 0 || next_r >= r || next_c < 0 || next_c >= c || map[next_r][next_c] == '0') {
						continue;
					}
					map[next_r][next_c] = '0'; // 이미 방문한 경우 0 처리를 해준다.
					queue.offer(new Node(next_r, next_c));
				}
			}
		}
		System.out.println(cnt);
	}
}

class Node {

	int r;
	int c;

	Node(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
