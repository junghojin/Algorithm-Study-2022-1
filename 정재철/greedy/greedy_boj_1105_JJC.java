// greedy_boj_1105_JJC

import java.util.*;

public class greedy_boj_1105_JJC {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String L = sc.next();
		String R = sc.next();

		int result = 0;
		if(L.length() == R.length()){
			for(int i=0; i< L.length();i++){
				if(L.charAt(i) != R.charAt(i)){
					break;
				} 
				if(L.charAt(i)=='8'){
					result++;
				}
			}
		}
		System.out.println(result);
		sc.close();
	}
}
