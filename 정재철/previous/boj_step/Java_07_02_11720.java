
// Java_07_02_11720

import java.util.*;

public class Java_07_02_11720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		String str=sc.nextLine();
		int sum=0;
		for(int i=0;i<N;i++){
			sum += str.charAt(i)-'0';
		}
		System.out.println(sum);

		sc.close();
	}
}
