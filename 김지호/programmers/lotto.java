class Solution {
	
    public int[] solution(int[] lottos, int[] win_nums) {
        
        int cnt = 0;
        int zero_cnt = 0;
        // win_nums에 포함하는 lottos 개수 세기
        for(int i=0; i<6; i++){
            if(lottos[i]==0) {
                zero_cnt++;
                continue;
            }
            for(int j=0; j<6; j++){
                if(lottos[i]==win_nums[j]){
                    cnt++;
                    break;
                }
            }
        }
        
        int[] win = {6,6,5,4,3,2,1};
        
        int high = win[cnt+zero_cnt];
        int low = win[cnt];
        
        int[] answer = {high, low};
        
        return answer;
    }
}