// implementation_boj_1213_JJC

import java.util.*;

public class implementation_boj_1213_JJC {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next(); // 문자열 입력을 받는다.
		int[] count = new int[26]; // 알파벳의 빈도수를 세는 배열

		for (int i = 0; i < str.length(); i++) {
			count[(str.charAt(i) - 'A')]++; // 문자열의 알파벳 빈도수를 구한다.
		}

		int oddCount = 0; // 빈도수가 홀수인 알파벳의 개수
		int odd = -1; // 빈도수가 홀수인 알파벳을 임시 저장

		for (int i = 0; i < 26; i++) { // count배열 중 홀수인 알파벳의 수를 센다.
			if (count[i] % 2 == 1) {
				oddCount++;
				if(odd == -1){
					odd=i;
				}
			}
		}

		if (oddCount == 0) { // 빈도수가 짝수로만 이루어진경우.
			for (int j = 0; j < 26; j++) {
				for (int k = 0; k < count[j] / 2; k++) {
					System.out.print((char) ('A' + j));
				}
			}
			for (int j = 25; j >=0; j--) {
				for (int k = 0; k < count[j] / 2; k++) {
					System.out.print((char) ('A' + j));
				}
			}
		} else if(oddCount == 1){ // 빈도수가 홀수인 알파벳이 하나만 존재하는 경우.
			for (int j = 0; j < 26; j++) { // 각 알파벳을 빈도수의 절반만큼 출력
				for (int k = 0; k < count[j] / 2; k++) {
					System.out.print((char) ('A' + j));
				}
			}
			
			System.out.print((char)('A'+odd)); // 빈도수가 홀수이므로 가운데에 출력

			for (int j = 25; j >=0; j--) { // 순서를 거꾸로 해서 빈도수의 절반만큼 출력
				for (int k = 0; k < count[j] / 2; k++) {
					System.out.print((char) ('A' + j));
				}
			}
		} else{ // 빈도수가 홀수인 알파벳이 두개이상인 경우.
			System.out.println("I'm Sorry Hansoo");
		}

		sc.close();
	}
}
