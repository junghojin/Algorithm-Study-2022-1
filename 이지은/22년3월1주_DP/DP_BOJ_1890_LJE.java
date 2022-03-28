package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1890_DP {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int map[][] = new int[N][N];
		long d[][] = new long[N][N];
		
		//입력
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		d[0][0]=1;
		//맨 처음부터 각 칸을 돌며 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(i==N-1 && j==N-1) continue;
				int k = map[i][j];
				if(i+k<N) d[i+k][j] += d[i][j];
				if(j+k<N) d[i][j+k] += d[i][j];
			}
				
		}
		
		System.out.println(d[N-1][N-1]);
	}

}
