// BOJ_1865_웜홀

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1865 {
    static final int INF = (int) 1e9;
    static int N, M, W;
    static int[] dist;
    static ArrayList<ArrayList<Edge>> edges;
    static class Edge {
        int to, distance;
        public Edge(int to, int distance) {
            this.to = to;
            this.distance = distance;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= TC; test_case++) {
            /* ==========input========== */
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            dist = new int[N + 1];
            edges = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                edges.add(new ArrayList<>());
            }
            for (int i = 0; i < M; i++) { // 도로는 방향이 없다.
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                edges.get(a).add(new Edge(b, c));
                edges.get(b).add(new Edge(a, c));
            }
            for (int i = 0; i < W; i++) { // 웜홀은 방향이 있으며 음수를 취한다.
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                edges.get(a).add(new Edge(b, -c));
            }
            /* ==========sol========== */
            boolean success = false;
            for (int i = 1; i <= N; i++) {
                if (bellman(i)) {
                    success = true;
                    break;
                }
            }
            if (success) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            /* ==========output========== */
        }
        br.close();
    }
    /* ==========bellman========== */
    static boolean bellman(int start) {
        Arrays.fill(dist, INF);
        dist[start] = 0;
        boolean update = false;
        for (int i = 0; i < N - 1; i++) {
            update = false;
            for (int j = 1; j <= N; j++) {
                for (Edge edge : edges.get(j)) {
                    if (dist[j] != INF && dist[edge.to] > dist[j] + edge.distance) {
                        dist[edge.to] = dist[j] + edge.distance;
                        update = true;
                    }
                }
            }
            if (!update) {
                break;
            }
        }
        if(update){
            for (int i = 1; i <= N; i++) {
                for (Edge edge : edges.get(i)) {
                    if (dist[i] != INF && dist[edge.to] > dist[i] + edge.distance) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
