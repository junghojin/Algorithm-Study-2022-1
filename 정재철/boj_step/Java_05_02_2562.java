
// Java_05_02_2562

import java.util.*;

public class Java_05_02_2562 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int index = -1;
		int arr[] = new int[9];
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		int max = 1;
		for (int i = 0; i < 9; i++) {
			if (arr[i] > max) {
				max = arr[i];
				index = i;
			}
		}

		sc.close();

		System.out.println(arr[index]);
		System.out.println(index + 1);
	}
}
