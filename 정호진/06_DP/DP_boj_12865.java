import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class DP_boj_12865 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 물품의 수
        int K = sc.nextInt(); // 준서가 버틸 수 있는 무게
        int dp[][] = new int[N+1][K+1]; // 무게 K 까지 물품으로 만들 수 있는 가치

        int items[][] = new int[N+1][2]; // [][0]: 물건의 무게 / [][1]: 물건의 가치
        for(int n = 1; n <= N; n++) {
            items[n][0] = sc.nextInt();
            items[n][1] = sc.nextInt();
        }
        // ------------------------ input end -------------------------

        // dp 1단계: 오름차순 정렬
        Arrays.sort(items, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // dp 2단계: dp 배열 채우기
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= K; j++) {
                int weight = items[i][0];
                int value = items[i][1];

                // j의 무게가 물품의 무게보다 무거운 경우 물품을 담을 수 없다.
                if(weight > j) {
                    dp[i][j] = dp[i-1][j];
                } else { // 물품을 담을 수 있는 경우
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight] + value);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
