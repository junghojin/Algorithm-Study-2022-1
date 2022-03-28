package week;

import java.util.Scanner;

/*
 * 2022.02.03.목요일
 * 구현 - 백준 2564번 - 경비원 - JHJ
 * 
 * 입력:
 * 블록의 가로길이, 세로길이 (각 1씩 추가)
 * 상점의 개수
 * 상점이 위치한 방향(1: 북, 2: 남, 3: 서, 4: 동), 상점의 위치(남/북 왼쪽으로부터, 서/동 위쪽으로부터)
 * 동근이의 위치 방향, 동근이의 위치
 * 동근이의 위치와 각 상점 사이의 최단 거리 합
 * 
 * 구현:
 * 상점의 위치를 담는 배열
 * 오른쪽 이동: 우 -> 상 -> 좌 -> 하 
 * 왼쪽의 이동: 좌 -> 상 -> 우 -> 하
 * 
 * case 1) 같은 방향에 위치할 경우
 * case 2) 다른 방향에 위치할 경우  - 방향이 반대인 경우, 오른쪽 혹은 왼쪽인경우
 */

public class Implementation_boj_2563 {

	static int[][] deltas_R = { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };
	static int[][] deltas_L = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
	static int[][] stores; // 각 상점 방향, 위치
	static int dir, position; // 동근이의 방향, 위치

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt() + 1;
		int C = sc.nextInt() + 1;
		int N = sc.nextInt(); // 상점의 개수
		stores = new int[N][2];

		for (int i = 0; i < N; i++) {
			stores[i][0] = sc.nextInt();
			stores[i][1] = sc.nextInt();
		}
		dir = sc.nextInt();
		position = sc.nextInt();
		// == 입력값 모두 받아옴 ===

		int result = 0;
		for (int i = 0; i < N; i++) {
			int left = 0; // 왼쪽 거리
			int right = 0; // 오른쪽 거리
			if (stores[i][0] == dir) {
				// 같은 방향에 위치한다면
				result += Math.abs(position - stores[i][1]);
			} else {
				// 다른 방향이라면
				if (dir > 0) { // 동근이가 북쪽(1) 혹은 남쪽(2)에 있다면
					if (Math.abs(stores[i][0] - dir) == 1) { // 상점과 동근이가 반대방향에 위치한다면
						left = right = C * 2;
						left += Math.abs(R - position) + Math.abs(R - stores[i][1]);
						right += position + stores[i][1];
					} else { // 상점이 동근이의 오른쪽 혹은 왼쪽에 위치한다면
						left = C + R + Math.abs(C-stores[i][1]) + position;
						right = Math.abs(R-position) + stores[i][1];
					}
						result += Math.min(left, right);
				} else if (dir > 2) {// 동근이가 서쪽(3) 혹은 동쪽(4)에 있다면
					if(Math.abs(stores[i][0] - dir) == 1) {
						left = right = R * 2;
						left += Math.abs(C - position) + Math.abs(C - stores[i][1]);
						right += position + stores[i][1];
					} else {
						left = C + R + Math.abs(R-stores[i][1]) + position;
						right = Math.abs(C-position) + stores[i][1];
					}
					result += Math.min(left, right);
				}
			}
		}
		System.out.println(result);
		sc.close();
	}
}
