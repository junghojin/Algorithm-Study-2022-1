package study_04_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 2412_암벽등반 - BFS, 암벽등반
 * bfs로만 구현했을 때 시간초과
 * 
 * Arraylist contains 연산 : O(n), set contains 연산 : O(1)
 * 
 * */
public class BOJ_2412_BFS {
	static HashSet<Node> set;
	static int n, T;
	static int[] dx = {-2, -1, 0, 1, 2};
	static int[] dy = {-2, -1, 0, 1, 2};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		set = new HashSet<Node>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			set.add(new Node(x,y,0));
		}
		
		System.out.println(bfs());
	}
	
	public static int bfs() {
		Queue<Node> queue = new LinkedList<Node>();
        queue.offer(new Node(0,0,0)); // 0,0 시작 정점
                
        while (!queue.isEmpty()) {
        	Node cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
//            System.out.println(x+" "+y+" "+cur.cnt);
            
            //목표 높이 도달했을 때
            if(y==T) return cur.cnt;
            
            for(int i=0; i<5; i++) {
            	for(int j=0; j<5; j++) {
            		int nx = x + dx[i];
            	    int ny = y + dy[j];
            	    
            	    if(set.contains(new Node(nx,ny,0))) {
            	    	queue.add(new Node(nx,ny,cur.cnt+1));
            	    	set.remove(new Node(nx,ny,0));
            	    }
            	}
            }
        }
        return -1;
    }
	
	static class Node{
		int x;
	    int y;
	    int cnt;
	    
	    Node(int x, int y, int cnt) {
	    	this.x = x;
	        this.y = y;
	        this.cnt = cnt;
	    }
	    
	    @Override
	    public boolean equals(Object t){
	        if(t instanceof Node){
	            return (x == ((Node)t).x) && (y == ((Node)t).y);
	        } else {
	            return false;
	        }
	    }
	    @Override
	    public int hashCode(){
	        return x;
	    }
	}
}
