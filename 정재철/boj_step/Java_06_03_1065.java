
// Java_06_03_1065

import java.util.*;

public class Java_06_03_1065 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = 0;

		for (int i = 1; i <= N; i++) {
			String str = Integer.toString(i);
			int arr[] = new int[str.length()];
			int dif[] = new int[str.length() - 1];
			for (int j = 0; j < str.length(); j++) {
				arr[j] = str.charAt(j);
			}
			for (int k = 0; k < str.length() - 1; k++) {
				dif[k] = arr[k] - arr[k + 1];
			}
			if (i > 999);
			else if (i > 99 && dif[0] != dif[1]);
			else
				count++;

		}
		System.out.println(count);
		sc.close();
	}
}
