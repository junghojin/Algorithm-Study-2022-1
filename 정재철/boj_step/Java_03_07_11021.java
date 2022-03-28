
// Java_03_07_11021

import java.util.*;

public class Java_03_07_11021 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t, a, b;
		t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			System.out.println("Case #" + i + ": " + (a + b));
		}
		sc.close();
		
	}
}
