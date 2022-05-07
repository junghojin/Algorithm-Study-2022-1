package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class DP_BOJ_12865_LJE { // 평범한 배낭
	//수업자료 참고
	//0-1 knapsack 알고리즘

	
	static int N,K;
	static int knapsack[][]; //100*100000 = 10000000
	static int items[][];
	
	public static void main(String[] args) throws IOException {
		/*가치*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		knapsack = new int[N+1][K+1]; // 0부터 N,K까지 고려해서 +1 해줌
		items = new int[N+1][2]; // 0: 무게w, 1 : 가치v
		
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken()); // 무게
			int v = Integer.parseInt(st.nextToken()); // 가치
			
			/*0-1 Knapsack 알고리즘*/
			for (int j = 1; j < K+1; j++) {
				if(w>j) { //물건의 무게가 가방 용량보다 커서 담을 수 없는 경우
					knapsack[i][j] = knapsack[i-1][j];
				}else { // 담을 수 있는 경우
					//담는 경우와 담지 않는 경우 중 가치가 큰 값
					if(j-w>=0) { 
						knapsack[i][j] = Math.max(knapsack[i-1][j-w]+v, knapsack[i-1][j]);
					}else {
						knapsack[i][j] = knapsack[i-1][j];
					}
				}
			}
		}

		System.out.println(knapsack[N][K]);
	}

}
