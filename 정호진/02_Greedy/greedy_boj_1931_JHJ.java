import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time implements Comparable<Time> {
	int start, end;

	public Time(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Time o) {
		if (this.end == o.end)
			return this.start - o.start; // 끝나는 시간이 같으면 시작 시간 순으로 오름차순
		else
			return this.end - o.end; // 끝나는 시간 순으로 오름차순
	}
}

public class greedy_boj_1931_JHJ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		ArrayList<Time> arr = new ArrayList<Time>();
		for (int i = 0; i < N; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			arr.add(new Time(s, e));
		}
		Collections.sort(arr);

		int end_time = 0;
		int cnt = 0; // 회의실을 사용할 수 있는 최대 개수
		// 시작 시간이 끝나는 시간보다 같거나 커야 회의실을 쓸 수 있는 다음 차례가 된다.
		for (Time each : arr) {
			if (each.start >= end_time) {
				cnt++;
				end_time = each.end;
			}
		}
		System.out.println(cnt);
		sc.close();
	}

}
