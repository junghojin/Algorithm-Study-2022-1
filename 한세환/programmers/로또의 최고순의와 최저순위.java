class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
    	//1.
        int cnt = 0;
        int zeroCnt = 0;
        for(int lotto: lottos){
        	//2. 
            if(lotto == 0) {
                zeroCnt ++;
                continue;
            }
            for(int win_num:win_nums){
            	//3.
                if(win_num == lotto){
                    cnt ++;
                    break;
                }
            }
        }
        //4.
        return new int[]{7-Math.max(cnt+zeroCnt,1),7-Math.max(cnt,1)};
    }
}