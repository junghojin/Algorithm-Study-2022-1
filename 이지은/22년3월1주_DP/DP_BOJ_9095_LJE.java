package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 1 = 1
 * -------------------> 1
 * 
 * 2 = 2
 *   = 1 + 1
 * -------------------> 2
 * 
 * 3 = 3
 *   = 2 + 1
 *   = 1 + 2
 *   = 1 + 1 + 1
 * -------------------> 4
 *   
 * 4 = 3 + (1)->1
 *   = 2 + (2)->2
 *   = 1 + (3)->4
 * -------------------> 7
 * 
 * 5 = 3 + (2)->2
 *   = 2 + (3)->4
 *   = 1 + (4)->7
 * -------------------> 13
 * 
 * => a(n) = a(n-1) + a(n-2) + a(n-3)
 */

public class DP_BOJ_9095 {
	static int[] d = new int[12];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		d[1]=1;
		d[2]=2;
		d[3]=4;
		for (int i = 4; i <= 11; i++) {
			if(d[i]==0) {
				d[i] = d[i-1] + d[i-2]+ d[i-3];
			}
		}
		for (int tc = 0; tc < TC; tc++) {
			int N = Integer.parseInt(br.readLine());

			System.out.println(d[N]);
		} // TC end
		
	}
}
