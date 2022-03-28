// BFSDFS_boj_6593_JJC

import java.util.*;
import java.io.*;

public class BFSDFS_boj_6593_JJC {
    static int L, R, C, result;
    static int exitL, exitR, exitC; // 출구의 좌표
    static int[][][] map; // 상범 빌딩의 상태
    static boolean[][][] visited;
    static Room startRoom; 

    static int[] dz = { 0, 0, 0, 0, 1, -1 };
    static int[] dx = { 0, 0, 1, -1, 0, 0 };
    static int[] dy = { 1, -1, 0, 0, 0, 0 };

    static class Room { // 탐색할 방의 클래스로 구현 
        int z, x, y; // z는 층, x는 세로, y는 가로의 좌표

        Room(int z, int x, int y) {
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {


            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if (L == 0 && R == 0 && C == 0)
                break;
            map = new int[L][R][C];
            visited = new boolean[L][R][C];
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String str = br.readLine();
                    for (int k = 0; k < C; k++) {
                        char temp = str.charAt(k);
                        if (temp != '#') { // '#'이 아니면 지나갈 수 있는 방이다.
                            map[i][j][k] = 1;
                            if (temp == 'S') { // 'S'이면 시작방으로 설정한다.
                                startRoom = new Room(i, j, k);
                            } else if (temp == 'E') { // 'E'이면 출구의 좌표를 저장한다.
                                exitL = i;
                                exitR = j;
                                exitC = k;
                            }
                        } 
                    }
                }
                br.readLine();
            } // 입력 끝

            
            bfs(startRoom); // // 시작하는 방을 시작으로 탐색을 시작한다.

            // for (int i = 0; i < L; i++) { // map 상태 출력
            //     for (int j = 0; j < R; j++) {
            //         System.out.println();
            //         for (int k = 0; k < C; k++) {
            //             System.out.print(map[i][j][k]+" ");
            //         }
            //     }
            //     System.out.println();
            // }

            int result =  map[exitL][exitR][exitC]-1; // 처음 방의 map 값이 1이였으므로 1을 뺴준다.
            if(result!=0){ // 출구를 찾은경우
                System.out.println("Escaped in "+ result+" minute(s).");
            } else{ // 출구를 못찾은 경우
                System.out.println("Trapped!");
            }// 출력 끝
        }
        br.close();
    }

    public static void bfs(Room room) { // 시작하는 방을 받아온다.
        Queue<Room> queue = new LinkedList<Room>();
        queue.offer(room);
        visited[room.z][room.x][room.y] = true;

        while (!queue.isEmpty()) {
            Room temp = queue.poll();
            int z = temp.z;
            int x = temp.x;
            int y = temp.y;
            if (z == exitL && x == exitR && y == exitC) // 목적지인 출구에 도착했다면 반복문을 탈출하여 bfs를 마친다.
                break; 
            for (int dir = 0; dir < 6; dir++) {
                int nextZ = z + dz[dir];
                int nextX = x + dx[dir];
                int nextY = y + dy[dir];
                if (nextZ < 0 || nextZ >= L || nextX < 0 || nextX >= R || nextY < 0 || nextY >= C
                        || visited[nextZ][nextX][nextY]) // 범위를 초가하거나 방문을 했으면 다음 반복 실행
                    continue;

                if (map[nextZ][nextX][nextY] == 1) {
                    visited[nextZ][nextX][nextY] = true;
                    map[nextZ][nextX][nextY] = map[z][x][y] + 1; // 한칸이동한 것으로 아전칸의 값보다 1증가
                    queue.offer(new Room(nextZ, nextX, nextY)); // 큐에추가
                }
            }

        }
    }

}