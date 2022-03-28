package q_1to7;

import java.util.Scanner;

public class q_2588 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int A = Integer.parseInt(sc.nextLine());
		int B = Integer.parseInt(sc.nextLine());
		
		
		int num1 = A * (B%10);
		int num2 = A * ((B%100) - B%10)/10;
		int num3 = A * (B/100);
		
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		
		System.out.println((num3*100 + num2*10 + num1));
	}
}
