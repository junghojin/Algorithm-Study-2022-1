//package greedy;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//
//public class Greedy_boj_11399_HSH {
//	
//	static int N;
//	static BufferedReader br;
//	static int arr[];
//	static int time;
//	static int tot_time;
//
//	public static void main(String[] args) throws Exception {
//		
//		br = new BufferedReader(new InputStreamReader(System.in)); 
//		
//		int N = Integer.parseInt(br.readLine());
//		
//		String[] str = br.readLine().split(" ");
//		
//		Arrays.sort(str);
//		
//		for(String s : str) {
//			time += Integer.parseInt(s);
//			tot_time += time;
//		}
//		
//		System.out.println(tot_time);
//	}
//
//}

package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Greedy_boj_11399_HSH {
	
	static int N;
	
	static int arr[];
	static int time;
	static int tot_time;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		arr = new int [N];
		
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		for(int i: arr) {
			time += i;
			tot_time += time;
		}
		
		System.out.println(tot_time);
	}

}
