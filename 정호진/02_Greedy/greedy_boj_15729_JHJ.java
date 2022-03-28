//package week;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * N - 버튼 개수
 * 상태 - 0 (off), 1 (on)
 * 한 버튼을 누르면 오른쪽 2개의 추가 버튼이 눌러진다. (총 3개)
 * 문제: 버튼을 최소로 눌러 쪽지에 적힌 버튼의 상태로 만들어라.
 * 출력: 몇 번 최소로 눌렀는가.
 */

public class greedy_boj_15729_JHJ {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String[] state = br.readLine().split(" ");
		// ===== 입력 값 모두 받아옴 =====

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (state[i].equals("1")) {
				cnt++;
				state[i] = state[i].equals("1") ? "0" : "1";
				if(i + 1 < N) {
					state[i+1] = state[i+1].equals("1") ? "0" : "1";
				}
				if(i + 2 < N) {
					state[i+2] = state[i+2].equals("1") ? "0" : "1";
				}
			}
		}
		System.out.println(cnt);
	}	
}
