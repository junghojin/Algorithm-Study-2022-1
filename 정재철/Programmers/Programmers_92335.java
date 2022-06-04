// Programmers_92335_2022 KAKAO BLIND RECRUITMENT_K진수에서 소수 개수 구하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Programmers_92335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        Solution sol = new Solution();
        System.out.println(sol.solution(n, k));
    }
    static class Solution {
        public int solution(int n, int k) {
            int answer = 0;
            StringBuilder sb=new StringBuilder();
            while (n > 0) { // n을 k진수 수로 변환
                sb.append(n % k);
                n /= k;
            }
            sb.reverse(); // StringBuilder 통해 얻은 문자열을 뒤집어준다.
            String[] st = sb.toString().split("0"); // 0을 포함하지 않아야하므로 "0"으로 문자열을 나눠준다.
            for (String str : st) {
                if(str.equals("")) continue;
                long temp = Long.valueOf(str); // 나눠진 문자열을 long으로 변환
                if(check(temp)){ //소수인지 체크
                    answer++;
                }
            }
            return answer;
        }
        public boolean check(long n){
            if (n <= 1) return false;
            for (int i = 2; i <= (int)Math.sqrt(n); i++) { // n을 n의 2부터 제곱근보다 작은 정수로 나누어 소수인지 판단
                if (n % i == 0) return  false;
            }
            return true;
        }
    }
}
