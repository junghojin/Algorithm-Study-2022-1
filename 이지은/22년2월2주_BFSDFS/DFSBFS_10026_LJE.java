package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//dfs로 주변 색이 자기와 다르면 구역 +1
//적록색약인 사람은 초록을 빨강으로 덮어버리고 dfs
public class DFSBFS_10026_LJE { // 적록색약
	static char [][] map;
	static boolean [][] visited;
	static int [][] deltas= {{-1,0},{1,0},{0,-1},{0,1}};
	static int N;
	static char now;
	public static void dfs(int x, int y) {
		if(!visited[x][y]) {
			if(map[x][y] == now) {
				visited[x][y] = true;
				for(int i=0;i<4;i++) {
					int xx = x+deltas[i][0];
					int yy = y+deltas[i][1];
					if(xx>=0 && xx<N && yy>=0 && yy<N) {
						dfs(xx,yy);
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = s.charAt(j);
			}
		}
		int normal=0;
		int redgreen =0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visited[i][j]==false) {
					normal++;
					now = map[i][j]; //현재 rgb 
					dfs(i,j);

				}
				
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j] == 'G') { 
					map[i][j] = 'R';
				}
			}
		}
		for(int i=0;i<N;i++) { //초기화
			for(int j=0;j<N;j++) {
				visited[i][j] = false;
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visited[i][j]==false) {
					redgreen++;
					now = map[i][j];
					dfs(i,j);
				}
			}
		}
		
		System.out.println(normal+" "+redgreen);
		
	}

}
