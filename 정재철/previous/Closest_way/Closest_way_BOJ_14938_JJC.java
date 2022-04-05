// BOJ_14938

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14938 {
    static final int INF = (int) 1e9;
    static int n, m, r;
    static int[] t;
    static int[][] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        t = new int[n + 1];
        d = new int[n + 1][n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            t[i] = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++) {
            Arrays.fill(d[i], INF);
            d[i][i] = 0;
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            d[a][b] = c;
            d[b][a] = c;
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    d[i][j] = Math.min(d[i][j],d[i][k] + d[k][j]);
                }
            }
        }
        int result=0;
        for (int i = 1; i <= n; i++) {
            int sum=0;
            for (int j = 1; j <= n; j++) {
                if(d[i][j]<=m){
                    sum+=t[j];
                }
            }
            result =Math.max(result, sum);
        }

        System.out.println(result);


        br.close();
    }
}