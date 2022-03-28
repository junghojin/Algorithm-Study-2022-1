package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class implementation_boj_1213_LJE {
	static String inputStr;
	static int [] alphaArr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		inputStr = br.readLine(); 
		alphaArr = new int[26];
		String ans ="";
		String mid ="";
		for(int i=0;i<inputStr.length();i++) {
			alphaArr[inputStr.charAt(i) -'A']++;
		}
		
		if(possible()) {
			for(int i=0;i<26;i++) {
				if(alphaArr[i]% 2 != 0) {
					//ans += (char)(i +'A') * (alphaArr[i]/2);
					ans +=new String(new char[alphaArr[i]/2]).replace("\0", String.valueOf((char)(i +'A')));
					mid = String.valueOf((char)(i+'A'));
				}else {
					ans +=new String(new char[alphaArr[i]/2]).replace("\0", String.valueOf((char)(i +'A')));
				}	
			}

			StringBuffer sb = new StringBuffer(ans);
			if(!mid.isEmpty()) { // 홀수여서 가운데 수가 있다면
				ans += mid;
			}
			ans += sb.reverse().toString();
			
			System.out.println(ans);
			
		}else {
			System.out.println("I'm Sorry Hansoo");
		}
	}
	
	
	static boolean possible() {
		if(inputStr.length()%2==0) { // 총개수 짝수일 때 홀수개수 있으면 안됨
			for(int i: alphaArr) {
				if(i%2!=0) {
					return false;
				}
			}
		}else {
			int count=0;
			for(int i: alphaArr) { // 총개수 홀수일 때 홀수 1개만 있어야함
				if(i%2!= 0) {
					count++;
				}
			}
			if(count>1 ) {//|| count==0 ? 
				return false;
			}
		}
		return true;
	}

}
