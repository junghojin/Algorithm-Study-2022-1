// greedy_boj_1449_JJC

import java.util.*;

public class greedy_boj_1449_JJC {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt();
		int L=sc.nextInt();
		int[] map = new int[N];
		for(int i=0;i<N;i++){
			map[i]=sc.nextInt();
		}
		Arrays.sort(map);
		int result=0;
		int start=0;
		int end=0;

		for(int i=0; i<N;i++){
			if(map[i]>=end){
				result++;
				start=map[i];
				end= map[i]+L;
			}
		}
		System.out.println(result);

		sc.close();
	}

}
