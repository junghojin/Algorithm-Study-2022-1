
import java.util.*;

public class greedy_boj_15729_JJC {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();					// 입력
		boolean[] button = new boolean[n + 2]; 	// 0과 1중하나이므로 boolean배열 사용
		for (int i = 0; i < n; i++) {			// 배열의 오른쪽 2의 상태를 바꾸므로 크기는 n+2, 조회는 n전까지만
			if (sc.nextInt() == 1) {
				button[i] = true; 
			}
		}
		int result = 0;
		for (int i = 0; i < n; i++) { 			// 조회는 n전까지만
			if (button[i] == true) {			// 배열의 값이 왼쪽부터 true(1)이라면 우측 두개까지 상태변경
				result++; 						// 결과값 증가
				button[i] = !button[i]; 
				button[i + 1] = !button[i + 1];
				button[i + 2] = !button[i + 2];
			}
		}
		System.out.println(result);

		sc.close();
	}
}
