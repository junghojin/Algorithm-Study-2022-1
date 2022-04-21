// BOJ_2473_세 용액
// 시간복잡도 : O(N^2) - 탐색시 for문에서 N만큼 while문에서 N만큼

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2473 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] liquid = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            liquid[i] = Integer.parseInt(st.nextToken());
        // 입력 끝
        Arrays.sort(liquid); // 오름차순으로 정렬
        long result1 = 0;
        long result2 = 0;
        long result3 = 0;
        long min = Long.MAX_VALUE;
        for (int i = 0; i < N; i++) { // 세용액 중 특성값이 가장 작은 값의 인덱스를 i를 선택
            int left = 1 + i; // 두번째로 특성값이 큰 용액의 인덱스
            int right = N - 1; // 세번쨰로 특성값이 큰 용액의 인덱스
            while (left < right) { // 양끝 인덱스에서 탐색을 시작하여 두 인덱스가 만나면 반복을 멈춘다.
                long leftNum = liquid[i];
                long midNum = liquid[left];
                long rightNum = liquid[right];
                long sum = Math.abs(leftNum + midNum + rightNum); // 탐색 중인 세 용액의 특성의 합이 0에서 떨어진 정도
                if (sum < min) { // 탐색 중인 세 용액이 최솟값보다 작으면 최솟값과 결과 값을 갱신
                    min = sum;
                    result1 = leftNum;
                    result2 = midNum;
                    result3 = rightNum;
                }
                if (leftNum + midNum + rightNum >= 0) // 세 용액의 특성값의 합이 양수이면 right를 감소시켜준다.
                    right--;
                else // 세 용액의 특성값의 합이 음수이면 left를 증가시켜준다.
                    left++;
            }
        }
        System.out.println(result1 + " " + result2 + " " + result3);
        // 출력 끝
        br.close();
    }
}
