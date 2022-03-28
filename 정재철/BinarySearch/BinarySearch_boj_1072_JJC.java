// BinarySearch_boj_1072_JJC

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinarySearch_boj_1072_JJC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());
        long Z = 100 * Y / X;
        long start = 1;
        long end = X;
        long mid = 0;
        long min = Integer.MAX_VALUE;

        while (start <= end) {
            mid = (start + end) / 2;
            long temp = 100 * (Y + mid) / (X + mid);
            if (temp > Z)
                end = mid - 1;
            else
                start = mid + 1;
        }
        if (Z >= 99)
            System.out.println(-1);
        else
            System.out.println(start);
        br.close();
    }
}