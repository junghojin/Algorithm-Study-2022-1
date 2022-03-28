// greedy_boj_16953_JJC

import java.util.*;

public class greedy_boj_16953_JJC {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int result = 1;
		while (true) { // b->a로 가는 과정으로 연산 횟수를 구함.
			if (b == a) { // a와 b가 같으면 반복문 종료.
				break;
			} else if (b < a || (b % 2 == 1 && b % 10 != 1)) { //b가 a보다 작거나 b가 홀수 이면서 1의 자리 수가 1이 아니면 a는 b로 만들수 없다.
				result = -1;
				break;
			}
			if (b % 2 == 1 && a != b) { // 이 부분에 도달했다면 b가 홀수고 1의 자리가 1이고 a가 아니면 1의 자리의 1을 제거하면서 연산횟수 증가.
				b = b / 10;
				result++;
			} else { // b를 2로 나누고 연산 횟수 증가.
				b = b / 2; 
				result++;
			}
		}
		System.out.println(result);

		sc.close();
	}
}
