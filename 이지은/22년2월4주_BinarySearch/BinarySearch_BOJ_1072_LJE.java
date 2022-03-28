package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinarySearch_BOJ_1072_LJE {

	static long X,Y,Z;
	
	public static void binarySearch(long target, int start, int end) {
			
		while(start<=end) {
			int mid = (start + end) / 2;
			long newZ = (Y+mid)*100/(X+mid);//(int)((double)(Y+mid)/(X+mid)*100);
			if(newZ>target) {
				end = mid-1;
			}else {// if(newZ<target) {
				start = mid+1;
			}

		}
		System.out.println(start);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		Z =  Y*100/X;//(int)((double)Y/X*100); //target

		if(Z>=99) {
			System.out.println(-1);
		}else {
			binarySearch(Z, 1, (int)X);
		}
		
		
	}

}
/*
53 47
*/
