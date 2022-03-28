package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Fish implements Comparable<Fish> { // 위치와 해당 값을 알기 위한 클래스
	int x;
	int y;
	int size;
	int dist;

	Fish(int x, int y, int dist, int size) {
		this.x = x;
		this.y = y;
		this.dist = dist;
		this.size = size;
	}

	Fish(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist; // 움직인 거리 //는 결국 시간?
	}

	@Override
	public int compareTo(Fish o) {
		if (this.dist == o.dist) { // 거리가 같으면
			if (this.x == o.x) { // 위에 있는지 비교
				// 거리도 같고 행도 같으면 가장 왼쪽에 있는 순으로
				return this.y - o.y;
			}
			return this.x - o.x; // 거리가 같은데 같은 행에 있지 않으면 가장 위에 있는 순으로
		}
		return this.dist - o.dist; // 거리가 같지 않으면 거리 순으로
	}

}

public class DFSBFS_16236_LJE {
	static Queue<Fish> q;
	static ArrayList<Fish> fish; // 먹을 수 있는 물고기 리스트
	static int deltas[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상 하 좌 우
	static int N, map[][];
	static boolean visited[][];
	static int eatNum, answer; // 먹은 개수 , 정답
	static Fish babyshark;
	static boolean stop;

	public static void bfs(int i, int j) {
		visited = new boolean[N][N];
		q.add(new Fish(i, j, 0)); // 아기상어 넣기
		while (!q.isEmpty()) {
			Fish a = q.poll(); // 처음엔 상어
			visited[a.x][a.y] = true;

			for (int d = 0; d < 4; d++) {
				int dx = a.x + deltas[d][0]; // a.x = i
				int dy = a.y + deltas[d][1]; // a.y = j
				if (dx >= 0 && dx < N && dy >= 0 && dy < N && map[dx][dy] <= babyshark.size && !visited[dx][dy]) {
					if (map[dx][dy] == babyshark.size || map[dx][dy] == 0) {// 이동만 할 수 있을 때
						q.add(new Fish(dx, dy, a.dist + 1));
					} else if (map[dx][dy] < babyshark.size) { // 먹을 수 있을 때
						fish.add(new Fish(dx, dy, a.dist + 1));
					}

					visited[dx][dy] = true;

				}
			}
		}
		if (fish.isEmpty()) {
			stop = false;
			return;
		} else {
			Collections.sort(fish);
			if (!fish.isEmpty()) {
				Fish f = fish.get(0);
				answer += f.dist;
				eatNum++; // 먹기
				map[babyshark.x][babyshark.y] = 0; // 자리 옮기기
				babyshark.x = f.x;
				babyshark.y = f.y;

				if (eatNum == babyshark.size) {
					babyshark.size++;
					eatNum = 0; // 먹은 개수 초기화

				}
//				Arrays.fill(visited, false);
				fish.remove(0);
				fish.clear();

				bfs(babyshark.x, babyshark.y);

			}

		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		q = new LinkedList<Fish>();
		fish = new ArrayList<>();
		map = new int[N][N];
//		visited = new boolean[N][N];
		int x = 0, y = 0;
		eatNum = 0;
		answer = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					x = i;
					y = j;
				}
			}
		} // 입력 끝

//		sizeNow = 2;
		babyshark = new Fish(x, y, 0, 2);
		stop = true;
		
		bfs(x, y);

		System.out.println(answer);

	}

}
