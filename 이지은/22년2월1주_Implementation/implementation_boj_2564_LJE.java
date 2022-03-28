package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class implementation_boj_2564_LJE {
	static int width;
	static int height;
	static int dongDir;
	static int dongPos;
	static int [][] map;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		width = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(br.readLine());
		
		map = new int[n][2];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0]=Integer.parseInt(st.nextToken());
			map[i][1]=Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		dongDir = Integer.parseInt(st.nextToken());
		dongPos = Integer.parseInt(st.nextToken());
		/////////////입력 끝
		
		int sum = 0;
		for(int i=0;i<n;i++) {
			int a= CalcShort(i);
			//System.out.println(a);
			sum += a;
		}
		System.out.println(sum);
		
	}
	static int CalcShort(int i) {
		int storeDir = map[i][0];
		int storePos = map[i][1];
		//방향 같을 때
		if(storeDir == dongDir) {
			return Math.abs(storePos - dongPos);
		}else if(Math.abs(storeDir-dongDir)==1 && !(storeDir==2 && dongDir==3) &&!(storeDir==3 && dongDir==2)) {//반대편에 있는 경우
			if(storeDir==1 || storeDir==2){
				if((width*2 - storePos - dongPos)>(storePos+dongPos)) {
					return storePos+dongPos+ height;
				}else {
					return width*2 - storePos - dongPos + height;
				}
			}else if(storeDir==3 || storeDir==4) {
				if((height*2 - storePos - dongPos)>(storePos+dongPos)) {
					return storePos+dongPos+ width;
				}else {
					return height*2 - storePos - dongPos + width;
				}
			}
		}
		
		//옆에 있는 경우
		if((dongDir==1 && storeDir==3) || (dongDir==3 &&storeDir==1)) {
			return dongPos + storePos;
		}else if((dongDir==2 && storeDir==4) || (dongDir==4 &&storeDir==2)) {
			return width + height - dongPos - storePos;
		}
		else if(dongDir==1 && storeDir==4) {
			return width - dongPos + storePos;
		}else if(dongDir==4 && storeDir==1) {
			return width + dongPos - storePos;
		}
		else if(dongDir==2 && storeDir==3) {
			return dongPos + height - storePos;
		}else if(dongDir==3 && storeDir==2) {
			return -dongPos + height + storePos;
		}
		
		return -1;
	}

}
