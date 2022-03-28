package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class greedy_boj_15729_LJE {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); 
		int count = 0;
		
		int [] button = new int[n+2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			button[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<n;i++) {
			if(button[i] == 1) {
				button[i+1]=1-button[i+1];
				button[i+2]=1-button[i+2];
				count++;
			}
		}
		System.out.println(count);
	}
}
