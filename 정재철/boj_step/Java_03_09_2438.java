
// Java_03_09_2438

import java.util.*;

public class Java_03_09_2438 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			for(int j=0;j<i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		sc.close();
	}
}
