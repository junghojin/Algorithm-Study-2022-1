
// Java_08_06_2775

import java.util.*;

public class Java_08_06_2775 {
	private static int sum(int k, int n) {
		int result = 0;
		if (n == 0) {
			result = 0;
		} else if (k == 0) {
			result = n;
		} else {
			result = sum(k - 1, n) + sum(k, n - 1);
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			System.out.println(sum(k, n));
		}
		sc.close();
	}
}
