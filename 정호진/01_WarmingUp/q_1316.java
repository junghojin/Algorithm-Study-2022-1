package q_1to7;

import java.util.Scanner;

public class q_1316 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int cnt = 0; // 그룹 단어 개수를 센다.
		for (int i = 0; i < N; i++) {
			String str = sc.next(); // 문자열을 읽어온다.
			String result = ""; // 연속해서 나타나는 문자를 저장한다.
			boolean check = true; // 연속여부 확인

			// 받아온 문자열을 한 문자씩 읽는다.
			for (int j = 0; j < str.length(); j++) {
				String letter = "";
				letter += str.charAt(j);
				
				if (result.contains(letter)) {
					// 연속해서 나타나는 문자가 아니라면, 그룹 단어가 아니다.
					if (result.charAt(result.length() - 1) != str.charAt(j)) {
						check = false;
						break;
					} else { // 연속해서 나타나는 문자라면, 확인한 문자까지는 그룹단어다.
						result += letter;
					}
				} else { // 처음 나오는 문자라면, 확인한 문자까지는 그룹단어다.
					result += letter;
				}
			}
			// 그룹 단어라면 그룹 단어 카운트 증가
			if (check)
				cnt++;
		}
		sc.close();
		System.out.println(cnt);
	}
}
