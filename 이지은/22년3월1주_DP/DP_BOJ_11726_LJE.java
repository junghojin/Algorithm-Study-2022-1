package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11726_DP {
	static int [] d = new int[1001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		d[1]=1;
		d[2]=2;
		for (int i = 3; i <= N; i++) {
			d[i]=(d[i-1]+d[i-2]) % 10007;
		}
		System.out.println(d[N]);
		
	}

}
