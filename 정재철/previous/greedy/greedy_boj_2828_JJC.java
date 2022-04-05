// greedy_boj_2828_JJC

import java.util.*;

public class greedy_boj_2828_JJC {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m =sc.nextInt();
		int j = sc.nextInt();
		int[] apple = new int[j];
		int move=0;
		int x = 1;
		for(int i=0;i<j;i++){
			apple[i]=sc.nextInt();
			if(apple[i]<x){
				move += x -apple[i];
				x=apple[i];
			}else if(apple[i]>(x+m-1)){
				move += apple[i]-(x+m-1);
				x= apple[i]-m+1;
			}
		}
		System.out.println(move);
	}
}
