// BOJ_2665

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2665 {
    static final int INF = (int)1e9;
    static int n;
    static int[][] map,d;
    static int[] dx= {-1,0,1,0};
    static int[] dy= {0,1,0,-1};

    static class Node{
        int x,y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        d = new int[n][n];
        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<n;j++){
                map[i][j] =str.charAt(j)-'0';
            }
        }
        for(int i=0;i<n;i++){
            Arrays.fill(d[i],INF);
        }

        bfs();
        System.out.println(d[n-1][n-1]);

        br.close();
    }
    static void bfs(){
        Queue<Node> queue = new LinkedList();
        queue.add(new Node(0,0));
        d[0][0]=0;
        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(int dir=0;dir<4;dir++){
                int row= node.x + dx[dir];
                int col= node.y + dy[dir];
                if(row<0||row>=n||col<0||col>=n) continue;
                if(d[node.x][node.y]<d[row][col]){
                    if(map[row][col]==1)
                        d[row][col]=d[node.x][node.y];
                    else {
                        d[row][col]=d[node.x][node.y]+1;
                    }
                    queue.add(new Node(row,col));
                }
            }
        }
    }
}