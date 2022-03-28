package ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
//	private int index;
//	private int distance;

	int index;
	int distance;
	
	public Node(int index, int distance) {
		super();
		this.index = index;
		this.distance = distance;
	}

//	public int getIndex() {
//		return index;
//	}
//
//	public int getDistance() {
//		return distance;
//	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.distance - o.distance;
	}
}

public class Main_14938_Dijkstra {
	static int N, M, R; // 지역 개수(정점개수), 수색범위, 길의 개수(간선개수)
	static int[] d;
	static int[] item;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	
	static int dijkstra(int start) {
		int num = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		d[start] = 0;
		pq.offer(new Node(start, d[start]));
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			int now = n.index; //n.getIndex();
			int dist = n.distance;//n.getDistance();
			
			if(d[now] < dist) {
				continue;
			}
			
			for (int i = 0; i < graph.get(now).size(); i++) {
				if(d[graph.get(now).get(i).index]> d[now] + graph.get(now).get(i).distance) {
					d[graph.get(now).get(i).index] = d[now] + graph.get(now).get(i).distance;
					pq.offer(new Node(graph.get(now).get(i).index,d[now] + graph.get(now).get(i).distance));
				}
			}
		}
		
		for (int i = 1; i <= N ; i++) {
			if(d[i]<=M) {
				num += item[i];
			}
		}
		return num;
		
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		d = new int[N+1];
		item = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i <= N ; i++) { // 그래프 초기화
			graph.add(new ArrayList<Node>());
		}
		
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node(b,l));
			graph.get(b).add(new Node(a,l));
		}

		
		
		int max = 0;
		for (int i = 1; i <= N ; i++) { // 모든정점에서 시작하는 경우의 수 헤아리기
			Arrays.fill(d, Integer.MAX_VALUE);
			max = Math.max(max, dijkstra(i));
		}
		System.out.println(max);
		
	}

}
