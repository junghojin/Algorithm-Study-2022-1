// greedy_boj_1049_JJC

import java.util.*;

public class greedy_boj_1049_JJC {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] pack = new int[m]; //기타줄 묶음 가격
		int[] one = new int[m]; //기타줄 낱게 가격

		for(int i=0;i<m;i++){
			pack[i] = sc.nextInt();
			one[i] = sc.nextInt();
		}
		Arrays.sort(pack); //기타줄 묶음 가격 정렬
		Arrays.sort(one); //기타줄 낱게 가격 정렬

		int result= pack[0]*(n/6)+one[0]*(n%6); // n개중 최대한 패키지로 사고 나머지는 낱개로 샀을 경우.
		if(result>pack[0]*(n/6+1)){ // 낱개로 6개 사는 것보다 패키지 1개로 사는게 저렴한 경우
			result=pack[0]*(n/6+1);
		}
		if(result>one[0]*n){ // 패키지 1개 사는 것보다 낱개 6개로 사는게 저렴한 경우
			result=one[0]*n;
		}
		
		System.out.println(result);

		sc.close();
	}
}
