
// Java_07_09_1316

import java.util.*;

public class Java_07_09_1316 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result = 0;
		for (int i = 0; i < N; i++) {
			boolean arr[] = new boolean[26];
			String word = sc.next();
			boolean isword = true;
			for (int j = 0; j < word.length(); j++) {
				char c = word.charAt(j);
				if (arr[c - 'a']) {
					if (word.charAt(j) != word.charAt(j - 1)) {
						isword = false;
						break;
					}
				} else
					arr[c - 'a'] = true;
			}
			if (isword)
				result++;
		}
		System.out.println(result);

		sc.close();
	}
}
