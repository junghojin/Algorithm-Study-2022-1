// BOJ_1477_휴게소 세우기
// 시간복잡도 : O(NlogN)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1477 {
    static int N,M,L;
    static int[] station;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        station = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            station[i] = Integer.parseInt(st.nextToken());
        station[N]=L; // 고속도로의 끝도 고려해야 하므로 마지막에 추가해준다.
        Arrays.sort(station);
        int left = 1; // 휴게소간 거리의 최솟값
        int right = L; // 휴게소간 거리의 최댓값
        for (int i = 1; i < N; i++)
            right = Math.max(right, station[i] - station[i - 1]);
        int result=1000;
        while (left <= right) {
            int mid = (left + right) / 2;
            int temp = count(mid); // 휴게소가 없는 구간의 최댓값이 mid일때 추가로 필요한 휴게소의 수를 구한다.
            if(temp>M){ // 추가로 필요한 휴게소의 수가 M보다 크면 left를 키운다.
                left=mid+1;
            }else{ // 추가로 필요한 휴게소의 수가 M보다 적거나 같으면 right를 줄인다.
                right=mid-1;
            }
        }
        System.out.println(left);
        br.close();
    }
    static int count(int mid){
        int cnt=(station[0]-1)/mid;
        for(int i=1;i<=N;i++) {
            cnt+=(station[i]-station[i-1]-1)/mid;
        }
        return cnt;
    }
}
