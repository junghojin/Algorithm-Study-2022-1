import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * 그리디 - 백준 - 19598번 - 최소 회의실 개수
 */

public class Main_19598_Greedy {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		ArrayList<Meeting> meetings = new ArrayList<Meeting>();
		for (int i = 0; i < N; i++) {
			int s = sc.nextInt();
			int c = sc.nextInt();
			meetings.add(new Meeting(s, c));
		}
		Collections.sort(meetings);

		PriorityQueue<Integer> rooms = new PriorityQueue<Integer>(); // end 시간을 넣는다.

		for (int i = 0, size = meetings.size(); i < size; i++) {
			if (rooms.isEmpty())
				rooms.add(meetings.get(i).e);
			else {
				if (meetings.get(i).s >= rooms.peek()) {
					rooms.poll();
				}
				rooms.add(meetings.get(i).e);
			}
		}
		System.out.println(rooms.size());

		sc.close();
	}

	private static class Meeting implements Comparable<Meeting> {
		int s;
		int e;

		Meeting(int s, int e) {
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Meeting o) {
			return s - o.s;
		}
	}
}
