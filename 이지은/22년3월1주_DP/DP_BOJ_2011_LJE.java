package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2011_DP {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		long dp[] = new long[N.length()+1];
		
		dp[0] = 1;
		dp[1] = 1;
		if(N.charAt(0)=='0') {
			System.out.println(0);
			return;
		}
		for (int i = 2; i <= N.length(); i++) {
			int now = N.charAt(i-1) - '0';
			int pre = N.charAt(i-2) - '0';
			if(now==0) {
				if(pre<=0 || pre>=3) {
					System.out.println(0);
					return; 
				}
			}
			else {//now>=1 && now<=9) {
				dp[i] = dp[i-1] ;
			}
			
			int two = (pre)*10 + (now);
			if(two>=10 && two<=26) {
				dp[i] = (dp[i] +dp[i-2]) %1000000;
			}
			
			
		}
		System.out.println(dp[N.length()] );
	}

}
