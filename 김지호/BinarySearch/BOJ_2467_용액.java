import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * BOJ_2467 : 용액
 * 
 * */

public class BOJ_2467_용액 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = n-1;
		
		int min = Integer.MAX_VALUE;
		int min_s = 0;
		int min_e = 0;
		
		while(start < end) {
			
			int num = arr[start] + arr[end];
			
			if(Math.abs(min) >= Math.abs(num)) {
				min = Math.abs(num);
				min_s = arr[start];
				min_e = arr[end];
			}
			
			if(num==0) break;
			else if(num < 0) start++;
			else end--;
		}
		
		System.out.println(min_s+" "+min_e);
	}
}
