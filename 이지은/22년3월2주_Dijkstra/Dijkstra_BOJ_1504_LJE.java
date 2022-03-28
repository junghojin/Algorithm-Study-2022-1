package ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1504_Dijkstra {
	static class Node implements Comparable<Node>{
		int index;
		int distance;
		public Node(int index, int distance) {
			super();
			this.index = index;
			this.distance = distance;
		}
		
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.distance-o.distance;
		}
		
	}
	
	
	static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	static int N,E; //정점 개수, 간선 개수 E
	static int V1,V2; // 거쳐야하는 정점들
//	static int d[];
	static int MAX = 200000000;
	
	static int dijkstra(int start, int end) {
		int [] d = new int[N+1];
		Arrays.fill(d, MAX);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		d[start]= 0 ;
		pq.offer(new Node(start, d[start]));
		
		while(!pq.isEmpty()) {
			Node a = pq.poll();
			int now = a.index;
			int dist = a.distance;
			
			if(d[now]< dist) continue;
			
			for (int i = 0; i < graph.get(now).size(); i++) {
				if(d[graph.get(now).get(i).index] > d[now]+graph.get(now).get(i).distance) {
					d[graph.get(now).get(i).index] = d[now]+graph.get(now).get(i).distance;
					pq.add(new Node(graph.get(now).get(i).index,d[now]+graph.get(now).get(i).distance));
					
				}
				
			}
		}
		return d[end];
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i <= N ; i++) { // 그래프 초기화
			graph.add(new ArrayList<Node>());
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new Node(b, c));
			graph.get(b).add(new Node(a, c));
		}
		
		st = new StringTokenizer(br.readLine());
		V1 = Integer.parseInt(st.nextToken());
		V2 = Integer.parseInt(st.nextToken());
		
		
		
		
		//1->V1->V2->N
		int case1 = 0;
		case1 += dijkstra(1,V1);
		case1 += dijkstra(V1,V2);
		case1 += dijkstra(V2,N);
	
		//1->V2->V1->N
		int case2 = 0;
		case2 += dijkstra(1,V2);
		case2 += dijkstra(V2,V1);
		case2 += dijkstra(V1,N);
		
		System.out.println(Math.min(case1, case2) >=MAX ? -1 :Math.min(case1, case2));
	}

}
