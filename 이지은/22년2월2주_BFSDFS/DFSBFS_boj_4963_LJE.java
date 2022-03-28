package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DFSBFS_boj_4963_LJE {
	static int [][]deltas = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
	static int [][] map;
	static int w, h;
	public static boolean dfs(int x, int y) {
		if(x<=-1 || x>=h || y<=-1 || y>=w) return false;
		if(map[x][y]==1) {
			map[x][y] = 0;
			for(int i=0;i<8;i++) {
				dfs(x+deltas[i][0],y+deltas[i][1]);
			}
			return true;
		}
		
		return false;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new int[h][w];
			int island=0;
			if(w==0 && h == 0) {
				break;
			}
			for(int i = 0;i<h;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0;j<w;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i = 0;i<h;i++) {
				for(int j = 0;j<w;j++) {
					if(dfs(i,j)) {
						island++;
					}
				}
			}
			System.out.println(island);
		}
	}
}
