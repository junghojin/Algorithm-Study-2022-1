// greedy_boj_14241_JJC

import java.util.*;

public class greedy_boj_14241_JJC {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer  n = sc.nextInt();
		Integer [] arr=new Integer [n];
		for(int i=0; i<n;i++){
			arr[i]=sc.nextInt();
		}
		Arrays.sort(arr, Collections.reverseOrder());
		int result=0;
		for(int i=0; i<n-1;i++){
			result += arr[i]*arr[i+1];
			arr[i+1]=arr[i]+arr[i+1];
		}
		System.out.println(result);



		sc.close();
	}
}
