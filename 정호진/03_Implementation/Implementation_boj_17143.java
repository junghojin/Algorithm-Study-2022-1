import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Implementation_boj_17143 {

	static int R, C, M, map[][], totalSize;
	static int[] dr = { 0, -1, 1, 0, 0 }; // 1: 상, 2: 하, 3: 우, 4: 좌
	static int[] dc = { 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(stk.nextToken());
		C = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken()); // 상어의 수
		map = new int[R + 1][C + 1];
		totalSize = 0;

		ArrayList<Shark> sharks = new ArrayList<Shark>();
		sharks.add(null);

		for (int m = 1; m <= M; m++) {
			stk = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(stk.nextToken());
			int c = Integer.parseInt(stk.nextToken());
			int speed = Integer.parseInt(stk.nextToken());
			int dir = Integer.parseInt(stk.nextToken());
			int size = Integer.parseInt(stk.nextToken());
			map[r][c] = m;
			sharks.add(m, new Shark(r, c, speed, size, dir));
		}
		// -------------- input end -------------------
//		for (int[] each : map) {
//			System.out.println(Arrays.toString(each));
//		}
//		sharkMove(sharks);
//		System.out.println();
//		for (int[] each : map) {
//			System.out.println(Arrays.toString(each));
//		}
		if (M > 0)
			fishing(sharks);
		System.out.println(totalSize);
	}

	private static void fishing(ArrayList<Shark> sharks) {

		for (int position = 1; position <= C; position++) {
			int sharkNo = 0;
			for (int r = 1; r <= R; r++) {
				if (map[r][position] != 0) {
					sharkNo = map[r][position];
					break;
				}
			}
			// 1. 상어 잡기
			if (sharkNo != 0) {
				totalSize += sharks.get(sharkNo).size;
				sharks.set(sharkNo, null);
			}

			// 2. 상어 위치 이동
			sharkMove(sharks);
		}
	}

	private static void sharkMove(ArrayList<Shark> sharks) {
		int[][] copiedMap = new int[R + 1][C + 1];

		for (int i = 1, size = sharks.size(); i < size; i++) {
			Shark s = sharks.get(i);
			// 이미 잡힌 상어이면 Pass
			if (s == null)
				continue;

			int nr = s.r, nc = s.c;
			for (int j = 0; j < s.speed; j++) {
				if (nr == R && s.dir == 2) {
					s.dir = 1;
				}
				if (nr == 1 && s.dir == 1) {
					s.dir = 2;
				}
				if (nc == C && s.dir == 3) {
					s.dir = 4;
				}
				if (nc == 1 && s.dir == 4) {
					s.dir = 3;
				}
				nr += dr[s.dir];
				nc += dc[s.dir];
			}

			// 이동하는 자리에 다른 상어가 존재하지 않는다면 그 자리에 상어를 놓는다.
			if (copiedMap[nr][nc] == 0) {
				copiedMap[nr][nc] = i;
				s.r = nr;
				s.c = nc;
			} else { // 이동하는 자리에 다른 상어가 존재한다면, 크기가 큰 상어가 살아남는다.
				Shark s2 = sharks.get(copiedMap[nr][nc]);
				if (s2.size > s.size) {
					sharks.set(i, null);
				} else {
					sharks.set(copiedMap[nr][nc], null);
					copiedMap[nr][nc] = i;
					s.r = nr;
					s.c = nc;
				}
			}
		}

		for (int r = 0; r <= R; r++) {
			for (int c = 0; c <= C; c++) {
				map[r][c] = copiedMap[r][c];
			}
		}
	}

	private static class Shark {
		int r;
		int c;
		int speed;
		int size;
		int dir;

		Shark(int r, int c, int speed, int size, int dir) {
			this.r = r;
			this.c = c;
			this.speed = speed;
			this.size = size;
			this.dir = dir;
		}
	}
}

//4 6 8
//4 6 3 3 8
//1 3 5 2 9
//2 4 8 4 1
//4 5 0 1 4
//3 3 1 2 7
//1 5 8 4 3
//3 6 2 1 2
//2 2 2 3 5
// ans: 10

//50 50 19
//4 9 21 1 999
//50 50 4 4 500
//50 49 222 3 200
//50 48 12 2 45
//50 47 36 1 900
//2 3 20 3 444
//4 8 4 2 49
//3 3 40 4 50
//2 2 460 2 4444
//48 23 500 3 12
//1 1 200 1 123
//44 44 123 3 125
//44 40 222 3 17
//40 44 333 3 57
//18 40 1 1 4
//3 10 50 2 406
//1 36 177 4 50
//1 46 120 4 7
//1 50 28 4 54
// ans: 7718