
public class 음양더하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] absolutes = {4,7,12};
		boolean[] signs = {true,false,true};
		solution(absolutes, signs);
	}
	public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0; i < signs.length; i++) {
        	if(!signs[i]) {
        		absolutes[i]*=-1;
        	}
			answer += absolutes[i];
		}
        return answer;
    }
}
