// package study05_dfs_bfs;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
 * 22.02.20 백준 1038 - 감소하는 수 (백트래킹)
 * 
 * N번째 감소하는 수 찾기
 * ... 백의 자리 숫자 > 십의자리 숫자 > 일의 자리 숫자 
 * 
 * 접근:
 *  앞자리수를 먼저 정한 뒤 뒤에 이어지는 수는 앞자리 수보다 작은 수일것!
 */

public class DFS_boj_1038_JHJ {
	static int N;
	static List<Long> numbers;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		numbers = new LinkedList<>();

		for (int i = 0; i < 10; i++)
			search(i, 1);
		Collections.sort(numbers);
		if (N >= numbers.size())
			System.out.println(-1);
		else
			System.out.println(numbers.get(N));
	}

	private static void search(long number, int depth) {
		if (depth >= 10) // 9876543210이 가장 큰 수
			return;

		numbers.add(number);
		for (int i = 0; i < number % 10; i++) {
			search((number * 10) + i, depth + 1);
		}
	}
}
