
// 22.06.18 - 2021 Dev-Matching: 웹 백엔드 개발자(상반기) - 행렬 테두리 회전하기

class DevMatching21_lv2 {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int[] dr = {0, 1, 0, -1}; // 우 하 좌 상 순
        int[] dc = {1, 0, -1, 0};
        
        // 1. 지도에 값 넣어주기
        int[][] map = new int[rows+1][columns+1];
        int value = 1;
        for(int i = 1; i <= rows; i++) {
            for(int j = 1; j <= columns; j++) {
                map[i][j] = value++;
            }
        }
        
        // 2. 쿼리문 차례대로 실행시키기 (숫자 이동)
        int[][] copied_map = mapCopy(map, rows, columns);
        for(int i = 0, length = queries.length; i < length; i++) {
            
            int r_range = queries[i][2]-queries[i][0];
            int c_range = queries[i][3]-queries[i][1];
            int r = queries[i][0], c = queries[i][1];
            int nr = 0, nc = 0;
            int min = Integer.MAX_VALUE;
            // 우
            for(int j = 0; j < c_range; j++) {
                nr = r + dr[0];
                nc = c + dc[0];
                copied_map[nr][nc] = map[r][c];
                r = nr; c = nc;
                min = map[r][c] < min ? map[r][c] : min;
            }
            
            // 하
            for(int j = 0; j < r_range; j++) {
                nr = r + dr[1];
                nc = c + dc[1];
                copied_map[nr][nc] = map[r][c];
                r = nr; c = nc;
                min = map[r][c] < min ? map[r][c] : min;
            }
            
            // 좌
            for(int j = 0; j < c_range; j++) {
                nr = r + dr[2];
                nc = c + dc[2];
                copied_map[nr][nc] = map[r][c];
                r = nr; c = nc;
                min = map[r][c] < min ? map[r][c] : min;
            }
            
            // 상
            for(int j = 0; j < r_range; j++) {
                nr = r + dr[3];
                nc = c + dc[3];
                copied_map[nr][nc] = map[r][c];
                r = nr; c = nc;
                min = map[r][c] < min ? map[r][c] : min;
            }
            
            map = mapCopy(copied_map, rows, columns);
            answer[i] = min;
        }
        
        return answer;
    }
    
    // 지도 복사
    private int[][] mapCopy(int[][] map, int rows, int columns) {
        int[][] copied_map = new int[rows+1][columns+1];
        for(int r = 1; r <= rows; r++) {
            for(int c = 1; c <= columns; c++) {
                copied_map[r][c] = map[r][c];
            }
        }
        return copied_map;
    }
}
