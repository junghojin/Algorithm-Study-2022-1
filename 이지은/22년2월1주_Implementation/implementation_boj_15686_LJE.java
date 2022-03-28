package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class implementation_boj_15686_LJE {
	static int [][] map;
	static int n,m,answer;
	static ArrayList<Pos> chicken; // 치킨 집 정보
	static ArrayList<Pos> house; // 집 정보
	static ArrayList<Pos> selected; // m개 조합 저장될 배열
//	static Pos numbers[]; // m개의 조합 저장될 배열
	static int nums[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		chicken = new ArrayList<>();
		house = new ArrayList<>();
		selected = new ArrayList<>();
		answer = Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					chicken.add(new Pos(i,j));
				}else if (map[i][j]==1) {
					house.add(new Pos(i,j));
				}
			}
		}
		
		combination(0, 0);
		System.out.println(answer);
	}
	
	static void combination(int cnt, int start) { //cnt : 조합 개수, start : 조합 시작 인덱스
		if(cnt == m) { //m개 선택=조합 완성
			int dis = chikDist(); //각 조합별 도시의 치킨거리
//			answer = answer<dis?answer:dis; 
			 answer = Math.min(answer,dis);
			return;
		}
		for (int i = start; i < chicken.size(); i++) {
//			numbers[cnt] = chicken.get(i);
//			numbers[cnt].y = chicken.get(i).y;
//			nums[cnt] = i;
			selected.add(chicken.get(i));
			combination(cnt+1, i+1);
			selected.remove(selected.size()-1); // 조합리스트에서 빼주기 (i+1로도 되나?)음?
		}
	}
	
	static int chikDist() {
		int cityChickDist=0;
		for (Pos h : house) {
			int chickDist = Integer.MAX_VALUE;
			for (Pos s : selected) { //한 집의 치킨 거리
				if(s.getDistance(h)<chickDist) {
					chickDist = s.getDistance(h);
				}
			}
			cityChickDist += chickDist;
		}
		return cityChickDist;
	}
	
	
}
class Pos implements Comparable<Pos>{
	int x,y;
	int pick; // 치킨집이 치킨거리에 있을 때 가중치 + 
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Pos o) {
		// TODO Auto-generated method stub
		return o.pick-this.pick;
	}
	public int getDistance(Pos p) {
		return Math.abs(this.x-p.x)+Math.abs(this.y-p.y);
	}
	
}


