package week;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/*
 * 2022.02.09 수요일
 * 백준 1697번 - 수빈이의 점프 
 * 
 * 점프를 할 때 걸리는 시간 최소 (최단 거리 - BFS)
 * 
 * 입력:
 * 수빈 위치 	동생 위치
 * 
 * 출력: 가장 빠른 시간 출력 
 */

public class BFS_boj_1697_JHJ {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int target = sc.nextInt();
		int[] visited = new int[100001];
		int[] dx = { -1, 1, 2 };
		Queue<Integer> map = new ArrayDeque<>();

		int sec = 0;
		map.offer(start);
		out: while (!map.isEmpty()) {
			if (start == target) { // 수빈이와 동생의 위치가 같을 때 break; 
				break out;
			}
			sec++;
			int length = map.size();
			for (int i = 0; i < length; i++) {
				int current = map.poll();
				for (int j = 0; j < 3; j++) {
					int nx = 0;
					if (j == 2) {
						nx = current * dx[j];
					} else {
						nx = current + dx[j];
					}
					if (nx == target) {
						break out;
					}
					if (nx >= 0 && nx <= 100000 && visited[nx] != 1) {
						visited[nx] = 1;
						map.offer(nx);
					}
				}
			}
		}
		System.out.println(sec);
	}
}
