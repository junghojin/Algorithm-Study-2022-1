package bi_search;

import java.io.*;
import java.util.*;

public class Main_2467_twoPointer {
    static int n;
    static long numL,numR;
    static long arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        arr = new long [n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i<n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

      //  Arrays.sort(arr);   // 투 포인터를 활용하기 위한 배열 정렬

        int left = 0;
        int right = n - 1;
        long min = Long.MAX_VALUE;

        while (left<right) {
            long temp = arr[left] + arr[right];

            if (min > Math.abs(temp)) {
                min = Math.abs(temp);
                numL = arr[left];
                numR = arr[right];
            }

            if(temp>=0)
                right--;
            else
                left++;

        }

        System.out.println(numL+" "+numR);

    }
}
