// greedy_boj_11501_JJC

import java.util.*;

public class greedy_boj_11501_JJC {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 0; testCase < T; testCase++) {
			int N = sc.nextInt();
			int[] chart = new int[N];
			for (int i = 0; i < N; i++) {
				chart[i] = sc.nextInt();
			}
			long result = 0;
			int max = 0;
			for(int i = N-1;i>=0;i--){
				if(chart[i]>max){
					max = chart[i];
				}else{
					result += max-chart[i];
				}
			}
			System.out.println(result);
		}
		sc.close();
	}
}
