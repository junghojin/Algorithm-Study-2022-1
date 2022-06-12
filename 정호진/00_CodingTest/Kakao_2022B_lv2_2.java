// 22. 06. 11. 토 - 2022 카카오 블라인드 - Lv.2 - 양궁대회

public class Kakao_2022B_lv2 {
    public static void main(String[] args) {
        solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0});
    }

    public static int[] solution(int n, int[] info) {
        int[] answer = {};
        dfs(0, n, new int[11], info);
        answer = min_array;
        return answer;
    }


    static int[] min_array = {-1}; // 라이언이 쏜 화살의 합 중 라이언의 점수가 어피치 점수보다 낮거나 같으면 [-1]
    static int max_score = Integer.MIN_VALUE; // 라이언이 쏜 화살의 합 중 어피치 점수보다 높을 경우에만 갱신

    /**
     * 라이언이 어피치가 쏜 화살만큼 화살을 쏘고, 어피치보다 점수가 높은 경우들 중 가장 낮은 점수를 더 많이 맞힌 경우를 찾아낸다.
     *
     * @param level: 라이언이 쏜 화살의 개수
     * @param n: 어피치가 쏜 화살의 총 개수
     * @param scores: 라이언이 쏜 화살 정보를 보관하는 배열
     * @param info: 어피치가 쏜 화살 정보를 보관하는 배열
     */
    private static void dfs(int level, int n, int[] scores, int[] info) {
        if (level == n) {
            int total_score = 0;
            int opposite_score = 0;

            for (int i = 0; i <= 10; i++) {
                if (scores[i] > 0 || info[i] > 0) {
                    if (scores[i] > info[i]) total_score += 10 - i;
                    else opposite_score += 10 - i;
                }
            }

            if (total_score > opposite_score && total_score - opposite_score >= max_score) {
                // 가장 낮은 점수를 더 많이 맞힌 경우를 min_array에 넣기
                max_score = total_score - opposite_score;
                min_array = scores.clone();
            }
            return;
        }

        for (int i = 0; i <= 10; i++) {
            if(scores[i] > info[i]) break;

            scores[i]++;
            dfs(level + 1, n, scores, info);
            scores[i]--;
        }
    }
}
