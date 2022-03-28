package q_1to7;

import java.util.Scanner;

public class q_14681 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();

		if (x < -1000 || x > 1000 || x == 0)
			System.exit(0);
		if (y < -1000 || y > 1000 || x == 0)
			System.exit(0);

		// 사분면 중 하나 고르기
		if (x < 0 && y > 0)
			System.out.println(2);
		else if (x < 0 && y < 0)
			System.out.println(3);
		else if (x > 0 && y > 0)
			System.out.println(1);
		else if (x > 0 && y < 0)
			System.out.println(4);

	}

}
