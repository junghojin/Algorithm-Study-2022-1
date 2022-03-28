package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class DFSBFS_boj_1260_LJE {
	
	public static ArrayList<ArrayList<Integer>> graph;
	public static boolean[] visited; 
	
	
	public static void dfs(int x) {
		// 탐색노드 x 를 스택에 넣고(출력)&방문처리. 
		//현재 노드와 인접하면서 방문하지 않은 노드 재귀적으로 - 스택에 넣고 방문처리.
//		if(visited[x]) {
//			return;
//		}
		visited[x]= true;
		System.out.print(x + " ");
		// 현재 노드와 연결된 다른 노드를 재귀적으로 방문
        for (int i = 0; i < graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if (!visited[y]) dfs(y);
        }
	}
	
	public static void bfs(int start) {
		// 탐색 노드 x 큐에 삽입 & 방문처리. 
		//큐에서 노드 꺼내서 방문하지 않은 인접 노드 모두를 큐에 삽입 & 방문 처리
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visited[start] = true;
		while(!q.isEmpty()) {
			int x = q.poll();
			System.out.print(x+" ");
			for(int i=0;i<graph.get(x).size();i++) {
				int y = graph.get(x).get(i);
				if(!visited[y]) {
					q.offer(y);
					visited[y] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]); // 정점 개수
		int M = Integer.parseInt(s[1]); // 간선 개수
		int V = Integer.parseInt(s[2]); // 탐색 시작할 정점 번호 V

		graph = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<N+1;i++) { // 노드 0 이 아니라 1부터 시작하니까 1~N까지여서 범위를 N+1로 해야함
			graph.add(new ArrayList<Integer>()); // 그래프 초기화
		}
		
		for(int i=0;i<M;i++) {
			s = br.readLine().split(" ");
			//입력이 간선이 연결하는 두 정점의 번호니까
			// 각 정점이 연결하는 정보로 그래프에 저장함 - 쌍방
			graph.get(Integer.parseInt(s[0])).add(Integer.parseInt(s[1]));
			graph.get(Integer.parseInt(s[1])).add(Integer.parseInt(s[0]));
		}
		//System.out.println(graph); //정렬 전 
		for(int i=0;i<N+1;i++) { //dfs나 bfs를 할 때 번호가 낮은 순서부터 처리하기 위해
			Collections.sort(graph.get(i)); // 오름차순으로 정렬해준다.
		}
		System.out.println(graph); // 정렬 후 
		
		visited = new boolean[N+1]; //노드 0 이 아니라 1부터 시작하니까 1~N까지여서 범위를 N+1로 해야함
		dfs(V);
		
		System.out.println(); // 출력을 print 로만 해줘서 bfs 출력 위해 한줄 띄움
		
		//visited = new boolean[N+1]; //방문체크 초기화
		Arrays.fill(visited, false);
		bfs(V);
		
	}

}
/*
8 9 1
1 2
1 3
1 8
3 5
3 4
4 5
7 2
7 8
6 7



*/
