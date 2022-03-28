// greedy_boj_1789_JJC

import java.util.*;

public class greedy_boj_1789_JJC {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long s = sc.nextLong();
		long sum=0;
		int n=1;
		while(true){
			sum+=n;
			if(sum==s){
				break;
			}else if(sum>s){
				n--;
				break;
			}
			n++;
		}
		System.out.println(n);

		sc.close();
	}
}
