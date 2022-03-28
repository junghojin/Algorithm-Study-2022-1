// greedy_boj_1263_JJC

import java.util.*;

public class greedy_boj_1263_JJC {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int ti[] = new int[n];
		int si[] = new int[n];
		for (int i = 0; i < n; i++) {
			ti[i] = sc.nextInt();
			si[i] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) { // 배열 si의 내림차순 순서에 맞게 배열 ti도 정렬한다.
			for (int j = i + 1; j < n; j++) {
				if (si[i] < si[j]) {
					int tmp = si[i];
					si[i] = si[j];
					si[j] = tmp;
					tmp = ti[i];
					ti[i] = ti[j];
					ti[j] = tmp;
				}
			}
		}

		int dif = si[0] - ti[0]; //마감시간에서 걸리는 시간의 차이
		for (int i = 1; i < n; i++) {
			if (dif > si[i]) {
				dif = si[i] - ti[i];
			} else {
				dif -= ti[i];
			}

		}

		if (dif > 0) { // 최종 dif 값이 0보다 크다면 0시부터 시작해서 일을 끝마칠 수 있다.
			System.out.println(dif);
		} else {
			System.out.println("-1");
		}

		sc.close();
	}
}
