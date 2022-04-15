package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BinarySearch_BOJ_1477_LJE {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 현재 휴게소 개수
		int M = Integer.parseInt(st.nextToken()); // 더 지으려는 개수
		int L = Integer.parseInt(st.nextToken()); // 고속도로 길이
		ArrayList<Integer> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		list.add(L);
		list.add(0);
		Collections.sort(list); //이진탐색은 항상정렬후!
		
		//탐색의 기준은 "휴게소 M개 사이의 거리를 distance 로 하였을 때 몇개의 휴게소를 새로 세울 수 있느냐"
		//휴게소를 전체 구간 중 정 가운데에 세울 때부터 시작해 구간의 중간 값을 간격으로 두고, 
		//해당 간격을 유지하며 휴게소를 세웠을 때 세울 수 있는 휴게소를 count
		//count 값이 M 보다 크다면 간격을 넓혀야 하므로 left=mid+1, 
		//그 반대라면 간격을 줄여야 하므로 right=mid-1 을 통해 적절한 간격을 찾아나간다.
		int start = 1; // zero division error 방지
		int end = L;
		
		while(true) {
			if(start>end)break;
			int mid = start + (end-start)/2;
			int num = 0; // 새로 지을 수 있는 휴게소 수
			
			for (int i = 1; i < list.size(); i++) {
			
				num += (list.get(i) - list.get(i-1)-1)/mid;//
				
			}
			if(num>M) {
				start = mid + 1;
			}else if(num<= M) {
				end = mid - 1;
			}
//			System.out.println(start + " "+ end + " " + mid+" "+ num);

		}
		System.out.println(start);
		
	}
	
	

}
