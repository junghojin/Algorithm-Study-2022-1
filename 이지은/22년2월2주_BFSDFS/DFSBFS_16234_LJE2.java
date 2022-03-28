package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Value{ // 위치와 해당 값을 알기 위한 클래스
	int x;
	int y;
	int val;
	Value(int x,int y, int val){
		this.x = x;
		this.y = y;
		this.val = val;
	}
	@Override
	public String toString() {
		return "[x=" + x + ", y=" + y + ", val=" + val + "]";
	}
	
}


public class DFSBFS_16234_LJE2 { //인구 이동
	static Queue<Value> q; //주변을 탐색하기 위한 큐
	static Queue<Value> union;// 국경선을 열 수 있을 때 저장하기 위한 것
	static boolean [][] visited; // 하루동안 방문했는지 확인. -> 하루가 지나면 초기화 
	static int [][]map; // 처음에 입력을 받기 위한 이차원 배열
	static int N,L,R,sum; 
	static int deltas[][] = {{-1,0},{1,0},{0,-1},{0,1}}; // 상 하 좌 우
	
	public static void bfs(int i,int j, int x) {

		q.add(new Value(i,j,x));
		union.add(new Value(i,j,x));
		visited[i][j] = true;
		sum = map[i][j]; //나중에 연합되었을 때 인구 이동을 위해 sum 계산. 최초 연합할 수 있는 값으로 초기화
		while(!q.isEmpty()) { // 큐가 비지 않았을 경우에 
			Value a = q.poll();
			for(int d=0;d<4;d++) {
				int dx = a.x + deltas[d][0];
				int dy = a.y + deltas[d][1];
				if(dx>=0 && dx<N && dy>=0 && dy<N && !visited[dx][dy]) {
					int diff = Math.abs(map[a.x][a.y] - map[dx][dy]);
					if(diff>=L && diff<=R) { // 연합 할 수있을 경우
						sum += map[dx][dy];
						union.add(new Value(dx,dy,map[dx][dy])); // 연합국이라고 저장.
						q.add(new Value(dx,dy,map[dx][dy])); // 연합하기로 한 국가의 주변에 또 연합이 있을지 탐색 위해 큐에넣음
						visited[dx][dy] = true;
					}
				}
			}
			
			if(union.size()==1) { // 처음에 들어간 값만 있고 주변 연합국이 없는 경우
				union.poll(); // 연합국 리스트도 비워줌
				sum = 0; // sum 도 0으로 초기화
			}
			
		}
		
		
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		q = new LinkedList<>();
		union = new LinkedList<>();
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int [N][N];
		visited = new boolean [N][N];
		sum = 0;
		
		int day = 0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}//---입력 끝
		
		
		while(true) { 
			int unionCount = 0; // while문 빠져나가기 위한 변수
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(!visited[i][j]) { //방문처리가 되지 않은 것만 bfs 돌 수 있도록
						bfs(i,j,map[i][j]); //bfs를 하고나서 -> union이 비어있을 경우(국경선 열지X) / 채워져 있을 경우(국경선 열어)
						if(!union.isEmpty()) { 
							int size = union.size(); // 큐 길이 저장(안하고 for문에서 그대로 쓰면 poll하기 때문에 전부 출력되지 않음)
							int v = sum/union.size(); // 연합국 개수만큼 나누기
							for(int k = 0;k<size;k++) { // 연합국들 값 넣기
								Value a = union.poll();
								map[a.x][a.y] = v;
							}
							
							union.clear(); //하루에 다른 연합국이 있을 수도 있으니 인구이동 처리 다 한 연합국 큐를 비워줌.
							unionCount++; // 연합국 있으니까 개수 ++
						}
					}
				}
			}
			
			
			//더이상 이동할 수 없는 경우 종료. = 연합국개수가 없을 경우  
			if(unionCount == 0) {
				break;
			}else { //이동이 있었다면 
				day++; //날짜를 늘려주고 
				
				for(int l=0;l<N;l++) {//visited false로 초기화
					for(int m=0;m<N;m++) {
						visited[l][m] = false;
					}
				}
			}
			
		}
	
	
		
		
		System.out.println(day);
	}
}


