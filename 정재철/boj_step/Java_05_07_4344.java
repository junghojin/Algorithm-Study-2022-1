
// Java_05_07_4344

import java.util.*;

public class Java_05_07_4344 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		for (int i = 0; i < C; i++) {
			int N = sc.nextInt();
			int arr[] = new int[N];
			double sum = 0;
			int count = 0;
			for (int j = 0; j < N; j++) {
				arr[j] = sc.nextInt();
				sum += arr[j];
			}
			for (int j = 0; j < N; j++) {
				if (arr[j] > 1.0 * (sum / N)) {
					count++;
				}
			}
			System.out.printf("%.3f", 1.0 * count / N * 100);
			System.out.println("%");
		}
		sc.close();
	}
}
