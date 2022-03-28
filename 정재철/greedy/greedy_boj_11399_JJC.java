// greedy_boj_11399_JJC

import java.util.*;

public class greedy_boj_11399_JJC {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int line[]=new int[n];

		for(int i=0;i<n;i++){
			line[i]=sc.nextInt();
		}

		Arrays.sort(line); // 시간의 합을 최소하기 위해 시간이 가장 적은 순으로 줄을 세운다 
		int result=0; 
		int sum=0;
		for(int i=0;i<n;i++){
			sum+=line[i]; // 각 사람이 인출하기까지 시간은 앞사람이 걸린 시간에 자신의 필요한 시간을 더한 값이다.
			result+=sum; // 각 사람의 인출 시간을 더한다.
		}
		System.out.println(result);

		sc.close();
	}
}
