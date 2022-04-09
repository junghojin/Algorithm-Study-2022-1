package None;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//약의 투입 - 행을 같은 것으로 최소 2개 이상만들지만 합격할 수 있는 최솟값을 찾아야 함.
// 특성 A는 0, 특성 B는 1
public class Solution_2112_이지은 { // 보호 필름
	static int D,W,K, map[][], answer,select;
	static boolean sel[];
//	static ArrayList<Integer> [] temp;
	static int temp[][];
	
	//약 투입할 위치 찾기 - 조합? 
	static void findPos(int cnt) {
		if(cnt==select) {
			temp = new int [D][W];
//			temp = new ArrayList[W];
			insert(sel);
			if(check()) { // 성능검사 통과하면
				answer=select;
				return; // 완전 끝내고 싶은뎅,,
			}else { // 약 투약했던 것 원래대로 하기 
				for (int i = 0; i < sel.length; i++) {
					if(sel[i]) {
						for (int j = 0; j < W; j++) {
							map[i/2][j] = temp[i/2][j];
						}
					}
				}
			}
			
			return;
		}
		for (int i = 0; i < D*2; i++) { // arithmeticException예외처리해줘야함
			if(i%2 != 0) { //홀수인 경우에
				if((i-1)>=0 && sel[i-1]==true) { // 짝수가 사용중 즉, 같은 행에 대해 a로 사용중이면 다른 행 하도록 처리
					continue;
				}
			}else { // 짝수인 경우에 
				if((i+1)<D*2 && sel[i+1]==true) { // 홀수가 사용중 즉, 같은 행에 대해 b로 사용중이면 다른 행 하도록 처리
					continue;
				}
			}
			sel[i]=true;
			findPos(cnt+1);
			sel[i]=false;
			
		}
		
	}
	//약 투입하기
	static void insert(boolean sel[]) { // val: A_0 or  B_1 
//		int index=0;
		for (int i = 0; i < sel.length; i++) {
			if(sel[i]) {
				for (int j = 0; j < W; j++) {
					temp[i/2][j] = map[i/2][j];
//					temp[i/2].add(map[i/2][j]);
					map[i/2][j] = i%2==0?0:1;
				}
			}
		}
	}
	
	//성능 검사
	static boolean check() {
		boolean pass[] = new boolean[W]; // 각 열들이 통과하는지 아닌지 관리하는 배열
		for (int j = 0; j < W; j++) {
			int a = map[0][j];
			int same = 1;
			for (int i = 1; i < D; i++) {
				if(a==map[i][j]) {
					same++;
					if(same>=K) {
						pass[j] = true;
						break; // 통과하면 다음 열 체크
					}
				}else {
					same=1; // 초기화
					a = map[i][j]; // a도 바꿔주기 
				}
			}
		}
//		System.out.println("dddddddddddd");
//		for (int i = 0; i < pass.length; i++) {
//			System.out.print(pass[i]+" ");
//		}
		
		for (int i = 0; i < W; i++) {
			if(pass[i]==false) {
				return false;
			}
		}
		
		return true; 
	}
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TestCase = Integer.parseInt(br.readLine());
		for (int T = 1; T <= TestCase; T++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken()); // 합격 기준
			map = new int [D][W];
			
//			temp = new ArrayList[W];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			answer = 0;
			select=2; // 총 뽑을 개수
			sel = new boolean[2*W]; // a,b둘다 고려하기위해 2배로하고 2의 배수는 0인 a로 아닌건 1인 b로
			if(check()) answer=0;
			else {
				//맨끝까지 check했는지 확인하고 그랬는데도 check()안되면 select ++;
				while(true) {
					if(answer!=0)break;
					findPos(0);
					select++;
				}
			}
			
			System.out.println("#"+T+" "+answer);
		}
	}

}
