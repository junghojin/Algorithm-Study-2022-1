// implementation_boj_10773_JJC

import java.util.*;

public class implementation_boj_10773_JJC {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        Stack<Integer> stack = new Stack<>(); // 정수형 stack 선언

        for(int i=0;i<n;i++){
            int temp =sc.nextInt();
            if(temp==0){ // 입력받은 값이 0이면 pop()하여 아전 값을 지운다.
                stack.pop();
            } else{ // 입력받은 값이 0이 아니면 stack에 push한다.
                stack.push(temp);
            }
        }
        int result=0;

        while(!stack.isEmpty()){ // 스택의 모든 값을 더한다.
            result+=stack.pop();
        }
        
        System.out.println(result);

        sc.close();
    }


}