class Solution {
    public String solution(int[] numbers, String hand) {
    	
        String answer = "";
        
        String left = "10"; // *
        String right = "12"; // #
        
        for(int i=0; i<numbers.length; i++) {
        	String[] str = press(numbers[i], hand, left, right);
        	answer += str[0];
        	left = str[1];
        	right = str[2];
        }
        
        return answer;
    }
    
	private String[] press(int i, String hand, String left, String right) {
		
		String[] str = new String[3];
		
		if(i == 1 || i== 4 || i == 7) {
			str[0] = "L";
			str[1] = Integer.toString(i);
			str[2] = right;
			
		} else if(i == 3 || i== 6 || i == 9) {
			str[0] = "R";
			str[1] = left;
			str[2] = Integer.toString(i);
			
		} else {
			if(i==0) i=11;
			
			int numL = Integer.parseInt(left);
			int numR = Integer.parseInt(right);

			// 왼손, 오른손 각각 거리 구하기
			int left_num = Math.abs(numL-i)/3 + Math.abs(numL-i)%3;			
			int right_num = Math.abs(numR-i)/3 + Math.abs(numR-i)%3;

			// 왼손과 가까울 떄
			if(left_num<right_num) {
				str[0] = "L";
				str[1] = Integer.toString(i);
				str[2] = right;
			
			// 오른손과 가까울 때
			} else if(left_num>right_num) {
				str[0] = "R";
				str[1] = left;
				str[2] = Integer.toString(i);
			
			//거리가 똑같을 때 무슨 손잡이인지에 따라서
			} else {
				if(hand.equals("right")) {
					str[0] = "R";
					str[1] = left;
					str[2] = Integer.toString(i);
				}else {
					str[0] = "L";
					str[1] = Integer.toString(i);
					str[2] = right;
				}
			}
		}
		
		return str;
	}
}
