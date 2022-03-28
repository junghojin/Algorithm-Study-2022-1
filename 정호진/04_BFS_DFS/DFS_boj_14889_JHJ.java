//package study05_dfs_bfs;

import java.util.LinkedList;
import java.util.Scanner;

/*
 * 백준 14889 
 * 
 * 접근 방법:
 * 	가능한 경우의 수 구하기 (N/2)
 * 	각각의 팀의 능력치 합 구하기
 * 
 * 조건:
 * 	S_ij != S_ji
 * 	팀의 능력치 = S_ij + S_ji
 * 
 * 입력: 
 * 	배열 크기 N
 * 	배열 (능력치)
 * 
 * 출력: 스타트 팀과 링크 팀의 능력치 차이의 최솟값 출력
 */

public class DFS_boj_14889_JHJ {

	static int N; // 사람 수
	static LinkedList<Integer> team1; // 스타트팀
	static int[][] map;
	static int min = Integer.MAX_VALUE; // 팀 능력치의 차가 최솟값을 구한다. 
	static int total; // 몇 개의 가능한 팀이 있는지를 확인하기 위함

	/***
	 * 스타트 팀에 N/2명이 포함되는 경우를 구한다.
	 * 
	 * @param cnt   몇 명의 팀원이 포함되었는지 카운트
	 * @param start 부분집합을 구하기 위한 시작점
	 */

	public static void subset(int cnt, int start) {
		// base case
		if (cnt == N / 2 && total-- > 0) {
			LinkedList<Integer> team2 = new LinkedList<Integer>();
			// 스타트 팀에 포함되지 않은 사람을 링크팀에 포함시킨다.
			for (int i = 1; i <= N; i++) {
				if (!team1.contains(i)) // 만약 스타트 팀에 사람 i 가 포함되지 않았다면
					team2.add(i);
			}

			diff(team1, team2);
			return;
		}

		// recursive case
		for (int i = start; i <= N; i++) {
			team1.add(i);
			subset(cnt + 1, i + 1);
			team1.remove(team1.size() - 1);
		}
	}

	/**
	 * 스타트팀과 링크팀의 능력차를 구한다.
	 * 
	 * @param team1 스타트팀
	 * @param team2 링크팀
	 */
	public static void diff(LinkedList<Integer> team1, LinkedList<Integer> team2) {
		int teamStart = 0;
		int teamLink = 0;

		for (int i = 0; i < N / 2; i++) {
			for (int j = i + 1; j < N / 2; j++) {
				// S_ij != S_ji
				// 팀의 능력치 = S_ij + S_ji
				teamStart += map[team1.get(i)][team1.get(j)];
				teamLink += map[team2.get(i)][team2.get(j)];

				teamStart += map[team1.get(j)][team1.get(i)];
				teamLink += map[team2.get(j)][team2.get(i)];
			}
		}
		min = Math.min(min, Math.abs(teamStart - teamLink));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N + 1][N + 1];
		team1 = new LinkedList<>();
		total = N * (N - 1) / 4;
		// 1 2 3 이 start 팀이나 link 팀에 두 번 등장하기 때문에 경우의 수를 제한하였다.
		// 즉, 1 2 3(스타트팀) / 4 5 6(링크팀)의 팀 능력 차이는 4 5 6(스타트팀) / 1 2 3 (링크팀)의 각 능력차이와 같다.

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		// == 입력 값 ==

		/* 팀원을 N/2로 나누기 */
		subset(0, 1);
		System.out.println(min);

		sc.close();
	}
}
