package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Greedy_boj_1049_HSH {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n,m;
		
		n = sc.nextInt();	// 끊어진 기타줄 개수
		m = sc.nextInt();	// 기타줄 브랜드 개수
		
		
		int six[] = new int [m];	// six : 한팩  ,, one : 한줄
		int one[] = new int [m];

		for(int i=0; i<m;i++) {		 	// 브랜드 개수만큼 반복문을 돌려서 각각 배열에 입력
			six[i] = sc.nextInt();
			one[i] = sc.nextInt();
		}
		
		Arrays.sort(six);
		Arrays.sort(one);
		
		int Min = Math.min(((n/6)+1)*six[0], (n/6)*six[0]+(n%6)*one[0]);
		
		Min = Math.min(Min, n*one[0]);
		
		System.out.println(Min);
	}

}
