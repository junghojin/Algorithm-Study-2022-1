import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 22.05.14. 토 - 백준 11404(골4) - 플로이드 

public class boj_11404 {
    public static void main(String[] args) throws Exception {

        final int INF = 9999999;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 도시의 개수
        int m = Integer.parseInt(br.readLine()); // 버스의 개수
        int costs[][] = new int[n+1][n+1]; // 도시에서 도시로의 최소 비용
        
        
        // 비용 초기화
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == j)
                    costs[i][j] = 0;
                else
                    costs[i][j] = INF;
            }
        }

        // 도시 사이 버스가 존재한다면 비용 초기화
        StringTokenizer stk = null;
        for(int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(stk.nextToken());
            int to = Integer.parseInt(stk.nextToken());
            int cost = Integer.parseInt(stk.nextToken());

            costs[from][to] = Math.min(costs[from][to], cost);
        }
        // ------------------- input end -----------------------

        // 모든 정점에서 다른 모든 정점으로까지의 최소 비용 - 플로이드 와샬 - 경출도 ( 경유지 - 출발 - 도착)
        for(int k = 1; k <= n; k++) { // 경유지
            for(int i = 1; i <= n; i++) { // 출발지
                if(i == k) continue;
                for(int j = 1; j <= n ; j++) { // 도착지
                    if(j == k || j == i) continue;
                    // 도시 사이의 비용보다 더 적은 금액의 비용이 존재할때
                    if(costs[i][j] > costs[i][k] + costs[k][j])
                        costs[i][j] = costs[i][k] + costs[k][j];
                }
            }
        }

        // 출력
        StringBuilder result = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(costs[i][j] >= INF) {
                    result.append("0 ");
                } else {
                    result.append(costs[i][j] + " ");
                }
            }
            result.append("\n");
        }
        System.out.print(result.toString());
    }
}
