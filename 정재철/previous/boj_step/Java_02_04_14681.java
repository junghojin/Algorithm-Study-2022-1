
// Java_02_04_14681

import java.util.*;

public class Java_02_04_14681 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b;
		a = sc.nextInt();
		b = sc.nextInt();
		if (a > 0 && b > 0) {
			System.out.println("1");
		} else if (a < 0 && b > 0) {
			System.out.println("2");
		} else if (a < 0 && b < 0) {
			System.out.println("3");
		} else {
			System.out.println("4");
		}
		sc.close();
	}
}
