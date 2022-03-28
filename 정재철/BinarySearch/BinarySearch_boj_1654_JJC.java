// BinarySearch_boj_1654_JJC

import java.io.*;
import java.util.*;

public class BinarySearch_boj_1654_JJC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long[] line = new long[K];
        for (int i = 0; i < K; i++) {
            line[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(line);
        long start =1;
        long end= line[K-1];
        long mid=0;

        while(start<=end){
            mid = (start + end)/2;

            long temp =0;
            for(int i=0;i<K;i++) {
                temp += line[i] / mid;
            }

            if(temp>=N){
                start =mid +1;
            } else{
                end = mid -1;
            }

        }
        System.out.println(end);
        br.close();
    }


}