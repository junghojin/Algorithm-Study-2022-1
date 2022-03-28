package implementation;

import java.util.Scanner;


public class imple_boj_1213_hsh {
	
	static int N=26;
	static int alpha[] = new int [N];

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		char sArr[] = str.toCharArray();
		
		for(int i=0;i<sArr.length;i++) {
			alpha[sArr[i]-'A']++;
		}
		
		int mid=0;
		int n=0;		
		
		for(int i=0;i<N;i++) {
			if(alpha[i]%2==1) {
				mid=i;
				n++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		if ((str.length()%2==1&&n>1)||(str.length()%2==0&&n>0) )
		{
			sb.append("I'm Sorry Hansoo");
		}
		else {
			String ans="";
			for(int i=0;i<N;i++) {
				for(int j = 0; j < alpha[i] / 2; j++) {
					ans += (char)(i + 'A');
				}
			}
			
			String rev = new StringBuilder(ans).reverse().toString();
			if(n == 1) {
				ans += (char)(mid + 'A');
			}
			
			sb.append(ans + rev);
			
		}
		
		System.out.println(sb);
	}

}
