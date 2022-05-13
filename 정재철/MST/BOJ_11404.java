// BOJ_11404_플로이드

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11404 {
    static final int INF=(int)1e9;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] graph = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            Arrays.fill(graph[i],INF);
        }
        for(int i=1;i<=n;i++){
            graph[i][i]=0;
        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int start =Integer.parseInt(st.nextToken());
            int end =Integer.parseInt(st.nextToken());
            int cost =Integer.parseInt(st.nextToken());
            graph[start][end]=Math.min(graph[start][end],cost); // 두 도시를 오가는 버스가 여러개이면 가장 작은 비용사용
        }
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    graph[i][j]=Math.min(graph[i][j],graph[i][k]+graph[k][j]); // i에서 j가는 것보다 k를 경유해가는 경우가 더 작으면 갱신한다.
                }
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(graph[i][j]==INF){ // 갈 수 없는 도시는 0으로 출력
                    System.out.print(0+" ");
                }else {
                    System.out.print(graph[i][j]+" ");
                }
            }
            System.out.println();
        }
        br.close();
    }
}