
// Java_05_04_3052

import java.util.*;

public class Java_05_04_3052 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[10];
		int m[] = new int[42];

		for (int i = 0; i < 10; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < 10; i++) {
			m[arr[i] % 42]++;
		}
		int count = 0;
		for (int i = 0; i < 42; i++) {
			if (m[i] > 0) {
				count++;
			}
		}
		System.out.println(count);
		sc.close();

	}
}
