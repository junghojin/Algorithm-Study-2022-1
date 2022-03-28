package q_1to7;
import java.util.Scanner;

public class q_4344 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		Loop1: for (int test = 0; test < T; test++) {

			int N = sc.nextInt();
			if (N < 1 || N > 1000)
				continue;
			
			int[] students = new int[N];
			// 학생들의 점수를 배열에 저장
			for (int i = 0; i < N; i++) {
				students[i] = sc.nextInt();
				if (students[i] < 0 || students[i] > 100)
					continue Loop1;
			}

			// 학생들의 평균을 구한다.
			int sum = 0;
			for (int i = 0; i < students.length; i++) {
				sum += students[i];
			}
			double avg = sum / students.length;

			// 평균을 넘는 학생 수
			int cnt = 0;
			for (int i = 0; i < students.length; i++) {
				if (students[i] > avg)
					cnt++;
			}
			// 평균을 넘는 학생 비율
			double rate = 100.0 * cnt / N;
			System.out.println(String.format("%.3f", rate) + "%");
		}
		sc.close();
	}
}
