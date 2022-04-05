
// Java_01_11_2588

import java.util.*;

public class Java_01_11_2588 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b, c, d, e;
		a = sc.nextInt();
		b = sc.nextInt();
		c = a * (b % 10);
		b /= 10;
		d = a * (b % 10);
		b /= 10;
		e = a * (b % 10);

		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(c + d * 10 + e * 100);
		sc.close();
	}
}
