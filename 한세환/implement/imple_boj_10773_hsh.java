package implementation;

import java.util.Scanner;
import java.util.Stack;

public class imple_boj_10773_hsh {
	static int n;
	static int sum;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<n;i++) {
			int x= sc.nextInt();
			if(x==0)
				stack.pop();
			else {
				stack.push(x);
			}
		}
		
		while(!(stack.empty())) {
			sum+=stack.pop();
		}
		
		System.out.println(sum);
	}

}
