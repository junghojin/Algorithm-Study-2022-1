import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * BOJ_1806 : 부분합
 * 연속된 수들의 부분합 중에 그 합이 S 이상이 되는 것 중에서 가장 짧은 것의 길이 구하기
 * 시간복잡도 : O(N^2)
 */

public class BOJ_1806_부분합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		
		// start : 0 ~ n-1
		// end : start+1
		// 연속된 수의 합이 s이상이 될떄까지 end 포인터를 증가시킴
		while(start < n) {
			
			sum = arr[start]; // sum에 시작값 더하고 시작
			end = start+1;
			
			while(sum < s && end < n) { // sum이 s값보다 작고 end 포인터 값이 n보다 작을동안에
				sum += arr[end];
				end++;
			}
			
			if(sum<s) break; // 위의 while 루프를 돌았는데도 sum이 s보다 작으면 다음값 확인할 필요 없으니까 break;
			else min=Math.min(min, end-start); // sum이 s보다 크거나 같을 때 더 짧은 길이로 갱신
			
			start++;
		}
		
		if(min==Integer.MAX_VALUE) System.out.println(0);
		else System.out.println(min);
	}

}
