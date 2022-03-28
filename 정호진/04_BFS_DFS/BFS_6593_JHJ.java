package study05_dfs_bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 22.02.19. Sat
 * 백준 - 6593 - 상범빌딩 -
 * 
 *  상범이가 탈출할 수 있는 "가장 빠른(BFS)" 길 찾기
 	* 3차원 - 낮은층은 위에서부터 시작한다는 것을 잊지말기! (메모리 구조상 - 상: -1)
 	* 상범이가 갈 수 있는 위치 - 동서남북상하(6방향)
 	* 
 * 상범이가 더이상 갈 곳을 못찾는다면 Trapped!
 */

public class BFS_6593_JHJ {

	static int[] dz = { -1, 1, 0, 0, 0, 0 }; // 상하
	static int[] dy = { 0, 0, -1, 1, 0, 0 }; // 남북
	static int[] dx = { 0, 0, 0, 0, -1, 1 }; // 동서
	static int floor, R, C;
	static boolean[][][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			floor = Integer.parseInt(stk.nextToken());
			R = Integer.parseInt(stk.nextToken());
			C = Integer.parseInt(stk.nextToken());

			if (floor == 0 && R == 0 && C == 0)
				break;
			
			char[][][] building = new char[floor][R][C];
			visited = new boolean[floor][R][C];
			Queue<Point> queue = new LinkedList<>();
			for (int f = 0; f < floor; f++) {
				for (int r = 0; r < R; r++) {
					String temp = br.readLine();
					for (int c = 0; c < C; c++) {
						building[f][r][c] = temp.charAt(c);
						if (building[f][r][c] == 'S') {
							queue.offer(new Point(f, r, c)); // 상범이의 초기 위치 담기
							visited[f][r][c] = true; // 상범이의 초기 위치 방문 처리
						}
					}
				}
				br.readLine();
			}
			// == 초기화 끝 (확인 완료)==

			int min = escape(building, queue);
			if (min == 0)
				System.out.println("Trapped!");
			else {
				System.out.println("Escaped in " + min + " minute(s).");
			}
		}
	}

	private static int escape(char[][][] map, Queue<Point> queue) {
		int min = 0;
		while (!queue.isEmpty()) {
			int length = queue.size();
			min++; // 상범이의 자리부터 1분이동으로 계산되기 때문에, 탈출구를 만났을 때 1분을 추가해서 반환하지 않아도 된다.
			for (int i = 0; i < length; i++) {
				Point point = queue.poll();
				for (int d = 0; d < 6; d++) {
					int next_f = point.f + dz[d];
					int next_r = point.row + dy[d];
					int next_c = point.col + dx[d];
					// 범위 벗어나면 pass
					if (next_f < 0 || next_f >= floor || next_r < 0 || next_r >= R || next_c < 0 || next_c >= C)
						continue;
					// 이미 방문한 곳이어도 pass
					if (visited[next_f][next_r][next_c])
						continue;
					// 막힌 곳 pass
					if (map[next_f][next_r][next_c] == '#')
						continue;
					// 다음 스텝에 탈출이라면 끝
					if (map[next_f][next_r][next_c] == 'E')
						return min; // 다음 스텝에 탈출할 것이기 때문에 +1을 한다.

					visited[next_f][next_r][next_c] = true;
					queue.offer(new Point(next_f, next_r, next_c));
				}
			}
		}
		return 0;
	}

	private static class Point {
		int f;
		int row;
		int col;

		Point(int f, int row, int col) {
			this.f = f;
			this.row = row;
			this.col = col;
		}
	}
}
