package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class greedy_BOJ_1715_LJE {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		int sum = 0;
		
		while(pq.size()>1) {
			int a = pq.poll();
			int b = pq.poll();
			
			sum = sum + a + b;
			pq.add(a+b);
			
//			System.out.println(sum+" "+a+" "+b+" "+pq.toString()+ " "+(a+b));
//			System.out.println();
		}

		System.out.println(sum);
	}
	
}

//30 40 50 60 - 답:360
/* -- 오답~
(30 + 40) : 70
70 + (70 +50) : 190
190 + (120+60) : 370
*/
/*
 * 
[30, 40, 50, 60]
sum=sum0+ (30+40) = 70

[50, 60, 70]
sum = sum70 + (50 + 60) = 180

[70, 110]
sum = sum180 + (70 + 110) = 360

 */
//더해서 만들어진 값이 원래 들어있는 값 보다 큰 경우가 있음 ㅠㅠ 그래서!!!! pq 사용해서 넣어서 앞에서 두개..



