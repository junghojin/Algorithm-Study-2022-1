
// Java_05_05_1546

import java.util.*;

public class Java_05_05_1546 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double arr[] = new double[N];

		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		Arrays.sort(arr);
		double avg = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = arr[i] / arr[N - 1] * 100;
			avg += arr[i];
		}
		avg = avg / N;
		System.out.println(avg);
		sc.close();

	}
}
