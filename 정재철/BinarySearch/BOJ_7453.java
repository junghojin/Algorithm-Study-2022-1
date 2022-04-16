// BOJ_7453_합이 0인 네 정수
// 시간복잡도 : O(n^2)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_7453 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] ABCD= new int[n][4];
        int[] AB= new int[n*n];
        int[] CD= new int[n*n];
        for(int i=0;i<n;i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0;j<4;j++){
                ABCD[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int index=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                AB[index]=ABCD[i][0]+ABCD[j][1]; // ABCD배열에서 A배열과 B배열의 모든쌍의 합을 넣어준다.
                CD[index++]=ABCD[i][2]+ABCD[j][3]; // ABCD배열에서 C배열과 D배열의 모든쌍의 합을 넣어준다.
            }
        }
        Arrays.sort(AB); // 오름차순 정렬한다.
        Arrays.sort(CD);

        for(int i=0;i<n*n;i++)
            System.out.println("AB : " + AB[i] + ", CD : " + CD[i]);

        int indexLeft=0; // AB배열을 가장 작은수부터 탐색하기 위한 인덱스
        int indexRight=n*n-1; // CD배열을 가장 큰수부터 탐색하기 위한 인덱스
        long result=0;
        while(indexLeft<n*n&&indexRight>=0){ // 인덱스의 범위를 벗어나면 break
            int tempAB = AB[indexLeft];
            int tempCD = CD[indexRight];
            if(tempAB +tempCD>0){ // AB의 합과 CD의 합이 0보다 크면 CD의 탐색 인덱스를 감소시킨다.
                indexRight--;
            }else if(tempAB+tempCD<0){ // AB의 합과 CD의 합이 0보다 작으면 AB의 탐색 인덱스를 증가시킨다.
                indexLeft++;
            }else if(tempAB+tempCD==0){ // AB의 합과 CD의 합이 0이면 결과를 증가시켜준다.
                long left_count =0;
                long right_count =0;
                while(indexLeft<n*n&&AB[indexLeft]==tempAB){ // AB의 인텍스를 증가시킨후 tempAB와 값이 같지 않을 때까지 수를 세어준다.
                    left_count++;
                    indexLeft++;
                }
                while(indexRight>=0&&CD[indexRight]==tempCD){ // CD의 인텍스를 감소시킨후 tempCD와 값이 같지 않을 때까지 수를 세어준다.
                    right_count++;
                    indexRight--;
                }
                System.out.println("left_count : " + left_count + ", right_count : " +right_count);
                result += left_count*right_count;
            }
        }
        System.out.println(result);
        br.close();
    }
}
