import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * BOJ_1865 : 부분합
 * 음수 순환 싸이클의 여부를 조사하는 그래프 문제
 * 시간복잡도 : O(VE)
 */

public class BOJ_1865_웜홀 {
	static int n,m,w;
	static ArrayList<Node>[] list;
	static int[] dist;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			// 입력 받기 : N개의 지점, M개의 도로, W개의 웜홀
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			list = new ArrayList[n+1]; // 인접 리스트 저장할 배열
			dist = new int[n+1]; // 최단 거리 저장할 배열
			Arrays.fill(dist, 987654321);
			
			for(int i=0; i<n+1; i++) {
				list[i] = new ArrayList<>();
			}
			
			// S : 시작, E : 도착, T : 가중치 (양방향)
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				
				list[s].add(new Node(e,t));
				list[e].add(new Node(s,t));
				
			}
			
			// 웜홀 S : 시작, E : 도착, T : 가중치 (단방향)
			for(int i=0; i<w; i++) {
				st = new StringTokenizer(br.readLine());
				
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				
				list[s].add(new Node(e,-t));
			}
            
            if(bellmanFord()) System.out.println("YES");
			else System.out.println("NO");
			
		}
	}
	
	static boolean bellmanFord() {
		// 시작 정점
		dist[1] = 0;
		
		// n-1번 반복
		for(int i = 1; i < n; i++) {
			// 전체 간선 하나씩 조회
			for(int j = 1; j < list.length; j++) {
				for(Node node : list[j]) {
					// 각 간선을 거쳐 다른 노드로 가는 비용을 계산하여 최단 거리 테이블을 갱신
					if(dist[j] + node.weight < dist[node.end]) {
						dist[node.end] = dist[j] + node.weight;
					}
				}
			}
		}
		
		// dist[] 배열이 갱신이 되었으면 음수 사이클이 존재하니까 true 반환
		for(int j = 1; j < list.length; j++) {
			for(Node node : list[j]) {
				if(dist[j] + node.weight < dist[node.end]) {
					return true;
				}
			}
		}
		
		return false;
	}
	public static class Node{
	    int end; // 연결 노드
	    int weight; // 가중치
		
	    public Node(int end, int weight) {
	        this.end = end;
	        this.weight = weight;
	    }
	}

}
