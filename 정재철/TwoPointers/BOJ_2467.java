// BOJ_2467_용액
// 시간복잡도 : O(N) - while 문에서 탐색시 최악의 경우 N번 만큼 반복

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N=Integer.parseInt(br.readLine());
        int[] liquid = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            liquid[i]=Integer.parseInt(st.nextToken());
        // 입력 끝
        int left=0; // 특성값이 가장 작은 용액의 인덱스
        int right=N-1; // 특성값이 가장 큰 용액의 인덱스
        int result1=liquid[left]; // 첫번째 결과 값
        int result2=liquid[right]; // 두번째 결과 값
        long min= Math.abs(result1+result2); // 두 용액의 특성값의 합이 0이 0에서 떨어진 정도의 최솟값
        while(left<right){ // 양끝 인덱스에서 탐색을 시작하여 두 인덱스가 만나면 반복을 멈춘다.
            int leftNum = liquid[left]; // 두 용액중 특성값이 작은 용액
            int rightNum = liquid[right];// 두 용액중 특성값이 큰 용액
            long sum = Math.abs(leftNum+rightNum); // 탐색 중인 두 용액의 특성의 합이 0에서 떨어진 정도
            if(sum<min){ // 탐색 중인 두 용액이 최솟값보다 작으면 최솟값과 결과 값을 갱신
                min = sum;
                result1 = leftNum;
                result2 = rightNum;
            }
            if(leftNum+rightNum>=0) // 두 용액의 특성값의 합이 양수이면 right를 갑소시켜준다.
                right--;
            else // 두 용액의 특성값의 합이 음수이면 left를 증가시켜준다.
                left++;
        }
        System.out.println(result1 + " " + result2);
        // 출력 끝
        br.close();
    }
}
