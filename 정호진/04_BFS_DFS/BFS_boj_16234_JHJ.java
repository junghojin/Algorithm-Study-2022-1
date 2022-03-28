package study05_dfs_bfs;

/*
 * 22.02.18 백준 16234 - 인구이동 (BFS)
 * 
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_boj_16234_JHJ {

	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static int N, L, R;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		L = Integer.parseInt(stk.nextToken());
		R = Integer.parseInt(stk.nextToken());
		int map[][] = new int[N][N];
		boolean visited[][] = new boolean[N][N];
		int day = 0; // 인구이동에 걸리는 일수
		// == 변수 초기화 ==

		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		// == input ==

		while (true) {
			visited = new boolean[N][N];
			boolean isMoved = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) // 이미 연합을 이룬 경우에는 다시 방문해줄 필요가 없다.
						// 좌표에 따라 move의 return 값이 갱신되기 때문에 조건을 추가하여 이동여부를 파악해야한다. 
						if (move(map, visited, i, j))
							isMoved = true;
				}
			}
			if (isMoved) // 인구이동이 한 번이라도 일어났다면,
				day++;
			else // 인구이동이 한 번도 일어나지 않았다면,
				break;
		}
		System.out.println(day);
	}

	private static boolean move(int map[][], boolean visited[][], int r, int c) {
		boolean isUnion = false;

		Queue<Point> queue = new LinkedList<>(); // 탐색을 위한 리스트
		LinkedList<Point> union = new LinkedList<>(); // 연합할 수 있는 영역을 담는 리스트

		queue.offer(new Point(r, c));// 시작하는 국가를 queue에 포함시키고 시작
		union.add(new Point(r, c)); // 시작하는 국가를 union에 포함시키고 시작
		int sum = map[r][c];
		visited[r][c] = true;

		// ** 인접국가 탐색 시작 **
		while (!queue.isEmpty()) {
			Point p = queue.poll(); // 하나의 시작 후보를 꺼낸다.
			for (int d = 0; d < 4; d++) {
				int nr = p.row + dr[d];
				int nc = p.col + dc[d];
				// 범위 벗어난 경우, 방문한 적이 있는 경우 pass
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc])
					continue;
				// 범위를 벗어나지 않고 이미 확인하지 않은 경우라면,
				int diff = Math.abs(map[p.row][p.col] - map[nr][nc]);
				if (diff >= L && diff <= R) { // 범위 안에 들어왔다면
					visited[nr][nc] = true; // 방문 처리
					union.add(new Point(nr, nc)); // 연합에 추가
					queue.add(new Point(nr, nc)); // 계속 살펴보기 위해 큐에 넣어준다.
					sum += map[nr][nc];
				}
			}
		}
		// == 탐색 완료 ==
		if (union.size() == 1) {
			// 주변에 인접 국가가 없었다는 것이므로 좌표를 바꿔줘야 한다.
			return false;
		}

		// ** 인접국가 간 인구이동을 시작한다. (인구 업데이트)**
		int average = sum / union.size();
		isUnion = true;
		while (!union.isEmpty()) {
			Point unionP = union.poll();
			//System.out.printf("Union: %d:%d%n", unionP.row, unionP.col);
			map[unionP.row][unionP.col] = average;
		}
		// == 값 변경 완료 ==

		return isUnion;
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
