// Programmers_64061_2019 카카오 개발자 인턴십_크레인 인형뽑기 게임

import java.util.Stack;

public class Programmers_64061 {
    public static void main(String[] args){
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        Solution sol = new Solution();
        System.out.println(sol.solution(board, moves));
    }
    static class Solution {
        public int solution(int[][] board, int[] moves) {
            int answer = 0;
            Stack<Integer> stack = new Stack<>();
            for(int move:moves){
                int h=0;
                while (h<board.length){
                    if(board[h][move-1]!=0){
                        if(!stack.isEmpty()&&stack.peek()==board[h][move-1]){
                            stack.pop();
                            answer+=2;
                        }else {
                            stack.push(board[h][move-1]);
                        }
                        board[h][move-1]=0;
                        break;
                    }
                    h++;
                }
            }
            return answer;
        }
    }
}

