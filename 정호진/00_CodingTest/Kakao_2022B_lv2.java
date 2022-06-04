// 22. 06. 03. 금 - 카카오 2022 블라인드 - Lv.2 - k 진수에서 소 개수 구하기

public class Kakao_2022B_lv2 {
    public static void main(String[] args) {
        System.out.println(solution(437674, 3));
    }

    public static int solution(int n, int k) {
        int answer = 0; // 소수의 개수

        // ** 양의 정수 n을 k진법의 수로 만든다.
        //  - 양의 정수 n을 k진법의 수로 만들면서 나머지가 0이기 전까지의 수가 소수인지 판별한다. 단 1은 제외한다.
        String base_k = "";
        int remainder = 0;
        while (n >= k) {
            remainder = n % k;
            if (remainder == 0) {
                if (!base_k.isEmpty() && Integer.parseInt(base_k) != 1) {
                    if (isPrime(Long.parseLong(base_k))) answer++;
                }
                base_k = "";
            } else {
                base_k = remainder + base_k;
            }
            n /= k;
        }
        if (isPrime(Long.parseLong(n + base_k))) answer++;

        return answer;
    }

    // long type 선언 이유는 소수의 길이 길어져 int 범위르 넘어서 수 있기 때문이다.
    private static boolean isPrime(long n) {
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
