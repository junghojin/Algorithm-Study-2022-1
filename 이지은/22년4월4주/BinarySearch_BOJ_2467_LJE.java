package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//-10억~10억 사이의 정수가  ( 2값이 최대로 큰게 더해도 20억이라 int 안에서 해결 가능)
// 2~10만개 사이의 개수만큼 : 리스트 길이 = 이만큼 이진 탐색 진행
// 투 포인터

public class BinarySearch_BOJ_2467_LJE { // 용액 
	
	static void BinarySearch() {
		int start = 0; // 시작
		int end = N-1; // 끝
		int min = Integer.MAX_VALUE;
		
		
		
		while(start<end) {
			int sum = list[start] + list[end];
			
			if(sum==0) { // 0이면 바로 끝내주기 
				liquid[0]=list[start];
				liquid[1]=list[end];
				break;
			}
			if(Math.abs(sum)<min) { //새로운 합이 더 작다면 값 저장
				liquid[0]=list[start];
				liquid[1]=list[end];
				min = Math.abs(sum);
			}
			
			if(sum>=0){ // 합이 0보다 크다면 0기준 밸런스가 오른쪽에 치우친거니까
				end -= 1; //오른쪽을 줄여주기
			}else {  // 0보다 작으면 왼쪽에 치우친거니까
				start += 1; // 왼쪽을 줄여주기 
			}
		}
		
	}
	
	
	static int N,list[],liquid[]; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		list = new int[N]; // list : 용액들 저장   
		liquid = new int[2]; //  liquid : 출력할 용액
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		/* 탐색 */
		Arrays.sort(list); // 이진 탐색은 항상 정렬 후
		
		BinarySearch(); // 탐색
		
		Arrays.sort(liquid); // 오름차순으로 출력 위해 정렬
		System.out.println(liquid[0] +" "+liquid[1]); 
	}

}
