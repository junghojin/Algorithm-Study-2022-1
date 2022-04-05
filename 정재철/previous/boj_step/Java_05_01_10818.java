
// Java_05_01_10818

import java.util.*;

public class Java_05_01_10818 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		sc.close();
		Arrays.sort(arr);

		System.out.println(arr[0] + " " + arr[N - 1]);
	}
}
