package week;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 2022.02.02.수요일  
 * 구현 - 백준 15686번 - 치킨 배달 - JHJ
 * DFS 이용 
 */

/*
 * 문제: 도시의 치킨 거리가 가장 작게되게끔 구하기
 * 치킨거리: 집 기준, 가장 가까운 치킨집과의 거리
 * 도시의 치킨 거리: 모든 집의 치킨 거리 합 (모든 집 기준 가장 가까운 치킨 집과의 거리)
 * M 개의 치킨 집만 남기고 나머지 폐업
 * 남은 M 개의 치킨집과 각 집과의 치킨 거리의 합 구하기
 */

public class Implementation_boj_15686 {

	static int N; // 배열 크기
	static int M; // 살아남는 치킨집 개수
	static List<Point> house, chicken; // 집과 치킨집의 좌표 저장
	static int[] combination; // 고를 수 있는 치킨 집 조합
	static int answer = Integer.MAX_VALUE; // 최소의 도시 치킨거리

	public void DFS(int L, int s) {
		// L : 도달하고자 하는 길이 (개수)
		// S : combination에 들어가는 값

		if (L == M) {
			// M에 도달하면, 집합의 원소의 개수가 M 개라면
			int sum = 0; // 각 집에서의 치킨 거리 합
			for (Point h : house) {
				int diff = Integer.MAX_VALUE;
				for (int i : combination) {
					// 하나의 집에서 각 치킨집과의 거리 비교 후 최솟값을 찾는다.
					diff = Math.min(diff, Math.abs(h.r - chicken.get(i).r) + Math.abs(h.c - chicken.get(i).c));
				}
				sum += diff;
			}
			answer = Math.min(answer, sum);

		} else {
			// 집합의 원소의 개수가 M이 아니라면
			for (int i = s; i < chicken.size(); i++) {
				// combination L 위치에 i가 들어갔다면, L+1위치에는 i가 들어가지 못한다.
				combination[L] = i;
				DFS(L + 1, i + 1);
			}
		}
	}

	public static void main(String[] args) {
		Implementation_boj_15686 T = new Implementation_boj_15686();
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		house = new ArrayList<>();
		chicken = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int tmp = sc.nextInt();
				if (tmp == 1)
					house.add(new Point(i, j));
				else if (tmp == 2)
					chicken.add(new Point(i, j));
			}
		}

		// === 입력 값 모두 받아옴 ===

		combination = new int[M];
		T.DFS(0, 0);
		System.out.println(answer);
	}
}

class Point {
	int r; // 행 좌표
	int c; // 열 좌표

	Point(int r, int c) {
		this.r = r;
		this.c = c;
	}

}
