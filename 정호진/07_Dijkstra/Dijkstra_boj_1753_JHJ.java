
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//2022.03.08.화 - 백준 1753번 - 최단경로

public class Dijkstra_boj_1753_JHJ {

	static int N, E;
	static ArrayList<ArrayList<int[]>> graph;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(stk.nextToken());
		E = Integer.parseInt(stk.nextToken());
		int start = Integer.parseInt(br.readLine().trim());
		graph = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<int[]>());
		}

		for (int i = 0; i < E; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(stk.nextToken());
			int to = Integer.parseInt(stk.nextToken());
			int dis = Integer.parseInt(stk.nextToken());

			graph.get(from).add(new int[] { to, dis });

		}
		// ===================== input end ==========================

		int[] distance = Dijkstra(start);
		for (int i = 1; i < N + 1; i++) {
			if (distance[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(distance[i]);
		}
	}

	// 다익스트라 알고리즘
	private static int[] Dijkstra(int start) {

		int[] distance = new int[N + 1]; // from에서 to까지의 최소 거리
		PriorityQueue<Vertex> pQueue = new PriorityQueue<>();
		boolean[] visited = new boolean[N + 1]; // 최소 비용 확정 여부

		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		pQueue.offer(new Vertex(start, 0));

		while (!pQueue.isEmpty()) {
			// 최소비용이 확정되지 않은 정점 중 최소 비용의 정점 선택
			Vertex current = pQueue.poll();

			if (visited[current.no])
				continue;
			else
				visited[current.no] = true;

			// 선택된 정점을 경유지로 하여 아직 최소비용이 확정되지 않은 노드까지의 최소 거리 갱신
			for (int[] each : graph.get(current.no)) {
				if (!visited[each[0]] && distance[each[0]] > distance[current.no] + each[1]) {
					distance[each[0]] = distance[current.no] + +each[1];
					pQueue.offer(new Vertex(each[0], distance[each[0]]));
				}
			}
		}

		return distance;
	}

	private static class Vertex implements Comparable<Vertex> {
		int no; // 정점의 번호
		int minDistance; // 출발지에서 자신으로의 최소 비용

		Vertex(int no, int minDistance) {
			this.no = no;
			this.minDistance = minDistance;
		}

		@Override
		public int compareTo(Vertex o) {
			return minDistance - o.minDistance;
		}
	}

}
