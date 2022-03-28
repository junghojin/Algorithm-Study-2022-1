package greedy;

import java.util.Scanner;

public class greedy_boj_16953_LJE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b =sc.nextInt();
		int count = 1;
		while(a != b) {
			if(a>b) {
				count = -1;
				break;
			}
			if(b%10 == 1) {
				b /= 10; 
				count++;
			}else if(b%2 == 0) {
				b /= 2;
				count++;
			}else {
				count = -1;
				break;
			}
		}
		System.out.println(count);
	}
}
