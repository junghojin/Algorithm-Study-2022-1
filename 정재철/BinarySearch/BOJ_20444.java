// BOJ_20444_색종이와 가위
// 시간복잡도 : O(logN) - n을 클수록 오래걸리지 기준에 대하여 2를 나눠주며 이진 탐색을 하므로 시간복잡도는 logN이다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20444 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        long left = 1;
        long right = n / 2 + 1;
        long mid;
        boolean flag=false;
        while (left <= right) {
            mid = (left + right) / 2;
            long temp = mid * (n - mid + 2);
            if (temp == k) {
                flag=true;
                break;
            } else if (temp < k)
                left = mid + 1;
             else
                right = mid -1;
        }
        if(flag) System.out.println("YES");
        else System.out.println("NO");
        br.close();
    }
}

//        n에 따라 k의 값이 가능한 경우를 두 정수의 곱으로 나타내고 첫번째 정수로 정렬하면 다음과 같다.
//        1
//        1*2=2
//
//        2
//        1*3=3
//        2*2=4
//
//        3
//        1*4=4
//        2*3=6
//
//        4
//        1*5=5
//        2*4=8
//        3*3=9
//
//        5
//        1*6=6
//        2*5=10
//        3*4=12
//
//        6
//        1*7=7
//        2*6=12
//        3*5=15
//        4*4=16
//
//        7
//        1*8=8
//        2*7=14
//        3*6=18
//        4*5=20
//        ...
//
//        이를 통해 k가 될 수 있는 값을 추정하였다.
//        mid를 곱하는 두 수중 첫번째 수라고 한다.
//        left를 mid가 될수 있는 가장 작은 값인 1로 설정
//        right를 mid가 될수 있는 가장 큰 값인 n/2+1로 설정 후
//        이를 통해 이분탐색을 진행한다.