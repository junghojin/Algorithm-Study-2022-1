// greedy_boj_19539_JJC

import java.util.*;

public class greedy_boj_19539_JJC {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum =0;
		int count=0;
		for(int i=0; i<n;i++){
			int temp = sc.nextInt();
			sum += temp;
			if(temp %2 == 1){
				count++;
			}
		}
		if((sum%3)==0 && (count <= sum/3)){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}

		sc.close();
	}
}
