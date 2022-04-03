package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
시작시간 기준으로 오름차순
*/

public class greedy_BOJ_19598_LJE3 {

	static class Meeting implements Comparable<Meeting> {
		int start;
		int end;

		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			return this.start - o.start;// 1 . 시작시간으로 오름차순
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		ArrayList<Meeting> list = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.add(new Meeting(start, end));
		}
		
		// 내림차순으로 - 차이가 적은 것을 변경하기 위해
		PriorityQueue<Integer> endList = new PriorityQueue<>(); // 끝나는 시간으로 오름차순
		
		endList.offer(list.get(0).end);// 첫 미팅 넣어줌

		for (int i = 1; i < N; i++) {
			while (!endList.isEmpty() 
					&& endList.peek()<=list.get(i).start) { // endList  즉. 회의들(끝나는 시간) 만큼 반복
		
				// 진행중인 회의가 끝나고 새로운 회의가 시작 가능할 때
				endList.poll(); // 진행중인 회의 끝나면 빼버리고 새로운 회의의 끝나는 시간으로 바꿔주기 위해 뺌

			}
				//가능해도 가능하지 않아도 새로운 회의의 끝나는 시간은 넣어야 함
				endList.offer(list.get(i).end);
			
		}
		

		System.out.println(endList.size());

	}

}
