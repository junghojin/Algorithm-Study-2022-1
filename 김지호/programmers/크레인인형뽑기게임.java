import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> s = new Stack<Integer>();
        
        for(int i=0; i<moves.length; i++){
            int idx = moves[i] - 1;
            
            for(int j=0; j<board.length; j++){
                if(board[j][idx] != 0){
                    if(s.isEmpty())
						s.push(board[j][idx]);
					else {
						if(s.peek() == board[j][idx]) {
							s.pop();
							answer += 2;
						}
						else {
							s.push(board[j][idx]);
						}
					}
					board[j][idx] = 0;
					break;
                }
            }
        }
        return answer;
    }
}