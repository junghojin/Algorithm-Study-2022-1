package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BinarySearch_BOJ_1654_LJE { //랜선 자르기
	static int K;
	static long N,Lan[];
	
	public static void binarySearch(long start, long end) {
		
		while(start<end) {
			long mid = (start+end)/2;
			long num=0;
			for (long i = 0; i < Lan.length; i++) {
				if(mid!=0) {
					num += Lan[(int) i] / mid;
				}
				
			}
			if(num<N) {
				end = mid;//-1;
			}else {
				start = mid+1;
			}
		}
		System.out.println(end-1);
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		Lan = new long[K];
		for (int i = 0; i < K; i++) {
			Lan[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(Lan);
		binarySearch(0, Lan[K-1]+1); // 제일 긴 것 기준으로 
		
	}

}
