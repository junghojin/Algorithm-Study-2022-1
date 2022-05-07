import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * BOJ_12865 : 평범한배낭
 * 가방에 담을 수 있는 무게를 고려했을 때, 가방에 담긴 물건들의 최고의 가치를 구해야 하는 문제
 * 시간복잡도 : O(NXW)
 */

public class BOJ_12865_평범한배낭 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 물품 개수
		int K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게
		
		int[][] arr = new int[N+1][2]; // arr[i][0] : 무게, arr[i][1] : 가치
		int[][] dp = new int[N+1][K+1]; // 메모제이션할 배열
		
		// 무게와 가치 입력받기
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 1번. 우선 무게 w에서 이전 물건(i-1번 item)을 넣었을 때의 최대 가치 값을 그대로 가져온다. (dp[i - 1][k])
		// 2번. 그리고 무게 w에서 지금 물건(i번째 item)을 넣을 수 있다면(i번째 item의 무게가 w보다 작거나 같을 경우)
		// 3번. 짐을 더 넣을 수 있는지를 확인해서 합한 값이 더 가치가 크다면 갱신해준다.
		
		for (int k = 1; k <= K; k++) { // 무게
            for (int i = 1; i <= N; i++) { // item
                dp[i][k] = dp[i - 1][k]; // 1번
                if (k - arr[i][0] >= 0) { // 2번
                    dp[i][k] = Math.max(dp[i - 1][k], arr[i][1] + dp[i - 1][k - arr[i][0]]); // 3번
                }
            }
        }
		
		// 물건들의 가치합의 최대값 출력
		System.out.println(dp[N][K]);
		
	}

}
