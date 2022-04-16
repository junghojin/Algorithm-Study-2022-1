# 백준 1477 - 휴게소 세우기

## **문제 요약** 

- **다솜이는 현재 고속도로에 N 개의 휴게소를 가지고 있다.**
- **휴게소의 위치는 고속도로의 시작으로부터 얼만큼 떨어져 있는지로 주어진다.**
- **이미 휴게소가 있는 곳에는 휴게소를 세울 수 없다.**
- **휴게소는 정수 위치에만 세울 수 있다.**

**Q. 휴게소를 M개 더 지어서 휴게소가 없는 구간의 길이의 최댓값의 최소를 구한다.**

**ex. {200, 701, 800} 이 있을 때, 휴게소가 없는 구간의 길이는 {501, 101}이다. 이 중 최댓값을 501이다.**

**만약 휴게소를 1(M)개 더 지으려고 할 때, 이미 휴게소가 세워지지 않았다면 많은 후보가 생긴다.**

- 451 에 세운다면 {200, 451, 701, 800} 이고, 휴게소가 없는 구간의 길이는 {251, 250, 101}이다.
- 300 에 세운다면 {200, 300, 701, 800} 이고, 휴게소가 없는 구간의 길이는 {100, 401, 101}이다.
- 휴게소는 어디든 세울 수 있지만, 각 후보의 휴게소가 없는 구간 길이의 최댓값들 중 최솟값은 251이다.
- 251로 출력한다.

## **제한 조건**

- **이미 세워진 휴게소의 개수 (0≤ N ≤ 100)**
- **더 세우려는 휴게소의 개수 (1≤ M ≤ 100)**
- **고속도로 길이 (100≤ L ≤ 1,000)**
- **휴게소의 위치 (1≤ N ≤ L-1)**
- **휴게소의 개수(N) + 더 세우려는 휴게소의 개수(M) < 고속도로의 길이(L)**
- **휴게소는 중복하여 세울 수 없음**
- **휴게소의 위치는 정수**

## **아이디어**

- **각 휴게소의 위치를 비교하여 그 사이 모든 정수를 가능성으로 두고 답을 찾으려고 하는 경우 O($_{L-N}C_{M}$) - 조합**
- $**_{1000-0}C_{100}$: 이라면 어마어마한 경우의 수가 생긴다. (63850511926305130236698511142022274281262900693853331776286816221524376994750901948920974351797699894319420811933446197797592213357065053890)**

**👉 Binary Search를 이용하여 최적화 문제를 결정 문제로 풀 수 있다. (Parametric Search)**

**💭 아이디어**

- **전체 고속도로에 일정 간격을 기준으로 휴게소를 세운다고 하자.**
- **이미 세워진 휴게소들 사이의 구간을 일정 간격으로 나눈뒤, 휴게소를 M개 세울 수 있는지 확인한다.**
- **기존 세워진 휴게소와 새로 세운 휴게소의 사이의 가장 작은 후보를 고른다.**

## **코드**
```java
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

```
