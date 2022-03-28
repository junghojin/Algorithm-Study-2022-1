package q_1to7;
import java.util.Scanner;

public class q_10952 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			if (A <= 0 || B >= 10)
				break;

			System.out.println(A + B);
		}
	}
}
