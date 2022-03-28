// DP_BOJ_11726_JJC

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_BOJ_11726_JJC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 입력 끝
        int[] num = new int[n + 1];
        num[1] = 1; // 타일의 크기가 2X1이면 1가지(|)
        num[2] = 2; // 타일의 크기가 2X2이면 2가지(||,=)
        /*
        타일의 크기가 2X3이면 3가지(|||,|=,|=)
        타일의 크기가 2Xn이면일때 타일의 모양은
        타일의 크기가 2X(n-1)에서 2X1(|) 짜리에서 하나 붙여준거나
        타일의 크기가 2X(n-2)에서 2X2(||,=) 짜리를 하나 붙여준다고 생각하면
        2Xn이면 2X(n-1)과 2X(n-2)*2이라 할 수 있지만 2X(n-2)에서 ||를 붙여주면 2X(n-1)에서 | 붙여준 것과 같아 중복되므로
        n이 3이상이면 num[n]= num[n-1]+num[n-2] 점화식을 얻을 수 있다.(또 피보나치...)
         */
        for (int i = 3; i <= n; i++)
            num[i] = (num[i - 1] + num[i - 2]) % 10007; // 수가 기하급수적으로 커지면서 오버플로우 발생을 방지하기위해 나눠줌
        System.out.println(num[n]);
        // 출력 끝
        br.close();
    }


}