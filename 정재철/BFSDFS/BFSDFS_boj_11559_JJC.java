// BFSDFS_boj_11559_JJC

import java.util.*;
import java.io.*;

public class BFSDFS_boj_11559_JJC {
    static int H = 12; // 필드 세로
    static int W = 6; // 필드 가로
    static int count; // 같은색의 모여있는 뿌요들의 개수
    static char map[][]; // 필드를 표현한 배열
    static boolean visited[][]; // bfs시 탐색을 한 곳을 표시
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    static class Puyo { // 필드상 하나의 블뿌요 표현
        int x;
        int y;

        public Puyo(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[H][W];
        visited = new boolean[H][W];
        for (int i = 0; i < H; i++) {
            String str = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = str.charAt(j);
            }
        } // 입력 끝

        int result = 0; // 연쇄횟수
        boolean clear = true; // 뿌요들이 터지는 경우
        while (clear) {
            clear = false;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < 6; j++) {
                    if (map[i][j] != '.' && map[i][j] != 'X' && !visited[i][j]) {
                        char temp = map[i][j]; // 복원시 필요한 문자
                        count = 1;
                        bfs(i, j, temp); // 같은색의 모여있는 뿌요들의 개수를 세고 모여있는 뿌요들을 'X'로 치환
                        if (count >= 4) { // 같은색의 모여있는 뿌요들이 4개 이상이면 붙어있는 블럭들 삭제
                            clear = true; // 뿌요들이 터졌으므로 true로 변경
                            for (int r = 0; r < H; r++) {
                                for (int c = 0; c < 6; c++) {
                                    if (map[r][c] == 'X') {
                                        map[r][c] = '.';
                                    }
                                }
                            }
                        } else { // 같은색의 모여있는 뿌요들이 4개 미만이면 이전 상태 복원
                            for (int r = 0; r < H; r++) {
                                for (int c = 0; c < 6; c++) {
                                    if (map[r][c] == 'X') {
                                        map[r][c] = temp;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (!clear) { // 뿌요들이 더이상 터지지 않으므로 반복문을 빠져나온다.
                break;
            }
            result++;

            gravity(); // 블럭이 삭제 되었으면 블럭을 아래로 정렬시킨다.

            for (int i = 0; i < H; i++) { // 새로 정렬된 필드상에서 탐색을 수행하므로 false로 초기한다.
                for (int j = 0; j < W; j++) {
                    visited[i][j] = false;

                }
            }

            // for (int i = 0; i < H; i++) { // 블럭상태 확인
            // for (int j = 0; j < 6; j++) {
            // System.out.print(map[i][j]);
            // }
            // System.out.println();
            // }
            // System.out.println();

        }

        System.out.println(result); // 출력 끝

    }

    static void bfs(int x, int y, char c) { // 같은색의 모여있는 뿌요들의 개수를 세고 모여있는 뿌요들을 'X'로 치환
        Queue<Puyo> queue = new LinkedList<Puyo>();
        queue.offer(new Puyo(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Puyo puyo = queue.poll();
            x = puyo.x;
            y = puyo.y;
            map[x][y] = 'X';

            for (int dir = 0; dir < 4; dir++) {
                int row = x + dx[dir];
                int col = y + dy[dir];
                if (row < 0 || row >= H || col < 0 || col >= W || visited[row][col])
                    continue;
                if (map[row][col] == c) { // 탐색중인 뿌요와이면 개수를 증가하고 'X'로 치환후 다음 탐색을 위해 큐에 넣어준다
                    map[x][y] = 'X';
                    count++;
                    visited[row][col] = true;
                    queue.add(new Puyo(row, col));
                }
            }
        }
    }

    static void gravity() { // 블럭을 아래로 이동
        for (int i = 0; i < W; i++) {
            List<Character> list = new ArrayList<Character>();
            for (int j = H - 1; j >= 0; j--) {// 필드를 세로로 한줄을 아래에서 위로 뿌요들의 색을 리스트에 삽입한다.
                if (map[j][i] != '.')
                    list.add(new Character(map[j][i]));
            }
            int index = 0;

            for (int j = H - 1; j >= 0; j--) { // 필드 아래부터 삽입되있는 뿌요들을 필드에 표시후 더이상 뿌요가 없으면 '.'표시
                if (index < list.size()) { //
                    map[j][i] = list.get(index);
                    index++;
                } else {
                    map[j][i] = '.';
                }
            }
        }
    }
}