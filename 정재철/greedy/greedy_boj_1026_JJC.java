// greedy_boj_1026_JJC

import java.util.*;

public class greedy_boj_1026_JJC {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
		}
		for(int i=0;i<n;i++){
			b[i]=sc.nextInt();
		}
		Arrays.sort(a);
		Arrays.sort(b);

		int result=0;
		for(int i = 0; i<n;i++){
			result+=a[i]*b[n-1-i];
		}
		System.out.println(result);


		sc.close();
	}
}
