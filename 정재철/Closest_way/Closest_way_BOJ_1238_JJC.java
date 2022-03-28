// BOJ_1238

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1238 {
    static final int INF = (int)1e9;
    static int N,M,X,max=0;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int[] d;

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
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<Node>());
        }
        d= new int[N+1];
        for(int i=0;i<M;i++){
            st= new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            int c= Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b,c));
        }
        for(int i=1;i<=N;i++){
            int go = dijkstra(i,X);
            int back = dijkstra(X,i);
            max= Math.max(max,go+back);
        }

        System.out.println(max);
        br.close();
    }

    static int dijkstra(int start, int end){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start,0));
        Arrays.fill(d,INF);
        d[start]=0;
        while(!queue.isEmpty()){
            Node node =  queue.poll();
            int now = node.index;
            int dis = node.distance;
            if(d[now]<dis) continue;
            for(int i=0;i<graph.get(now).size();i++){
                int cost = d[now] + graph.get(now).get(i).distance;
                if(cost<d[graph.get(now).get(i).index]){
                    d[graph.get(now).get(i).index]=cost;
                    queue.offer(new Node(graph.get(now).get(i).index, cost));
                }
            }
        }
        return d[end];
    }
}