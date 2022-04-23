package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//-10억~10억 사이의 정수가  ( 값이 3개가 최대로 큰게 더하면 30억이라 int 안에서 해결 X ->long 사용)
// 3~5000 사이의 개수만큼 : 리스트 길이 = 이만큼 탐색 진행
// 투 포인터?
//
public class BinarySearch_BOJ_2473_LJE {

	static void BinarySearch(int index) {
		int start = index+1; // 시작
		int end = N - 1; // 끝	

		while (start < end) {
			long sum = (long)list[start] + (long)list[end] + (long)list[index];

			if (sum == 0) { // 0이면 바로 끝내주기
				liquid[0] = list[index]; 
				liquid[1] = list[start];//list.get(start);
				liquid[2] = list[end];//list.get(end);
				break;
			}
			if (Math.abs(sum) < min) { // 새로운 합이 더 작다면 값 저장
				//무조건 index<start<end 순의 크기일 것이므로 차례대로 저장함으로써 
				//출력 전 정렬을 줄여줄 수 있다.
				liquid[0] = list[index]; 
				liquid[1] = list[start];//list.get(start);
				liquid[2] = list[end];//list.get(end);
				min = Math.abs(sum);
			}

			if (sum >= 0) { // 합이 0보다 크다면 0기준 밸런스가 오른쪽에 치우친거니까
				end -= 1; // 오른쪽을 줄여주기
			} else { // 0보다 작으면 왼쪽에 치우친거니까
				start += 1; // 왼쪽을 줄여주기
			}
		}

	}

	static int N, liquid[],list[];
	static long min = Long.MAX_VALUE;
//	static List<Integer> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
//		list = new ArrayList<>();
		list = new int[N]; //용액들 저장  
		liquid = new int[3]; // 출력할 세 용액
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		/* 탐색 */
		Arrays.sort(list); // 이진 탐색은 항상 정렬 후
		for (int i = 0; i < N; i++) { //for문을 돌며 값 하나씩 나머지에 대한 탐색하기
			BinarySearch(i);
		}
		
//		Arrays.sort(liquid); // 오름차순으로 출력 위해 정렬
		System.out.println(liquid[0] + " " + liquid[1] + " " + liquid[2]);

	}

}
