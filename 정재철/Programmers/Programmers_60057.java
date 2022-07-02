// Programmers_60057_2020 KAKAO BLIND RECRUITMENT_문자열 압축

import java.util.*;

public class Programmers_60057 {
    public static void main(String[] args){
        String s = "aabbaccc";
        Solution sol = new Solution();
        System.out.println(sol.solution(s));
    }
    static class Solution {
        public int solution(String s) {
            int answer = s.length();
            int len = s.length();
            for(int k=1;k<=len;k++){ //문자열의 자르는 단위를 1개 부타 문자열의 크기까지 탐색한다.
                String str = new String(""); // 각 단위 별로 잘랏을때 만들어지는 문자열
                String pre = new String(""); // 탐색중 반복되는 문자열이 있는지 판별하기 위해 이전 문자열을 저장
                int index=0; // 문자열 s를 탐색하기 위한 인덱스
                int num=1; // str에 만들어지는 숫자인 반복된 문자열의 개수를 표시하기 위한 정수
                boolean flag=false; // while문을 탈출하기위한 flag
                while (true){
                    String temp = new String("");
                    int count=0; // 문자열을 k번 마다 자르기 카운트
                    while (count++<k&&index<len){ // count가 k보다 작고 index가 문자열의 범위안이면 탐색
                        temp+=s.charAt(index++);
                    }
                    if(temp.equals(pre)){ // 이전에 잘랏던 문자열과 temp가 같으면 num을 추가해주고 pre는 그대로 가져간다.
                        num++;
                    }else { // 이전에 잘락던 문자열과 temp가 다르면 str에 num과 temp를 추가해준다.
                        if(num>1){ // 반복이 한번이면 생략
                            str+=num;
                        }
                        str+=pre;
                        pre= new String(temp); // pre값은 temp로 변경
                        num=1; // num을 1로 변경
                    }
                    if(flag) break; //
                    if(index==len) flag= true; // s의 탐색이 끝이 나더라도 마지막에 남아있는 num값과 pre값을 추가하기위해 한번더 while문을 실행하기위해
                }
                answer=Math.min(answer,str.length());
            }
            return answer;
        }
    }
}

