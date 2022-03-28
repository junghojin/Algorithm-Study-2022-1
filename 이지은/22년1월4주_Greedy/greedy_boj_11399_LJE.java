package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class greedy_boj_11399_LJE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int time[] = new int[n];
		int sum = 0;
		for(int i = 0;i < n;i++) {
			time[i] = sc.nextInt();
		}
		//------입력 끝
		
		Arrays.sort(time); // 정렬
		for(int i=0;i<n;i++) { //배열 크기만큼
			for(int j=0;j<=i;j++) {
				sum += time[j];
			}
		}
		System.out.println(sum);
	}
}

