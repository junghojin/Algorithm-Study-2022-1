
// Java_04_03_1110

import java.util.*;

public class Java_04_03_1110 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, count;
		int next = -1;
		int a0, a1, mid;
		count = 0;
		n = sc.nextInt();
		a0 = n / 10;
		a1 = n % 10;
		mid = a0 + a1;
		while (n != next) {
			if (mid < 10) {
				next = 10 * a1 + mid;
			} else {
				next = 10 * a1 + mid % 10;
			}
			a0 = next / 10;
			a1 = next % 10;
			mid = a0 + a1;
			count++;
		}
		System.out.println(count);
		sc.close();
	}
}
