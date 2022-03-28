package implementation;
/*
 * 처음 시도 : 배열을 사용해 들어온 값이 0 이라면 전의 값 확인 -> 0 이 아닌 것 까지 가서 0으로 만들어준다 -> 시간초과
 * 1354007006 이면 
 * 13500 으로 바꿔줬었는데 시간초과
 * 
 * 두번째 시도 -> 스택 처럼 i를 옮겨줌. 빈 공간에 그저 0 들어가게 
 * 1354007006 입력
 * 13540 ->
 * 1350  ->
 * 1350
 * 1300 ->
 * 1370 ->
 * 1370 -> ( 네번째 자리0 은 새로 들어온 0)
 * 1300 ->  새로들어온 0이 7 없앰 남은 0은 없애는 0이 아니라 그냥 숫자 0
 * 1300 -> 세번재 자리 0 새로들어온 0
 * 1000 -> 새로들어온 0 이 3 없앰
 * 1600 -> 최종. sum 값 7 나옴  
 *  
 * 근데 스택이 자바에 있네ㅍㅅㅍ
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class implementation_boj_10773_LJE {
	static int [] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int k = Integer.parseInt(br.readLine());
		arr = new int[k];
		int sum=0;
		for(int i = 0;i<k;i++) {
			int a = Integer.parseInt(br.readLine());
			if(a == 0) {
				arr[i-1]=0;//remove(i)]=0;
				i = i-2;
				k= k-2;
			}else {
				arr[i]=a;
			}
		}
		br.close();
		
		for(int i=0;i<k;i++) {
			sum += arr[i];
		}
		bw.write(String.valueOf(sum));
		bw.close();
		//System.out.println(sum);
	}
//	static int remove(int i) { // 0이 들어왔을 때 전 값을 없애기 위해 전 값의 인덱스 찾는 함수 8ㅅ8
//		if((i-1)>=0) { // 매개변수 유효성 검사
//			if(arr[i-1]==0) {
//				return remove(i-1);
//			}else {
//				return i-1;
//			}
//		}else {
//			return -1;
//		}
//	}
}
