package study12_Binary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BS_boj_1477 {

	static ArrayList<Integer> stations;
	static int N, M, L;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 기존에 존재하는 휴게소 개수
		M = sc.nextInt(); // 새로 지으려는 휴게소 개수
		L = sc.nextInt(); // 고속도로 길이

		stations = new ArrayList<Integer>();
		stations.add(0);
		for (int i = 0; i < N; i++) {
			stations.add(sc.nextInt());
		}
		stations.add(L);
		Collections.sort(stations);
		// ---------- input end -----------------

		long start = 1;
		long end = L;
		while (start <= end) {
			long mid = (start + end) / 2;
			// 만약 mid만큼의 간격으로 휴게소를 세웠을 때, M 개 보다 더 많이 세울 수 있으면
			// M의 크기를 키워서 시도해본다.
			if (isAvailable(mid)) {
				start = mid + 1;
			} else { 
				// 만약 mid의 간격으로 휴게소를 세웠는데, M 개와 같거나 M개보다 작게 세울 수 있었다면
				// end 값을 줄여 mid 값을 줄여본다.
				end = mid - 1;
			}
			// 위 과정을 반복하다 start > end 일 때, 이미 start 이전의 영역은 탐색이 불필요하다고 (신경안쓴 값을 다시 신경쓸 필요가
			// 없다.)
			// Binary Search에서는 가정하기 때문에 멈춘다.
		}
		System.out.println(start);
	}

	private static boolean isAvailable(long mid) {
		int cnt = 0;
		for (int i = 1, size = stations.size(); i < size; i++) {
			// 이미 휴게소가 세워진 곳은 포함할 수 없으므로 두 값 포함해주지 않기 위해 1을 뺀다.
			// i.e. 700 ~ 711 (1,2,3,4,5,6,7,8,9,10 중 휴게소를 세울 수 있다.)
			// 이때 총 10개의 지역이 가능한데, 711 - 700 - 1 = 10이다.
			cnt += (stations.get(i) - stations.get(i - 1) - 1) / mid;
		}

		
		if (cnt > M)
			return true;
		return false;
	}
}
