
// Java_04_01_10952

import java.util.*;

public class Java_04_01_10952 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = -1;
		int b = -1;
		while (true) {
			a = sc.nextInt();
			b = sc.nextInt();
			if(a==0&&b==0) break; 
			else System.out.println(a + b);
		}
		sc.close();
	}
}
