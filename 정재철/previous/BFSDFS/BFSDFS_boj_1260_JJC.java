// BFSDFS_boj_1260_JJC

import java.util.*;
import java.io.*;

public class BFSDFS_boj_1260_JJC {
    static int[][] map; // 정점의 인접리스트
    static int[] visited; //방문을 한 정점
    static int n, m, v;

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        v=Integer.parseInt(st.nextToken());
        map = new int[n+1][n+1];
        visited = new int[n+1];
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int x =Integer.parseInt(st.nextToken());
            int y =Integer.parseInt(st.nextToken());
            map[x][y]=1; // 정점이 서로 연결되있으면.
            map[y][x]=1; // 간선의 방향이 없으므로 
        }

        dfs(v); //dfs실행
        for(int i=0;i<=n;i++){ // bfs함수를 사용하기위해 visited 초기화
            visited[i]=0;
        }
        System.out.println();
        bfs(v);//bfs실행

        br.close();
    }

    static void dfs(int start){
        visited[start] = 1; // start 정점을 탐색 하였으므로 1로 변경 후 출력
        System.out.print(start+ " "); 
        for(int i=0;i<n+1;i++){
            if(map[start][i]==1&&visited[i]==0){
                dfs(i);
            }
        }
    }

    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);
        visited[start]=1;
        while(!queue.isEmpty()){
            int x = queue.poll();
            System.out.print(x + " ");
            for(int i=0;i<n+1;i++){
                if(map[x][i]==1&&visited[i]==0){
                    queue.offer(i);
                    visited[i]=1;
                }
            }
        }

    }
    
}