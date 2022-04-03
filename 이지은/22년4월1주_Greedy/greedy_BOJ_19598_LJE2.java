package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
회의 끝나는 시간이 끝난 기준으로 정렬
그 회의들을 보면서 회의 시작시간이 그 전에 끝나느 시간보다 빠르다면 회의실 개수를 늘려줌. & 그 회의의 끝나느 시간을 새로운 회의의 끝나는 시간으로 바꿔줌
*/

public class greedy_BOJ_19598_LJE2 {

	static class Meeting implements Comparable<Meeting>{
		int start;
		int end;
		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Meeting o) {
			if(this.end==o.end) {
				return o.start - this.start; // 2. 시작하는 시간으로 내림차순 = 시작시간 느림 = 회의시간 더 짧음
			}
			return this.end - o.end;//1 . 끝나는시간으로 오름차순
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		PriorityQueue<Meeting> pq = new PriorityQueue<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			pq.add(new Meeting(start,end)); //log n
		}	
		

		//내림차순으로 - 차이가 적은 것을 변경하기 위해 
		ArrayList<Integer> endList = new ArrayList<>();
		Meeting mPre = pq.poll(); //앞선 미팅 

		endList.add(mPre.end); //log n
		
		while(!pq.isEmpty()) {
			
			
			Meeting mNext = pq.poll(); // 그 다음 미팅 log n
			boolean use = false;
			
			Collections.sort(endList,Collections.reverseOrder()); //내림차순으로 - 차이가 적은 것을 변경하기 위해 
			for (int i = 0; i < endList.size(); i++) { //현재 진행중인 회의개수만큼 반복
				if(endList.get(i)<=mNext.start) { //회의실 추가 없이 다음 시간에 들어갈 수 있다면 
//					endList.set(i, mNext.end); // 회의끝시간 변경
					endList.remove(i);
					use = true; // 있는거 사용했다고 처리
					break;
				}
			}

			endList.add(mNext.end);
		}

		System.out.println(endList.size());
		
	}

}
