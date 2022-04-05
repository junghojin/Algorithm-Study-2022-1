package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class implementation_BOJ_17143_LJE { // 낚시왕 = 우리아빠 = 물고기의 천적 = 그래서 내가 물고기를 싫어하나
	static class shark {
		int r;
		int c;
		int s; // 속력
		int d; // 이동방향
		int z; // 크기

		public shark() {
		}

		public shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}

	// 1초 = 한칸 오른쪽으로 = 해당 열에서 가짱 위쪽의 상어 사라짐 & 상어이동(if 같은칸이면 크키가 큰 물고기가 잡아먹음)
	// map을 굳이 안만들고 해도 될 것 같기도
	static int R, C, M, answer; // r,c,상어수,잡은 상어 크기 합
	static ArrayList<shark> sList;
	static shark map[][],temp[][]; // 기존 입력, 임시 상어 저장
	static int deltas[][] = { { 0, 0 }, { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };// 상 하 좌 우

	static void fishing() {
		// 1. 맵에 넣고, 맵을 돌면서
		for (int i = 1; i <= C; i++) { // 열마다 반복
			// 해당 열 제일 위에 있는 상어 낚시!
			for (int j = 1; j <= R; j++) {
				if(map[j][i] !=null) { // 젤 위에 있는 상어 잡기
					answer += map[j][i].z; //크기 합하기
					map[j][i] = null;//상어 없애기
					for (int s = 0; s < sList.size(); s++) { // 리스트에서도 상어 없애기. 
						if(sList.get(s).r==j && sList.get(s).c==i) {
							sList.remove(s);
						}
					}
					break;
				}
			}
			// 상어 이동
			for (int j = 0; j < sList.size(); j++) { // 상어마다 
				int dx = sList.get(j).r;
				int dy = sList.get(j).c;
				
				//이동하는 위치 구하기
				for (int k = 0; k < sList.get(j).s; k++) {
					dx = sList.get(j).r + deltas[sList.get(j).d][0];
					dy = sList.get(j).c + deltas[sList.get(j).d][1];
					
					if(dx<=0 || dy<=0 || dx>R || dy>C ) { // 범위를 벗어나면 방향 바꿔주기
						if(sList.get(j).d%2==0) sList.get(j).d -= 1;
						else sList.get(j).d += 1;
						dx = sList.get(j).r + deltas[sList.get(j).d][0]*2;
						dy = sList.get(j).c + deltas[sList.get(j).d][1]*2;
					}
				}
				
				//같은 칸에 있는 다른 상어 잡아먹기
				if(temp[dx][dy] !=null) { // 다른 상어 있으면
					if(temp[dx][dy].z > sList.get(j).z) { // 현재 있는 애가 크면
						sList.remove(j); // 상어 없애기
					}else { // 새로온 상어가 크면 
						for (int s = 0; s < sList.size(); s++) { // 리스트에서도 상어 없애기. 
							if(sList.get(s).r==dx && sList.get(s).c==dy) {
								sList.remove(s);
							}
						}
						temp[dx][dy] = new shark(dx, dy, sList.get(j).s, sList.get(j).d, sList.get(j).z);
					}
				}else {//다른 상어가 없다면!
					temp[dx][dy] = new shark(dx, dy, sList.get(j).s, sList.get(j).d, sList.get(j).z);
				}
			}
			
			//temp의 상어 map에 다시 넣어주고 temp 비우기
			for (int j = 1; j <= R; j++) {
				for (int k = 1; k <= C; k++) {
					map[j][k] = temp[j][k];
					temp[j][k] = null;
				}
			}
			
			System.out.println("------"+i+"열---------잡은 상어 힘: "+answer);
			for (int j = 1; j <= R; j++) {
				for (int k = 1; k <= C; k++) {
					if(map[j][k]!=null) {
						System.out.print(map[j][k].z + " "); 
					}else {
						System.out.print(0+" ");
					}
				}
				System.out.println();
			}
		}

	
	}


	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new shark[R+1][C+1];
		temp = new shark[R+1][C+1];
		sList = new ArrayList<>(); // 상어 리스트 도 사실 굳이 안마들어도 될 것 같기도................
		answer=0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			sList.add(new shark(r, c, s, d, z));
			map[r][c] = new shark(r, c, s, d, z);
		}
		System.out.println("------"+0+"열---------잡은 상어 힘: "+answer);
		for (int j = 1; j <= R; j++) {
			for (int k = 1; k <= C; k++) {
				if(map[j][k]!=null) {
					System.out.print(map[j][k].z + " "); 
				}else {
					System.out.print(0+" ");
				}
			}
			System.out.println();
		}
		fishing();
		System.out.println(answer);
	}

}
