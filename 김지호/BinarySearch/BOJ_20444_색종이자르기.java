package study_04_03;

import java.util.Scanner;

/* 20444_색종이와 가위 - 이분 탐색 */

public class BOJ_20444_색종이자르기 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextLong(); // n번의 가위질
		long k = sc.nextLong(); // k개 가능?
		
		boolean possible = false; 
		
		long l = 0;
		long r = n/2;
		
		while(l <= r) {
			
			long row = (r+l)/2;
			long col = n-row;
			
			long num = (row+1)*(col+1); // 색종이 수
			
			if(num == k) {
				possible = true;
				break;
				
			// 이분탐색
			}else if(num > k){
				r = row-1;
			} else {
				l = row+1;
			}
		}
		
		if(possible) System.out.println("YES");
		else System.out.println("NO");
	}
}

/* 
 * 
 * 각 행,열의 자른 가위질의 수 차이가 클수록 최종 색종이 수가 적어지고 
 * 가위질의 차이가 적을수록 최종 색종이 수가 많아짐
 * 
 * row가 n이고, col이 0일 때 가장 개수가 적고
 * row n/2이고, col이 n-row일 때 가장 개수가 많음
 * 
 * 따라서 row 개수가 (n/2)/2일 때부터 이분탐색 시작
 * 
 * row, col 바뀌어도 값은 안바뀜.
 */
