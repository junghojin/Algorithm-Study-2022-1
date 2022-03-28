package ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_13424_dijkstra {
	
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
			return this.distance-o.distance;
		}
	}
	
	static void dijkstra(int start) {//, int end) {
		
		Arrays.fill(d, 49500000); // ?
		d[start]= 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, d[start]));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int now = node.index;
			int dist = node.distance;
			
			if(d[now]<dist) continue;
			
			for (int i = 0; i < graph.get(now).size(); i++) {
				if(d[graph.get(now).get(i).index] 
						> d[now]+graph.get(now).get(i).distance) {
					d[graph.get(now).get(i).index]=d[now]+graph.get(now).get(i).distance;
					pq.offer(new Node(graph.get(now).get(i).index, graph.get(now).get(i).distance));
				}
			}
		}

	}
	
	static ArrayList<ArrayList<Node>> graph;
	static int N,M,K; // 노드수 , 간선수, 친구수
	static int []d;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < TC; tc++) {
			graph = new ArrayList<ArrayList<Node>>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i <= N; i++) {
				graph.add(new ArrayList<Node>());
			}
			for (int i = 0; i < M; i++) { // 1~M ?
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				graph.get(a).add(new Node(b, c));
				graph.get(b).add(new Node(a, c));
			}
			
			K = Integer.parseInt(br.readLine());
			int [] friends = new int[K+1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= K; i++) {
				friends[i] = Integer.parseInt(st.nextToken());
			}
			
			int sum = 0;
			int min = Integer.MAX_VALUE;
			int ans = 0;
			d = new int[N+1];
			for (int i = 1; i <= N; i++) {
				sum = 0;
				dijkstra(i);
				for (int j = 1; j <= K; j++) {
					sum += d[friends[j]];
//					sum += dijkstra(i, friends[j]); // 시간초과
				}
				
				if(min>sum) { // 뒤에 같은 크기의 sum 이 있더라도 작지는 않으니까 앞에서부터 하는 ans
					min = sum;
					ans = i;
				}
			}
			System.out.println(ans);
			
			
		}
	}
}

