
import java.util.Arrays;
import java.util.Scanner;

public class DP_boj_18353_JHJ{

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		// ============= input end ==============

		int d[] = new int[N]; // dynamic programming을 위한 배열 초기화
		
		Arrays.fill(d, 1);
		//d[0] = 1;
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				if (arr[i] > arr[j])
					d[j] = Math.max(d[j], d[i] + 1);
			}
			//System.out.println(Arrays.toString(d));
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			max = Math.max(d[i], max);
		}
		System.out.println(N - max);
	}
}
