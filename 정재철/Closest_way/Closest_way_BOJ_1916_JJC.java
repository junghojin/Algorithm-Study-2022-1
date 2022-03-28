// BOJ_1916

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1916 {
    static final int INF=(int)1e9;
    static int N, M;
    static int d[];
    static ArrayList<ArrayList<Node>> graph;

    static class Node implements Comparable<Node>{
        int index,distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        d = new int[N+1];
        Arrays.fill(d,INF);
        graph = new ArrayList<>();
        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<Node>());
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b,c));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());


        System.out.println(dijkstra(start,end));
        br.close();
    }
    static int dijkstra(int start,int end){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        d[start]=0;
        queue.add(new Node(start, 0));
        while(!queue.isEmpty()){
            Node temp =queue.poll();
            int now = temp.index;
            int dis = temp.distance;
            if(d[now]<dis) continue;
            for(int i=0;i<graph.get(now).size();i++){
                int cost = d[now] + graph.get(now).get(i).distance;
                if(cost<d[graph.get(now).get(i).index]){
                    d[graph.get(now).get(i).index]=cost;
                    queue.add(new Node(graph.get(now).get(i).index,cost));
                }
            }
        }


        return d[end];
    }

}