package step03;

import java.util.Scanner;

public class BJ_11021 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=1;i<=T;i++) {	
			System.out.printf("Case #%d: %d%n",i,sc.nextInt()+sc.nextInt());
		}	
	}
}
