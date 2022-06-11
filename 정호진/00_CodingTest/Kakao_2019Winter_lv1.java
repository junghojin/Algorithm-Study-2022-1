import java.util.Stack;

// 22. 06. 10. 금 - 2019 카카오 겨울 인턴쉽 - Lv.1 - 크레인 인형뽑기 게임

public class Kakao_2019Winter_lv1 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}},
                new int[]{1, 5, 3, 5, 1, 2, 1, 4}));
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;

        int n = board.length;
        Stack<Integer> box = new Stack<Integer>();
        for (int i = 0, length = moves.length; i < length; i++) {
            int idx = moves[i] - 1;
            int item = 0;
            for (int d = 0; d < n; d++) {
                if (board[d][idx] != 0) {
//                    System.out.println("selected_item: " + board[d][idx]);
                    item = board[d][idx];
                    board[d][idx] = 0;
                    break;
                }
            }
            if (item != 0) {
                if (!box.isEmpty() && box.peek() == item) {
                    box.pop();
                    answer += 2;
                } else box.push(item);
            }
        }
        return answer;
    }

}
