package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Greedy_boj_1931_hsh {

	static int n;
	static BufferedReader br;
	static int timetable[][];
	
	public static void main(String[] args) throws IOException {

		br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		timetable = new int[n][2];
		
		for(int i = 0; i<n; i++) {
			String[] str = br.readLine().split(" ");
			
			timetable[i][0] =Integer.parseInt(str[0]);
			timetable[i][1] =Integer.parseInt(str[1]);
			
			// Stringtokenizer : 구분자를 통해 토큰형태로 나눌때 쓰는 클래스   ,,, nextToken() : 다음 토큰을 불러오는 메소드.
			// StringTokenizer st = new StringTokenizer(str);
			// st.nextToke()
		}
		
		Arrays.sort(timetable, new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				
				if(o1[1] == o2[1]) {	//종류시간을 빠른순으로 정렬하기.
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});
		
		int cnt = 0;
		int prev_end_time = 0;
		
		for(int i =0;i<n;i++) {
			
			if(prev_end_time<=timetable[i][0]) {
				prev_end_time = timetable[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
