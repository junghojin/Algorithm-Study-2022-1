package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinarySeach_BOJ_20444_LJE { // 색종이와 가위 
	// 이게 왜 이분탐색 문제일까......
	// 자르는 횟수 N이 고정되어있는데 가로로 자르는것, 세로로자르는것 두개밖에 없기 때문에
	// 가로컷 횟수 + 세로컷 횟수 = N 이니까
	// 하나씩 늘이고 줄이면서 해보면 됨! 근데 사실 가로나 세로나 90도 돌리면 똑같기 때문에 n/2번까지만 해보면 된다.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Integer.parseInt(st.nextToken());
		long K = Integer.parseInt(st.nextToken());
		
		//가로기준으로 해보쟝
		long start = 0; // 가로의 시작 인덱스
		long end = N/2;  //가로의 끝 인덱스
		
		while(true) {
			if(start>end)break;
			long mid = start +(end-start)/2; // =(start+end)/2   Overflow 막기위한 방법
			//mid가 가로 자르는 횟수 
			//N-mid 는 세로 자르는 횟수 
			if((mid+1)*(N-mid+1)==K) {
				System.out.println("YES");
				return;
			}else if((mid+1)*(N-mid+1)> K){ // 너무 많이 잘랐으면
				end = mid -1;
			}else if((mid+1)*(N-mid+1)< K) { // 좀 덜잘랐으면 가로로 더잘라줘
				start = mid +1;
			}
		}
		System.out.println("NO"); // 끝까지 돌았다는건 답이 없다는 뜻
		
	}

}
