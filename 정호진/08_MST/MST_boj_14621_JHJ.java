//package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;


/*
 * 2022. 03. 17. 목  - 백준 14621번 - 나만안되는 연애 - 프림
 * 
 */

public class MST_boj_14621_JHJ {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(stk.nextToken()); // 노드의 수
		int M = Integer.parseInt(stk.nextToken()); // 간선의 수
		LinkedList<LinkedList<Node>> graph = new LinkedList<>();

		// 노드가 남초인지 여초인지 리스트에 저장
		int[] genders = new int[N + 1]; // 1번 노드부터 시작하기 때문]
		graph.add(null); // 1번 노드부터 시작하기 때문
		stk = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			if (stk.nextToken().equals("M"))
				genders[i] = 1;
			else
				genders[i] = 2;
			graph.add(new LinkedList<Node>());
		}

		// 간선 정보 받아오기
		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(stk.nextToken());
			int to = Integer.parseInt(stk.nextToken());
			int weight = Integer.parseInt(stk.nextToken());

			// 무방향 그래프 = 양방향 그래프 - 노드 중심이기 때문에 각 노드에 연결된 노드의 정보를 추가한다.
			graph.get(from).add(new Node(to, weight));
			graph.get(to).add(new Node(from, weight));
		}

		// ---------------------------input end-----------------------------------
		System.out.println(prim(graph, N, genders));
	}

	/**
	 * 
	 * @param graph : 완성된 그래프
	 * @param N     : 노드의 개수
	 * @param genders : 성별 정보
	 */
	static int prim(LinkedList<LinkedList<Node>> graph, int N, int[] genders) {

		boolean visited[] = new boolean[N + 1]; // 노드의 방문 여부를 확인하는 그래프
		int[] minDistance = new int[N + 1]; // 해당 노드까지 도착하는데 걸린 최소 비용
		Arrays.fill(minDistance, Integer.MAX_VALUE);

		minDistance[1] = 0; // 1번 노드부터 시작하기 때문
		int totalMinDistance = 0; // 그래프의 노드를 모두 방문하는데 드는 최소 비용
		
		for (int i = 1; i <= N; i++) {
			int currentNode = 0; // 현재 방문할 노드 검색
			int minCost = Integer.MAX_VALUE; // 현재 방문할 노드의 간선 중 최소 비용
			// 다음 방문할 노드 중 최소비용을 가진 노드 선택
			for (int j = 1; j <= N; j++) {
				if (minDistance[j] < minCost && !visited[j]) {
					currentNode = j;
					minCost = minDistance[j];
				}
			}

			// 만약 minCost가 Integer.MAX_VALUE와 같다면 더이상 방문할 노드가 없다는 것을 의미하기 때문에 -1 리턴 (모든 노드가 연결될 수 없다는 의미)
			if(minCost == Integer.MAX_VALUE) {
				return -1;
			}
			
			visited[currentNode] = true;
			totalMinDistance += minCost;

			// 현재 방문한 노드와 연결된 노드의 거리가 해당 노드까지의 최소거리보다 작다면. 해당 노드까지의 최소 거리 갱신
			for (int j = 0, size = graph.get(currentNode).size(); j < size; j++) {
				Node connectedNode = graph.get(currentNode).get(j);
				if (minDistance[connectedNode.to] > connectedNode.weight && !visited[connectedNode.to] && genders[currentNode] != genders[connectedNode.to]) {
					minDistance[connectedNode.to] = connectedNode.weight;
				}
			}
		}
		return totalMinDistance;
	}

	private static class Node {
		int to;
		int weight;

		Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
}
