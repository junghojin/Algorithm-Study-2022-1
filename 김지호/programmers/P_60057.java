class P_60057 {

	public static void main(String[] args) {
		Solution1 sol = new Solution1();
		String str = "ababcdcdababcdcd";
		
		System.out.println(sol.solution(str));
	}
}

class Solution1 {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        
        if(s.length()==1) return 1;
        else {
            for(int i=s.length()/2; i>0; i--) {
            	answer = Math.min(answer, len(s, i));
            }
        }
        return answer;
    }

	private int len(String s, int i) {
		
		String str = "";
		
		int start = 0;
		int end = i;
		
		while(end-1 < s.length()) {

			String substr = s.substring(start, end);
			int cnt = 1;
			
			while(end+i <= s.length()) {
				
				if(substr.equals(s.substring(start+i, end+i))) {
					start += i;
					end += i;
					cnt++;
				} else break;
			}
			
			if(cnt<2) str += substr;
			else str += Integer.toString(cnt) + substr;
			
			start += i;
			end += i;
		}
		str += s.substring(start);
		
		return str.length();
	}
}