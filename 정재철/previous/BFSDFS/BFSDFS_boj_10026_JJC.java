// BFSDFS_boj_10026_JJC

import java.util.*;
import java.io.*;

public class BFSDFS_boj_10026_JJC {
    static int n;
    static char map[][], clone[][];
    static boolean visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new char[n][n];
        clone = new char[n][n];
        visited = new boolean[n][n];
       
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j]=='R'){
                    clone[i][j]='G';
                } else{
                    clone[i][j]=map[i][j];
                }
                
            }
        }
        int result1=0;
        int result2=0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(dfs(i, j, map[i][j],map)){
                    result1++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j]=false;
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(dfs(i, j, clone[i][j],clone)){
                    result2++;
                }
            }
        }
        
        System.out.println(result1+ " " + result2);

    }

    static boolean dfs(int x, int y, char c, char[][] arr) {
        if (x < 0 || x >= n || y < 0 || y >= n) {
            return false;
        }
        if(visited[x][y]==true){
            return false;
        }

        if (arr[x][y] == c) {
            visited[x][y]=true;
            arr[x][y] = ' ';
            dfs(x + 1, y, c,arr);
            dfs(x, y + 1, c,arr);
            dfs(x - 1, y, c,arr);
            dfs(x, y - 1, c,arr);
            return true;
        }
        return false;
    }
    

}