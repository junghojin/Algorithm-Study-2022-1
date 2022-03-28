package q_1to7;
import java.util.Scanner;

public class q_2439 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();

		// for문
		for (int i = num - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}

			for (int j = 0; j < num - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
