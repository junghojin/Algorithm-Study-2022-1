//package week;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * i 번쨰 일 - 걸리는 시간 T, 끝내야 하는 시간 S 까지.
 * 문제: 진영이가 최대한 늦잠을 자기 위해 최대한 늦게 일을 시작할 수 있는 시간
 * 해결방안:
 * 	일을 우선적으로 처리해야하는 것 - 우선적이란 마감시간이 빠른 순으로 일을 처리
 * 	마감 시간이 같을 경우, 일을 끝내는데 걸리는 시간이 많은 순으로 처리
 * 	마감 시간이 빠른 순으로 일을 처리했음에도, 다음 일을 처리하고 다음 마감시간이 넘어가면
 *  그 차이만큼 시작하는 일의 시간도 빨라진다.
 */

public class greedy_boj_1263_JHJ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Obj> arr = new ArrayList<Obj>();
		for (int i = 0; i < N; i++) {
			int t = sc.nextInt();
			int s = sc.nextInt();
			arr.add(new Obj(t, s));
		}
		Collections.sort(arr);
		
		int wake_time = arr.get(0).s - arr.get(0).t;
		int end_time = wake_time;
		for (Obj each : arr) {
			end_time += each.t; // 일이 끝나는 시간
			//System.out.println("end_time : " + end_time );
			if (end_time <= each.s) {
				// 일이 끝나는 시간이 마감시간보다 빨리 끝났다면 다음으로 넘어간다.
				continue;
			} else {
				
				// 일이 끝나는 시간이 마감시간을 넘어서면 끝나는 시간에서 마감시간을 빼고
				// 그 차이만큼 일어나는 시간을 앞당겨야 한다.
				wake_time -= (end_time - each.s);
				end_time -= (end_time - each.s);
				//System.out.println("wake_time : " + wake_time);
			}
		}
		if (wake_time < 0)
			wake_time = -1;
		System.out.println(wake_time);
	}
}

class Obj implements Comparable<Obj> {
	int t;
	int s;

	Obj(int t, int s) {
		this.t = t;
		this.s = s;
	}

	@Override
	public int compareTo(Obj o) {
		if (this.s - o.s == 0)
			return o.t - this.t;
		return this.s - o.s;
	}
}
