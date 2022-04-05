// BOJ_2665

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_13424 {
    static final int INF = (int) 1e9;
    static int T, N, M, K;
    static int[] entry;
    static int[][] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 정점의 수
            M = Integer.parseInt(st.nextToken()); // 간선의 수
            d = new int[N + 1][N + 1]; // 정점간의 최소 거리를 나타낼 배열
            for (int i = 0; i <= N; i++) {
                Arrays.fill(d[i], INF); // 모든 정점과의 거리를 무한으로 설정
                d[i][i] = 0; // 자기자신과의 거리는 0
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()); // 출발점
                int b = Integer.parseInt(st.nextToken()); // 도착점
                int c = Integer.parseInt(st.nextToken()); // 거리
                d[a][b] = c;
                d[b][a] = c;
            }
            K = Integer.parseInt(br.readLine()); // 모임을 할 학생수
            entry = new int[K]; // 학생들의 위치 정보
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                entry[i] = Integer.parseInt(st.nextToken());
            }

            for (int k = 1; k <= N; k++) // 플로이드 워셜 알고리즘을 이용하여 정점간의 최소 거리를 구한다.
                for (int i = 1; i <= N; i++)
                    for (int j = 1; j <= N; j++)
                        d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
            int min = Integer.MAX_VALUE;
            int result = -1;
            for (int i = 1; i <= N; i++) {
                int sum = 0;
                for (int j = 0; j < K; j++)
                    sum += d[entry[j]][i]; // i 정점을 기준으로 학생들의 거리를 더해준다.
                if (sum < min) { // sum이 최솟값이면 그 값과 인덱스를 저장한다.
                    min = sum;
                    result = i;
                }
            }
            System.out.println(result);
        }
        br.close();
    }
}