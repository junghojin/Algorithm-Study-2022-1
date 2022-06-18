import java.util.Arrays;

public class programmers_77485 {
	
	public static void main(String[] args) {
		
		Solution sol = new Solution();
		int r = 6;
		int c = 6;
		
		int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		
		System.out.println(Arrays.toString(sol.solution(r,c, queries)));
	}
}

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
    	
        int[] answer = new int[queries.length];
        
        int[][] arr = new int[rows][columns];
        
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        
        // 배열 입력하기
        int num = 1;
        for(int i=0; i<rows; i++) {
        	for(int j=0; j<columns; j++) {
        		arr[i][j] = num++;
        	}
        }
        
        // 배열 돌리기
        for(int i=0; i<queries.length; i++) {
        	// 
        	int x1 = queries[i][0]-1;
        	int y1 = queries[i][1]-1;
        	int x2 = queries[i][2]-1;
        	int y2 = queries[i][3]-1;
        	
        	int x = x1;
        	int y = y1;
        	
        	int temp = arr[x][y];
        	int min = arr[x][y];
        	
        	int d=0;
        	while(d<4) {
        		
        		int X = x + dx[d];
        		int Y = y + dy[d];
        		
        		// 범위 안이면
        		if(X >= x1 && X <= x2 && Y >= y1 && Y <= y2) {
        			arr[x][y] = arr[X][Y];
        			min = Math.min(min, arr[X][Y]);
        			x = X;
            		y = Y;
        		} else d++;
        	}
        	
        	arr[x1][y1+1] = temp;
        	answer[i] = min;
        }
        return answer;
    }
}
