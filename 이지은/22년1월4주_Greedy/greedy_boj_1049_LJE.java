package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class greedy_boj_1049_LJE {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 고장난 줄 개수
		int m = Integer.parseInt(st.nextToken()); // 브랜드 개수
		int bPrice[] = new int[m]; //묶음 가격(6개)
		int iPrice[] = new int[m]; //낱개 가격
		
		for(int i = 0;i < m;i++) {
			st = new StringTokenizer(br.readLine());
			bPrice[i] = Integer.parseInt(st.nextToken()); 
			iPrice[i] = Integer.parseInt(st.nextToken()); 
		}
		
		int q = n / 6; //몫
		int r = n % 6; //나머지
		
		int bMin = Arrays.stream(bPrice).min().getAsInt();
		int iMin = Arrays.stream(iPrice).min().getAsInt();
		int a = 0;
		if(r!=0) {  //묶음으로만 했을 때 딱 나누어떨어지는 경우와 나머지가 생기는 경우(+1)를 위해
			a=1;
		}
		/* 최소값 구하기 ( 묶음으로 / 낱개로 / 섞어서)
		 * 묶음으로만 > 낱개로만 ? (낱개로 > 섞어서 ? 섞어서 : 낱개로) : (묶음으로 > 섞어서 ? 섞어서 : 묶음으로)
		 */
		System.out.println((q+a)*bMin > n*iMin ? n*iMin>(q*bMin+r*iMin)?(q*bMin + r*iMin):n*iMin : (q+a)*bMin>(q*bMin+r*iMin) ? (q*bMin+r*iMin):(q+a)*bMin);
		
	}

}
