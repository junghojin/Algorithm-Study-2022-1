package step05;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_10818 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int []arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		System.out.println(Arrays.stream(arr).min().getAsInt() +" "+ Arrays.stream(arr).max().getAsInt());
	}
}
