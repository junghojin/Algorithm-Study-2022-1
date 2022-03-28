package greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class greedy_boj_1263_LJE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int [] Ti = new int[n]; //걸리는 시간
		Integer [] Si = new Integer[n]; //끝내야 할 시간
		
		for(int i=0;i<n;i++) {
			Ti[i] = sc.nextInt();
			Si[i] = sc.nextInt();
		}
		int startTime = 0;
		
		Integer[] sortSi = Si.clone();
		Arrays.sort(sortSi,Collections.reverseOrder());
		
		//20 16 14 5
		//5  1  8  3
		for(int i=0;i<n;i++) { //n?
			for(int j=0;j<n;j++) {
				if(sortSi[i] == Si[j]) {
					if(i==0) {
						if(Si[j]-Ti[j]<sortSi[i+1]) {
							startTime = Si[j] - Ti[j];
							continue;
						}else {
							startTime = sortSi[i+1] - Ti[j];
							continue;
						}
					}
					
					if(startTime<Si[j]) { 
						startTime = startTime - Ti[j];
					}else if(startTime>=Si[j]) {
						startTime = Si[j] - Ti[j];
					}
				}
			}
			
		}
		if(startTime>=0) {
			System.out.println(startTime);
		}else {
			System.out.println(-1);
		}
		
	}

}
