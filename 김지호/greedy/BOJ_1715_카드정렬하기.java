import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1715_카드정렬하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for (int i = 0; i < n; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		int sum = 0;
		
		while(pq.size() > 1) {
			
			int n1 = pq.poll();
			int n2 = pq.poll();
			
			sum = sum + n1 + n2;
			
			pq.add(n1+n2);
		}
		
		System.out.println(sum);
	}

}

