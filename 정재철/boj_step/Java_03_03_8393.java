
// Java_03_03_8393

import java.util.*;

public class Java_03_03_8393 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a;
		int sum=0;
		a = sc.nextInt();
		
		for(int i=1;i<=a;i++)
			sum +=i;
		System.out.println(sum);
		sc.close();
	}
}
