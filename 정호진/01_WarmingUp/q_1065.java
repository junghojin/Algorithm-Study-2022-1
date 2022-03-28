package q_1to7;
import java.util.Scanner;

public class q_1065 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;

		if (N < 10) {
			cnt += N;
		} else if (N < 100) {
			cnt += N;
		} else {
			cnt += 99;
			for (int i = 100; i <= N; i++) {
				// 각 자리수를 구한다.
				int hundreds = i / 100;
				int tens = (i % 100)/10;
				int units = i % 10;

				if ((hundreds - tens) == (tens - units))
					cnt++;
			}
		}

		System.out.println(cnt);
	}

}
