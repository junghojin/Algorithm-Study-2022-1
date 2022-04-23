import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * BOJ_2473 : 세용액
 * 세개의 용액을 더해서 절대값이 가장 작은 용액을 만들어야 함!
 * 시간복잡도 : O(N^2)
 */

public class BOJ_2473_세용액 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력받기
		int n = Integer.parseInt(br.readLine());
		long arr[] = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 오름차순으로 정렬
		Arrays.sort(arr);
		
		// 최솟값 저장
		long min = Long.MAX_VALUE; // 최솟값
		long min_s = 0; // 시작 최솟값
		long min_m = 0; // 중간 최솟값
		long min_e = 0; // 끝 최솟값
		
		
		long num = 0;
		int start = 0;
		
		// 세개의 포인터를 관리해야함.
		// 하나 포인터를 고정시키고 두 개의 포인터를 가지고 용액 문제와 같이 min값을 찾아나감.
		// start를 0부터 end-1까지 증가할 때마다 mid, end 포인터를 변경해나가면서 min값 찾기
		while(start < n-2) { // 시작값이 end-1보다 작을 동안에
			int mid = start+1; // 중간값
			int end = n-1; // 끝값
			
			while(mid < end){
				num = arr[start] + arr[mid] + arr[end]; // 세용액의 합
				
				// 세용액의 절대값이 더 작을 때 min값 갱신
				if(Math.abs(min) >= Math.abs(num)) {
					min = Math.abs(num);
					min_s = arr[start];
					min_m = arr[mid];
					min_e = arr[end];
				}
				
				if(num==0) break; // 0이면 가장 작은 값이되므로 break
				// 세 용액의 합이 0보다 작으면 음수 값이 더 크다는 의미가 됨
				// 그래서 시작포인터를 증가시킴
				else if(num < 0) mid++;
				else end--; // 위와의 반대의 경우로, 끝 포인터를 감소시킴
			}
			
			start++;
		}
		
		System.out.println(min_s+" "+min_m+" "+min_e);
	}
}

