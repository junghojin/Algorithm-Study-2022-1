// BOJ_17143_낚시왕
// 시간 복잡도 : O(C*M*s) - 열의수 만큼반복,M개의 상어들, s번이동
// moveShark에서 s번 이동 후 좌표를 점화식으로 구한다면 시갑 복잡도는 O(C*M)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17143 {
    static int R, C, M, score;
    static List<Shark> sharks;
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, 1, -1};
    static class Shark implements Comparable<Shark> {
        int r, c, s, d, z;
        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
        @Override
        public int compareTo(Shark o) {
            if (this.c == o.c) {
                return this.r - o.r;
            } else {
                return this.c - o.c;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        /* ==========input========== */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sharks = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            sharks.add(new Shark(r, c, s, d, z));
        }
        /* ==========sol========== */
        score = 0;
        for (int i = 1; i <= C; i++) { // 열의 크기만큼 반복
            removeShark(i);
            moveShark();
            eatShark();
        }
        /* ==========output========== */
        System.out.println(score);
        br.close();
    }

    static void removeShark(int col) {
        Collections.sort(sharks); // 상어를 열순으로 정렬하고 열이같으면 행순으로 정렬한다.
        for (int i = 0; i < sharks.size(); i++) {
            if (sharks.get(i).c == col) { // 낙시꾼의 열에 있는 상어중 가장 먼저 잡이는 상어를 삭제
                score += sharks.get(i).z; // 삭제한 상어의 크기만큼 결과값 증가
                sharks.remove(i);
                return;
            }
        }
    }

    static void moveShark() {
        for (Shark temp : sharks) { // sharks에 있는 상어들의 정보를 차례대로 받아온다.
            int row = temp.r;
            int col = temp.c;
            int num = temp.s;
            int dir = temp.d;
            for (int j = 0; j < num; j++) { // 상어의 속도만큼 한칸씩 이동을 반복한다.
                row += dx[dir];
                col += dy[dir];
                if (row < 1 || row > R || col < 1 || col > C) { // 벽에 부딛히면 반대 방향으로 이동시키고 방향도 바꾸어준다.
                    if (dir == 1) dir = 2;
                    else if (dir == 2) dir = 1;
                    else if (dir == 3) dir = 4;
                    else if (dir == 4) dir = 3;
                    row += dx[dir] * 2;
                    col += dy[dir] * 2;
                }
            }
            temp.r = row; //이동이 끝나면 해당 상어의 좌표와 방향을 변경해준다.
            temp.c = col;
            temp.d = dir;
        }
    }

    static void eatShark() {
        int size =sharks.size();
        if(size==0) return; // 상어가 없다면 즉시 반환
        Collections.sort(sharks); //열, 행으로 상어 정렬
        Shark pre = sharks.get(size-1); // remove하면 인덱스 문제가 발생하여 마지막 번호 상어부터 확인
        for(int i=size-2;i>=0;i--){
            Shark now = sharks.get(i);
            if(pre.r==now.r&&pre.c==now.c){ // 비교하는 상어의 좌표가 같으면 한마리를 삭제
                if(pre.z>now.z){
                    sharks.remove(now);
                }else {
                    sharks.remove(pre);
                    pre =now; // now가 살아남았으므로 다음 상어 비교에서는 now와 비교
                }
            }else
                pre =now;
        }
    }
}
