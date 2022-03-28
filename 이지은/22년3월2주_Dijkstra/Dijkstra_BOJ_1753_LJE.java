package ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	private int index;
	private int distance;
	public Node(int index, int distance) {
		super();
		this.index = index;
		this.distance = distance;
	}
	public int getIndex() {
		return index;
	}
	public int getDistance() {
		return distance;
	}
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.distance - o.distance;
	}

	
	
}


public class Main_1753_Dijkstra { // 최단 경로
	
	static final int INF = (int)1e9;
	static int V,E,K; // 정점 개수, 간선 개수 , 시작정점
	static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	static int[] d = new int[20001];
	
	static void dijkstra(int start) {
		d[start] = 0;
		PriorityQueue<Node> pQueue = new PriorityQueue<Node>();
		pQueue.offer(new Node(start, d[start]));
		
		while(!pQueue.isEmpty()) {
			//단계 1 : 최소 비용이 확정되지 않은 정점 중 최소 비용의 정점 선택
			Node node = pQueue.poll();
			int current = node.getIndex(); // 현재 노드
			int dist = node.getDistance(); // 현재 노드까지의 비용
			
			//현재 노드가 이미 처리된 적 있으면 넘어가기
			if(d[current]<dist) {
				continue;
			}
			
			//단계 2 : 선택된 정점을 경유지로 하여 아직 최소비용이 확정되지 않은 다른 정점의 최소비용 고려
			for (int i = 0; i < graph.get(current).size(); i++) {
				if(d[graph.get(current).get(i).getIndex()] 
						> d[current] + graph.get(current).get(i).getDistance()) {
					d[graph.get(current).get(i).getIndex()] = d[current] + graph.get(current).get(i).getDistance();
					pQueue.offer(new Node(graph.get(current).get(i).getIndex(), 
							d[current] + graph.get(current).get(i).getDistance()));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		for (int i = 0; i <= V; i++) { //그래프 초기화
			graph.add(new ArrayList<Node>());
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.get(u).add(new Node(v, w));
		}
		
		Arrays.fill(d, Integer.MAX_VALUE);
//		Arrays.fill(d, INF);
		dijkstra(K);
		
		for (int i = 1; i <= V; i++) {
			if(d[i]==Integer.MAX_VALUE) {
				System.out.println("INF");
			}
			else {
				System.out.println(d[i]);
			}
		}
		
	}

}
