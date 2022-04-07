import java.util.PriorityQueue;
import java.util.Scanner;

public class Greedy_boj_1715 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < N; i++) {
			pq.offer(sc.nextInt());
		}

		int totalSum = 0;
		while (pq.size() != 1) {
			int sum = pq.poll() + pq.poll();
			totalSum += sum;
			pq.offer(sum);
		}
		
		System.out.println(totalSum);
	}
}
