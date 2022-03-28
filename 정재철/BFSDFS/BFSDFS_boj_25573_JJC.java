// BFSDFS_boj_25573_JJC

import java.util.*;
import java.io.*;

public class BFSDFS_boj_25573_JJC {
    static int n, m, count, result;
    static int[][] map, meltIce;
    static boolean[][] visited, copy;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        meltIce = new int[n][m];
        visited = new boolean[n][m];
        copy = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    visited[i][j] = true;
                }

            }
        } // 입력 끝

        result = 0;
        while (true) {
            count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }
            
            // for (int i = 0; i < n; i++) { // 배열상태확인
            //     for (int j = 0; j < m; j++) {
            //         System.out.print(map[i][j] + " ");
            //     }
            //     System.out.println();
            // }

            if (count >= 2) { //
                break;
            }

            boolean exist = false; // 빙하가 남아있는지 확인한다
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] != 0) {
                        exist = true;
                    }
                }
            }
            
            if (!exist) { // 남아있는 빙하가 없다면 0출력후 종료
                System.out.println(0);
                System.exit(0);
            }

            melt();
            for (int i = 0; i < n; i++) { // 남아있는 빙하를 확인하여 visited 초기화, meltIce 초기화
                for (int j = 0; j < m; j++) {
                    meltIce[i][j] = 0;
                    if (map[i][j] != 0) {
                        visited[i][j] = false;
                    }
                }
            }
            result++;
        }
        System.out.println(result); // 출력 끝

        br.close();
    }

    static void melt() { // 0과 인접한 빙하를 확인하여 한번에 녹여준다
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    for (int dir = 0; dir < 4; dir++) {
                        int row = i + dx[dir];
                        int col = j + dy[dir];
                        if (row < 0 || row >= n || col < 0 || col >= m)
                            continue;
                        if (map[row][col] != 0) {
                            meltIce[row][col]++;
                        }

                    }
                }

            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (meltIce[i][j] != 0) {
                    map[i][j] = (map[i][j] - meltIce[i][j]) >= 0 ? map[i][j] - meltIce[i][j] : 0;
                }
            }
        }

    }

    static void bfs(int x, int y) { // bfs를 통해 인접한 빙하들을 확인
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(new Node(x, y));
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            for (int dir = 0; dir < 4; dir++) {
                int row = temp.x + dx[dir];
                int col = temp.y + dy[dir];
                if (row < 0 || row >= n || col < 0 || col >= m || visited[row][col])
                    continue;
                visited[row][col] = true;
                queue.offer(new Node(row, col));
            }
        }
    }

}