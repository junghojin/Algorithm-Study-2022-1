
// Java_05_06_8958

import java.util.*;

public class Java_05_06_8958 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < T; i++) {
			String str = sc.nextLine();
			int sum = 0;
			int score = 1;
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == 'O') {
					sum = sum + score++;
				} else {
					score = 1;
				}
			}
			System.out.println(sum);
		}
		sc.close();
	}
}
