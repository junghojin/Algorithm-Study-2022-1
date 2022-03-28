//package week;

/*
 * 2022.01.31.월요일 - 선택한 구현 문제 풀기 
 * 구현 - 백준 1213번 - 팰린드롬 만들기 - JHJ
 * 구현, 그리디, 문자열 사용법 사전 학습 필요
 */


import java.util.Arrays;
import java.util.Scanner;

public class Implementation_boj_1213_JHJ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] arr = sc.nextLine().toCharArray();
		Arrays.sort(arr); // 그리디 접근 - 알파벳 순대로 중복된 문자를 정렬할 경우, 팰린드롬을 만들기 수월
		// == 입력 받기 완료 및 정렬(문자 순 오름차순) ==
		
		String result = solution(arr);

		if (result.equals(new StringBuilder(result).reverse().toString())) {
			// 만든 문자열이 팰린드롬인경우 결과 출력
			System.out.println(result);
		} else {
			// 만든 문자열이 팰린드롬이 아닌 경우 (거꾸로해도 원래의 단어와 다른 경우) 다음 메시지 출력
			System.out.println("I'm Sorry Hansoo");
		}
		sc.close();
	}

	public static String solution(char[] arr) {
		int lt = 0; // 왼쪽 위치
		int rt = arr.length - 1; // 오른쪽 위치
		char[] box = new char[arr.length]; // 팰린드롬을 만들 문자열
		int idx = 0; // 원래의 문자열에서 문자를 가져올 부분
		while (idx < arr.length - 1) { 
			if (arr[idx + 1] == arr[idx]) { 
				// 중복된 문자가 짝수개 존재할 경우, 팰린드롬을 만들 문자열의 왼쪽과 오른쪽에 차례대로 추가
				box[lt++] = arr[idx]; // 추가했으면 왼쪽의 위치 증가
				box[rt--] = arr[idx + 1]; // 추가했으면 오른쪽의 위치 감소
				arr[idx] = ' '; // 추가한 문자는 지우기
				arr[idx + 1] = ' '; // 추가한 문자는 지우기
				idx += 2; 
			} else { 
				// 중복된 문자가 홀수개 존재하거나, 중복된 문자가 없을 경우
				idx += 1;
			}
		}
		// 추가되지 않고 남은 문자 - 추가된 문자를 ' ' 처리 해주었기 때문에 앞 뒤 공백 제거 필요
		String temp = String.valueOf(arr).trim();
		// 추가된 문자에서 왼쪽 위치까지, 추가되지 않고 남은 문자, 추가된 문자의 오른쪽 위치에서 끝까지 (혹시 모를 빈 공간 제거)
		String answer = String.valueOf(box, 0, lt).trim() + temp
				+ String.valueOf(box, rt + 1, arr.length - rt - 1).trim();

		return answer;
	}
}
