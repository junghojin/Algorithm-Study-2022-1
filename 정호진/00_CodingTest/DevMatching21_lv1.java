// 22.06.04. - 2021 Dev-Matching: 웹 백엔드 개발자(상반기) - Lv.1 로또의 최고순위와 최저순위

import java.util.Arrays;

public class DevMatching21_lv1 {
    public static void main(String[] args) {
        int[] result = solution(new int[]{45, 4, 35, 20, 3, 9}, new int[]{20, 9, 3, 45, 4, 35});
    }

    public static int[] solution(int[] lottos, int[] win_nums) {

        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        int cnt=0;
        int zero_cnt = 0;
        for (int i = 0; i < 6; i++) {
            if(lottos[i] == 0) {
                zero_cnt++;
                continue;
            }
            for (int j = 0; j < 6; j++) {
               if(lottos[i] == win_nums[j]) cnt++;
            }
        }

        int[] answer = new int[]{rank(cnt+zero_cnt), rank(cnt)};

        return answer;
    }

    private static int rank(int cnt) {
        switch (cnt) {
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }
}
