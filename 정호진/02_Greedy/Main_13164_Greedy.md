# 1. 문제 요약

- N 명의 원생들을 키 순서대로 줄을 세운다. (오름차순)
- K개의 조로 나누어 조마다 단체 티셔츠를 맞춘다.
    - 각 조 원생은 최소 한 명 이상은 있어야 한다.
    - 티셔츠의 비용 = 각 조에서 가장 큰 원생의 키 - 가장 작은 원생의 키
- 단, 티셔츠 만드는 비용의 합 최소로 할 것

# 2. 제한 사항

- 원생의 수: 1 ≤ N ≤300,000
- 조의 수: 1 ≤ K ≤ N
- 원생의 키는 10^9를 넘지 않는 자연수

# 3. 아이디어

<img width="600" src="https://github.com/junghojin/AlgorithmStudy2022/blob/d640b35372e7ceb95914adf4794e29914cfac3e5/%EC%A0%95%ED%98%B8%EC%A7%84/02_Greedy/img/Main_13164_img2.JPG">

---

<img width="600" src="https://github.com/junghojin/AlgorithmStudy2022/blob/d640b35372e7ceb95914adf4794e29914cfac3e5/%EC%A0%95%ED%98%B8%EC%A7%84/02_Greedy/img/Main_13164_img1.JPG">

---

- 위 그림에서 보면 **K개의 조**를 만들기 위해서는 **N-K개의 차를 더해야 한다**는 것을 알 수 있다.
- 문제에서 요구하는 것은 **최소의 티셔츠 비용**이므로 **N-K개의 차를 더한 값이 최소**이면 된다.
    
    ⇒ N개의 원소들의 차를 구하고, 이 차를 오름차순으로 정렬하여 N-K개 선택하기로 한다.
    

# 4. 코드

```java
import java.util.Arrays;
import java.util.Scanner;

/*
 * 22. 04. 02. 토
 * 백준 13164 - 행복 유치원
 * 
 */

public class Main_13164_Greedy {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 원생의 수
		int K = sc.nextInt(); // 만들 조의 수

		/**
		 * 구해야 할 것 : 가장 키가 큰 원생과 가장 키가 작은 원생의 키 차이
		 */

		int[] heights = new int[N]; // 원생의 키
		int[] diffs = new int[N - 1]; // 각 원생 사이의 키 차이
		for (int i = 0; i < N; i++) { 
			heights[i] = sc.nextInt();
		}
		// ============== input end ===================

		// 1. 각 원생의 키 차이를 구한다.
		for (int i = 1; i < N; i++) { // O(2N) = O(N)
			diffs[i - 1] = heights[i] - heights[i - 1];
		}
		Arrays.sort(diffs); // 키 차이를 오름차순 정렬

		// 2. N-K개 만큼의 차를 더한다.
		int result = 0;
		for (int i = 0; i < N - K; i++) { //O(N-K)
			result += diffs[i];
		}

		System.out.println(result);

		sc.close();
	}
}
```

- 시간 복잡도 =  O(N)
    - 각 원소의 차를 구하는 복잡도 ( O(2N) )
        - 첫 번째 원소와 두 번째 원소를 제외하면, 모두 2번 정도 방문한다.
    - 각 차를 구한 뒤, 차를 N-K 개 더한다. (O(N-K))
    
    ⇒ O(2N) + O(N-K) ≒ O(N)
