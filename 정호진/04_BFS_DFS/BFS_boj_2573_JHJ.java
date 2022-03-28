
//package study05_dfs_bfs;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 22.02.18 금요일
 * 
 * BFS - 백준 2573 빙산
 * 
 *           바다: 0 / 빙산: 1 <= N 1년마다 동서남북 붙어있는 0만큼 높이가 줄어든다. - 상하좌우 바다 살피기
 * 
 *           빙산이 "두 덩어리" 이상으로 분리되는 "최초"의 년 - 
 *           bfs가 두 번이상 일어날 경우 탐색 끝 빙산의 첫번 째 행과 열, 마지막 행과 열은 항상 0으로 시작  
 *           1부터 탐색 시작 (0,0), (N-1, M-1)은 항상 바다이기 때문에
 * 
 *           빙하의 시작점 찾는 함수 melting 
 *           빙산 탐색 bfs - 위치 Point class 
 *           빙하가 전부 다 녹았는지 판단하는 checkIce
 *
 */

public class BFS_boj_2573_JHJ {

	static int N, M;
	static boolean visited[][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		// ** 입력 받아오기 ** - 배열 크기 최대 90000
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		int map[][] = new int[N][M];

		for (int r = 0; r < N; r++) {
			stk = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(stk.nextToken());
			}
		}
		// == 입력 모두 받아옴 ==

		int year = melting(map);

		System.out.println(year); // 다음 년도 얼음이 녹으려고 할 때, 두 덩어리인지 확인 후 year 값이 반환되기 때문에 -1 필요
	}

	// ** 얼음이 두 덩어리로 분리되는데 필요한 year **
	private static int melting(int map[][]) {
		int year = 0;
		while (true) {
			visited = new boolean[N][M];
			int cnt = 0; // 몇 덩어리로 나누어졌는지 개수 세기
			for (int r = 1; r < N - 1; r++) {
				for (int c = 1; c < M - 1; c++) {

					if (visited[r][c] || map[r][c] == 0) // 이미 방문한 곳이거나 바다면 패스
						continue;

					cnt++; // 얼음을 녹이러 가기 전, 몇 덩어리의 얼음인지를 카운트 한다.
					if (cnt > 1) // 얼음이 두 덩어리 이상이 되었다면 탐색 끝
						return year; // 두 덩어리가 있는 상태면 얼음이 두 덩어리로 분리되는데 걸리는 년도 반환

					bfs(map, r, c); // 연결된 얼음을 녹인다.
					// 얼음이 다 녹은 후, 모든 빙산이 녹았는지를 체크
					if (!isIce(map)) // 두 덩어리로 분리되지 않은 채(한덩어리의) 빙산이 다 녹았거나, 처음부터 녹일 얼음이 없다면
						return 0;
				}
			}
			year++; // 한 덩어리의 얼음이 녹았다면 1년이 지난 것이다.
		}
	}

	// ** 연결된 얼음을 녹인다 **
	private static void bfs(int[][] map, int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(r, c));
		visited[r][c] = true;
		// 탐색 시작
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			int seaCnt = 0;
			for (int d = 0; d < 4; d++) { // 상하좌우 바다 살피기
				int next_r = p.row + dr[d];
				int next_c = p.col + dc[d];
				if (next_r < 0 || next_r >= N || next_c < 0 || next_c >= M) // 범위벗어난 곳은 패스
					continue;
				if (visited[next_r][next_c])
					continue; // 이미 방문한 곳이라면 패스
				if (map[next_r][next_c] == 0) { // 바다라면 - 이를 고려하지 않으면 빙하가 있었던 곳이 0이 된 것까지 카운트하여 잘못된 결과 나옴
					seaCnt++;
					continue;
				}
				if (map[next_r][next_c] >= 1 && map[next_r][next_c] <= 10) { // 빙하라면
					visited[next_r][next_c] = true; // 방문처리
					queue.offer(new Point(next_r, next_c)); // 다음 방문할 곳으로 넣기
				}
			}

			// ** 빙하 녹이기 **
			if (map[p.row][p.col] <= seaCnt) // 빙하의 높이보다 바다와 닿는 면이 많았다면 빙하가 녹아 바다가 됨
				map[p.row][p.col] = 0;
			else // 빙하의 높이 낮추기
				map[p.row][p.col] = map[p.row][p.col] - seaCnt;
		}

	}

	// ** 더이상 녹일 얼음이 있는지 확인
	private static boolean isIce(int map[][]) {
		for (int r = 1; r < N - 1; r++) { // 처음과 끝을 보지 않는다고 했으므로 굳이 0,0 좌표부터 탐색을 시작할 필요가 없다. - 0,0 부터 탐색 시작시 시간 초과 발생
			for (int c = 1; c < M - 1; c++) {
				if (map[r][c] != 0)
					return true;
			}
		}
		return false;
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
