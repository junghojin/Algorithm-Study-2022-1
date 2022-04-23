import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * BOJ_2467 : 용액
 * 두 개의 용액을 더해서 절대값이 가장 작은 용액을 만들어야 함!
 * 시간 복잡도 : O(N)
 * */

public class BOJ_2467_용액 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력받기
		// 오름차순으로 입력되기 때문에 별도로 정렬해줄 필요가 없음.
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 양끝 지점
		int start = 0; // 시작 포인터
		int end = n-1; // 끝 포인터
		
		// 최솟값 저장
		int min = Integer.MAX_VALUE;
		int min_s = 0;
		int min_e = 0;
		
		// 시작 포인터가 끝 포인터보다 작을동안에
		while(start < end) {
			
			int num = arr[start] + arr[end]; // 두 용액의 합
			
			// 두용액의 절대값이 더 작을 때 min값 갱신
			if(Math.abs(min) >= Math.abs(num)) { 
				min = Math.abs(num);
				min_s = arr[start];
				min_e = arr[end];
			}
			
			if(num==0) break; // 0이면 가장 작은 값이되므로 break
			
			// 두 용액의 합이 0보다 작으면 음수 값이 더 크다는 의미가 됨
			// 그래서 시작포인터를 증가시킴
			else if(num < 0) start++; 
			else end--; // 위와의 반대의 경우로, 끝 포인터를 감소시킴
		}
		
		System.out.println(min_s+" "+min_e);
	}
}
