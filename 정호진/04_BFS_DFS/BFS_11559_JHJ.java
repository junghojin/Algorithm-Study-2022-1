package study05_dfs_bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 22.02.17.목요일 백준 11559 - 뿌요뿌요
 * 
 * 같은 색 뿌요가 4개 이상 - 상하좌우 연결해서 계속 탐색 - 같은 색은 없앤다 - 1연쇄
 * 모두 색이 터지면 위에 있는 색들을 아래로 내린다. (땅과 꼭 붙어있어야 한다.)
 * 주의할 점! 
 * 	한 번에 여러 색이 한꺼번에 터질 수 있다. 그러나 1연쇄로!
 *  모두 아래에 떨어져 있는 상태이기 때문에 끝점에서 부터 시작하는 것이 유리
 *  
 * 다음 상태의 지도에서 터짐을 반복하고 1연쇄 추가 (더이상 연쇄가 일어나지 않을 때까지 탐색)
 */

public class BFS_11559_JHJ {

	static final int Row = 12, Col = 6;
	static char[][] map;
	static boolean[][] visited; // 방문한 뿌요뿌요 표시하기
	static Queue<Point> samePuyos; // 같은 색의 뿌요뿌요 위치 담기
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		map = new char[Row][Col];
		for (int i = 0; i < Row; i++) {
			String temp = sc.nextLine();
			for (int j = 0; j < Col; j++) {
				map[i][j] = temp.charAt(j);
			}
		}
		// == 입력 받기 완료 ==

		int chainCnt = 0; // 연쇄횟수
		while (true) { // 뿌요들이 사라질 수 있을 
			visited = new boolean[Row][Col];
			boolean isValid = false;
			for (int j = Col - 1; j >= 0; j--) {
				for (int i = 0; i < Row; i++) {
					if (map[i][j] == '.' || visited[i][j])
						continue;
					samePuyos = new LinkedList<>(); // 한 번 탐방을 시작할 때마다 뿌요들을 담는다.
					game(i, j);
					if (samePuyos.size() >= 4) {
						isValid = true;
						clean(); // 뿌요뿌요 터뜨리기
					}
				}
			}
			if (isValid) {
//				System.out.println("---");
				ready(); // 다음 게임 준비를 위해 뿌요들을 떨어뜨린다.
//				for (char[] each : map)
//					System.out.println(Arrays.toString(each));
				chainCnt++; // 게임이 잘 진행이 되었다면 연쇄횟수 증가
			} else
				break;
		}

		System.out.println(chainCnt);

	}

	// ** 뿌요 게임 **
	private static void game(int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(r, c));
		samePuyos.add(new Point(r, c));
		visited[r][c] = true;

		while (!queue.isEmpty()) {
			Point p = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nr = p.row + dr[d];
				int nc = p.col + dc[d];
				if (nr < 0 || nc < 0 || nr >= Row || nc >= Col)
					continue;
				if (visited[nr][nc])
					continue;
				if (map[r][c] != map[nr][nc])
					continue;
				// 범위를 벗어나지 않고, 방문한 적도 없으며, 색도 현재의 뿌요와 같다면 방문 처리 - 큐에 넣고 탐색 - 같은 뿌요 큐에 넣어주기
				visited[nr][nc] = true;
				queue.offer(new Point(nr, nc));
				samePuyos.add(new Point(nr, nc));
			}
		}
	}

	// ** 뿌요뿌요 터뜨리기 **
	private static void clean() {
		while (!samePuyos.isEmpty()) {
			Point p = samePuyos.poll();
			map[p.row][p.col] = '.';
		}
	}

	// ** 지도 정비 **
	private static void ready() {
		for (int j = Col - 1; j >= 0; j--) {
			for (int i = Row - 2; i >= 0; i--) {
				for (int k = Row - 1; k > i; k--) {
					if (map[i][j] != '.' && map[k][j] == '.') {
						map[k][j] = map[i][j];
						map[i][j] = '.';
						break;
					}
				}
			}
		}
	}

	private static class Point {
		int row;
		int col;

		Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
