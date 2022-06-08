import java.util.*;
// 5x5<= board <= 30x30
// 0<= 인형 종류 <=100
// 1<= moves 배열 크기 <=1000

// 바구니 비어있지 않았으면 위를 탐색하고 넣기 
	//맨위 a 빼서 같으면 a 빼기 + (answer 값 +2)
	//맨위 a 빼서 다르면 b 넣기
// 바구니 비어있으면 그냥 넣기 

public class 크레인인형뽑기게임 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] b = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int [] m = {1,5,3,5,1,2,1,4};
		solution(b, m);
	}


	public static int solution(int[][] board, int[] moves) {
	        int answer = 0;
	        int N = board.length;
	        Stack<Integer> basket = new Stack<>();
	        
	        // moves에서 하나씩 빼서 stack 에 넣기
	        for (int j : moves) {
	        	j = j-1;
	        	for (int i = 0; i < N; i++) { // board의 세로방향으로
					if(board[i][j] !=0) { // 0이 아닌 인형이 있을 때까지 탐색
						// 바구니에서 처리하기 
						if(!basket.empty()) { // 바구니가 비어있지 않다면 
							if(basket.peek() == board[i][j]) { // 맨 위의 것과 같으면
								basket.pop(); // 바구니에서 빼버리기 
								answer += 2; // 없어진 인형을 2개 다 세줘야하므로 +2 
							}else { // 맨위의 것과 같지 않으면 
								basket.push(board[i][j]);
							}
						}else { // 바구니가 비어있으면 
							basket.push(board[i][j]); // 인형 넣기
						}
						
						board[i][j]=0; // 0으로 빈칸 만들기
						break;
					}
				}
			}
	        
	        return answer;
	 }
	
}



