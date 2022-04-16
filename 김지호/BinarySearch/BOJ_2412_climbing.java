package study_04_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
 * 2412_암벽등반 - BFS, 암벽등반
 * x, y를 오름차순 정렬
 * 자신의 왼쪽, 오른쪽 각각 2보다 크고 작은 지점들만 탐색
 * 
 * */

public class BOJ_2412_binarysearch {
	static ArrayList<Node> list;
	static int n, T;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<Node>();
		list.add(new Node(0,0,0,0));
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list.add(new Node(x,y,0,0));
		}
		
		Collections.sort(list);
		for (int i = 0; i <= n; i++) {
            list.get(i).idx = i;
        }
		
		System.out.println(bfs());
	}
	
	public static int bfs() {
		
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(list.get(0)); // 0,0 시작
        
        boolean[] visited = new boolean[n+1]; // 방문 체크
        
        while (!queue.isEmpty()) {
        	
            Node cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            
            //목표 높이 도달했을 때
            if(y==T) return cur.cnt;
            
            // x 좌표의 왼쪽으로 탐색
            for(int i=cur.idx-1; i>0; i--) {
            	Node next = list.get(i);
            	int nx = next.x;
            	int ny = next.y;
            	
            	if (!visited[next.idx]) { // 방문하지 않은 정점에
            		// |nx - x| ≤ 2이고 |ny - y| ≤ 2이면 (nx, ny)에서 (x, y)로 이동 가능
                    if (Math.abs(nx - x) <= 2 && Math.abs(ny - y) <= 2) { 
                    	queue.offer(new Node(nx, ny, next.idx, cur.cnt+1));
                    	visited[next.idx] = true;
                    	
                    } else if (Math.abs(nx - x) > 2 && Math.abs(ny - y) > 2) break;
                }
            }
            
            // x 좌표의 오른쪽으로 탐색
            for(int i=cur.idx+1; i<=n; i++) {
            	Node next = list.get(i);
            	int nx = next.x;
            	int ny = next.y;
            	
            	if (!visited[next.idx]) {
                    if (Math.abs(nx - x) <= 2 && Math.abs(ny - y) <= 2) {
                    	queue.offer(new Node(nx, ny, next.idx, cur.cnt+1));
                    	visited[next.idx] = true;
                    	
                    } else if (Math.abs(nx - x) > 2 && Math.abs(ny - y) > 2) break;
                }
            }
        }
        
        return -1;
    }
	
	static class Node implements Comparable<Node>{
		int x;
	    int y;
	    int idx;
	    int cnt;
	    
	    Node(int x, int y, int idx, int cnt) {
	    	this.x = x;
	        this.y = y;
	        this.idx = idx;
	        this.cnt = cnt;
	    }
	    
	    @Override
	    public int compareTo(Node o) {
	    	if(this.x == o.x) return this.y - o.y;
	    	return this.x - o.x;
	    }
	}
}
