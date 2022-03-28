// BinarySearch_boj_2805_JJC

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch_boj_2805_JJC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        long[] length = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            length[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(length);
        long start = 0;
        long end = length[N - 1];
        long max = 0;

        while (start <= end) {
            long mid = (start + end) / 2;

            long sum = 0;
            for (int i = 0; i < N; i++)
                if (length[i] > mid)
                    sum += length[i]-mid;
            if (sum < M) {
                end = mid - 1;
            }else {
                max = mid;
                start = mid + 1;
            }
        }
        System.out.println(end);
        br.close();
    }


}