package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * 2021. 03. 16. 수  - 백준 14950번 - 정복자
 * 
 */

public class MST_boj_14950_JHJ {

	static int N, M, T, minEdge[];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		T = Integer.parseInt(stk.nextToken());
		minEdge = new int[N + 1]; // 다른 노드에서 자신으로 까지의 최소 비용
		ArrayList<ArrayList<Node>> nodeList = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			nodeList.add(new ArrayList<Node>());
			minEdge[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(stk.nextToken());
			int to = Integer.parseInt(stk.nextToken());
			int weight = Integer.parseInt(stk.nextToken());
			nodeList.get(from).add(new Node(to, weight));
			nodeList.get(to).add(new Node(from, weight));
		}
		// ========= input end =======================================

		System.out.println(mst(nodeList));
	}

	private static int mst(ArrayList<ArrayList<Node>> nodeList) {
		boolean[] visited = new boolean[N + 1];
		int totalCost = 0; // 노드를 연결하는 데 드는 최소 비용
		minEdge[1] = 0;

		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			int minNode = 0;
			int minCost = Integer.MAX_VALUE;

			for (int j = 1; j <= N; j++) {
				if (!visited[j] && minCost > minEdge[j]) {
					minNode = j;
					minCost = minEdge[j];
				}
			}

			visited[minNode] = true;

			if (cnt < 2)
				totalCost = minCost;
			else
				totalCost += minCost + (cnt - 1) * T;
			
			cnt++;
			for (int j = 0, size = nodeList.get(minNode).size(); j < size; j++) {
				Node connectedNode = nodeList.get(minNode).get(j);
				if (!visited[connectedNode.to] && minEdge[connectedNode.to] > connectedNode.weight) {
					minEdge[connectedNode.to] = connectedNode.weight;
				}
			}
		}
		return totalCost;
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
