// BOJ_1715_카드 정렬하기
// 시간복잡도 : O(NlogN) - 힙 자료구조를 기반으로 구현된 우선순위큐 정렬시 logN번 만큼 시간복잡도가 필요하고, for문을 통해 정렬을 N번만큼  반복한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> num = new PriorityQueue<>();
        for(int i=0;i<N;i++)
            num.add(Integer.parseInt(br.readLine())); // 입력 값을 우선순위 큐에 삽입한다.
        int sum=0;
        for(int i=1;i<N;i++){
            int add = num.poll()+num.poll(); // 큐에서 가장 작은 값을 두개를 추출하여 더해준다.
            sum+=add; // 이 값을 결과 값에 더해주고 큐에도 삽입해준다.
            num.add(add); // 삽입된 값은 자동으로 정렬이 이루어지므로 반복 수행을 하더라도 최솟값을 받을 수 있다.
        }
        System.out.println(sum);
        br.close();
    }
}

