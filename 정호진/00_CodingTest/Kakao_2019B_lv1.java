import java.util.*;

// 22. 06. 16 - 2019 Kakao 블라인드 - 실패율

public class Kakao_2019B_lv1 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(5, new int[] { 2, 1, 2, 6, 2, 4, 3, 3 })));
	}

	private static int[] solution(int N, int[] stages) {
		int[] answer = new int[N];

		int[] stage_info = new int[N + 1];
		// 각 스테이지 별 정보 등록
		for (int i = 0, length = stages.length; i < length; i++) {
			if (stages[i] == N + 1)
				continue;
			else
				stage_info[stages[i]]++;
		}
		
		// 실패율 계산
		ArrayList<Stage> stageList = new ArrayList<Stage>();
		int total_user = stages.length;
		for (int i = 1; i <= N; i++) {
			int no = i;
			total_user -= stage_info[i-1];
			
			float failure_rate = 0.0f; // zeroDivision error 를 막기 위해 
            if(total_user != 0) 
                failure_rate = (float) (stage_info[i]) / total_user;
            stageList.add(new Stage(no, failure_rate));
		}

		Collections.sort(stageList);

		for (int i = 0; i < N; i++) {
			answer[i] = stageList.get(i).no;
		}

		return answer;
	}

	private static class Stage implements Comparable<Stage> {
		int no;
		float failure_rate;

		Stage(int no, float failure_rate) {
			this.no = no;
			this.failure_rate = failure_rate;
		}

		@Override
		public int compareTo(Stage o) {
			if(o.failure_rate == this.failure_rate)
				return this.no - o.no;
			else
				return o.failure_rate < this.failure_rate ? -1 : 1; // 내림차순 정렬
		}

		@Override
		public String toString() {
			return "Stage [no=" + no + ", failure_rate=" + failure_rate + "]";
		}
	}
}
