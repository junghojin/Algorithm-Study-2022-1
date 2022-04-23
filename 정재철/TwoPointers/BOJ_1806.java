// BOJ_1806_부분합
// 시간복잡도 : O(N)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int S=Integer.parseInt(st.nextToken());
        int[] length = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            length[i] = Integer.parseInt(st.nextToken());
        }
        int leftIndex=0;
        int rightIndex=0;
        long sum=0;
        int min=Integer.MAX_VALUE;
        while(true){
            if(sum>=S){
                sum-=length[leftIndex];
                leftIndex++;
                min=Math.min(rightIndex-leftIndex+1,min);
            }else{
                if(rightIndex==N) break;
                sum+=length[rightIndex];
                rightIndex++;
            }
        }
        if(min==Integer.MAX_VALUE){
            System.out.println(0);
        }else{
            System.out.println(min);
        }
        // 출력 끝
        br.close();
    }
}
