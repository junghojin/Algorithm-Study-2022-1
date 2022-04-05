
// Java_02_05_2884

import java.util.*;

public class Java_02_05_2884 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b;
		a = sc.nextInt();
		b = sc.nextInt();
		if (b - 45 < 0 && a - 1 < 0) {
			System.out.print(a + 23 + " ");
			System.out.print(b + 15);
		} else if (b - 45 < 0) {
			System.out.print(a - 1 + " ");
			System.out.print(b + 15);
		} else {
			System.out.print(a + " ");
			System.out.print(b - 45);
		}
		sc.close();
	}
}
