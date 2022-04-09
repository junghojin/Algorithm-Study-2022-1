package Implement;

import java.io.*;
import java.util.*;

public class Solution_2112 {
    static int tc,d,w,k;
    static int min;
    static int map[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        tc = Integer.parseInt(br.readLine());

        for(int t=1 ; t<=tc; t++){
            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            map = new int[d][w];

            for(int i=0; i<d; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dfs(0,0);

            System.out.println("#"+tc+" "+min);
        }

    }

    private static void dfs(int k, int cnt) {
        if (cnt >= min) //
            return;

        if (k == d) {
            loop: for (int i = 0; i < w; i++) {
                int same = 1;
                for (int j = 0; j < d - 1; j++) {
                    if (map[j][i] == map[j + 1][i]) {
                        same++;
                    } else {
                        same = 1;
                    }

                    if (same >= k) {
                        continue loop;// same == K를 한번이라도 발견하면 다음 열 검사
                    }
                }
                return;// 다 돌았는데 same == K 였던 적이 없는 열이 있다면 불합격
            }
            min = Math.min(min, cnt);
            return;
        }

        int[] tmp = map[k].clone();

        // 투입 안하기
        dfs(k + 1, cnt);

        // A 약품 투입
        Arrays.fill(map[k], 0);
        dfs(k + 1, cnt + 1);

        // B 약품 투입
        Arrays.fill(map[k], 1);
        dfs(k + 1, cnt + 1);

        map[k] = tmp;
    }
}
