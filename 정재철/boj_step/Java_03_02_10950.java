
// Java_03_02_10950

import java.util.*;

public class Java_03_02_10950 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a,b,t;
		t = sc.nextInt();
		
		for(int i=0; i<t;i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			System.out.println(a+b);
		}
		sc.close();
	}
}
