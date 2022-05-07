// BOJ_12865_평범한 배낭
// 시간 복잡도 : O(NK)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_12865 {
    public static void main(String[] args) throws IOException {
        /* ==========input========== */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] W = new int[N+1];
        int[] V = new int[N+1];
        int[][] dp = new int[N+1][K+1];
        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            W[i]=Integer.parseInt(st.nextToken());
            V[i]=Integer.parseInt(st.nextToken());
        }
        /* ==========sol========== */
        for(int i=1;i<=N;i++){
            for(int j=1;j<=K;j++){ // 버틸 수 있는 무게를 1부터 k로 증가해보면서 최댓값을 구한다.
                if(W[i]>j){ // 버틸 수 있는 무게를 초과하면 직전 상태를 가지고 간다.
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-W[i]]+V[i]); // 직전상태보다 해당 물품을 담고 남은 무게에서 해당 제품의 가치를 더한 가치를 비교한다.
                }
            }
        }
        /* ==========output========== */
        System.out.println(dp[N][K]);
        br.close();
    }
}