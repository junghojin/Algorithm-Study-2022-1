// Programmers_77485_2021 Dev-Matching: 웹 백엔드 개발자 (상반기)_행렬 테두리 회전하기

import java.util.Arrays;

public class Programmers_77485 {
    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(rows,columns, queries)));
    }

    static public class Solution {
        int[] dx ={1,0,-1,0};
        int[] dy ={0,1,0,-1};
        public int[] solution(int rows, int columns, int[][] queries) {
            int[] answer = new int [queries.length];
            int[][] map = new int[rows+1][columns+1];
            int count=1;
            for(int i=1;i<=rows;i++){
                for(int j=1;j<=columns;j++){
                    map[i][j]=count++; // 외쪽 상단부터 1씩 증가해주며 값을 넣어준다.
                }
            }
            for(int t=0;t<queries.length;t++){
                int x1 =queries[t][0];
                int y1 =queries[t][1];
                int x2 =queries[t][2];
                int y2 =queries[t][3];
                int row = x1; // 초기 커서의 행
                int col = y1; // 초기 커서의 행
                int dir = 0; // 초기 커서 가장 먼저 아래로 이동을 한다.
                int first = map[x1][y1]; // 가장 왼쪽 상단의 수를 저장한다.
                int min = map[x1][y1];
                while (true){
                    int r = row + dx[dir];
                    int c = col + dy[dir];
                    if(r==x1&&c==y1) break;
                    if(r >=x1&&r<=x2&&c>=y1&&c<=y2){ // 범위 안이라면
                        min=Math.min(min,map[r][c]); // 값을 비교해주며 최속값을 구해준다.
                        map[row][col]=map[r][c]; // 이전위치 현재위치의 값을 넣어준다.
                        row=r; //다음 칸을 탐색하기위해 위치를 변경한다.
                        col=c;
                    }else { // 범위를 벋어나면 방향을 바꾸어준다.
                        dir++;
                    }
                }
                map[x1][y1+1]=first; // 저장해 놨던 수를 한칸 오른쪽 칸에 넣어준다.
//                for(int i=1;i<=rows;i++){
//                    for(int j=1;j<=columns;j++){
//                        System.out.print(map[i][j]+"\t");
//                    }
//                    System.out.println();
//                }
//                System.out.println();
                answer[t]=min;
            }
            return answer;
        }
    }
}