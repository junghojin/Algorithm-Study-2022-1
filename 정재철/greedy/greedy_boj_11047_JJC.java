// greedy_boj_11047_JJC

import java.util.*;

public class greedy_boj_11047_JJC {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] coin = new int[n];
		for(int i=0; i<n;i++){
			coin[n-1-i]=sc.nextInt();
		}
		int result =0;
		for(int i=0; i<n;i++){
			if(k/coin[i]>=1){
				result+=k/coin[i];
				k=k%coin[i];
			}
			if(k==0){
				break;
			}
		}
		System.out.println(result);

		sc.close();
	}
}
