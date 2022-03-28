// BOJ_1504

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1504 {
    static final int INF = (int)1e9;
    static int N,E,v1,v2;
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
        E = Integer.parseInt(st.nextToken());
        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<Node>());
        }
        d= new int[N+1];
        for(int i=0;i<E;i++){
            st= new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            int c= Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b,c));
            graph.get(b).add(new Node(a,c));
        }
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        long temp1=0;
        temp1+=dijkstra(1,v1);
        temp1+=dijkstra(v1,v2);
        temp1+=dijkstra(v2,N);

        long temp2=0;
        temp2+=dijkstra(1,v2);
        temp2+=dijkstra(v2,v1);
        temp2+=dijkstra(v1,N);

        long result = Math.min(temp1,temp2);
        if(result>=INF){
            System.out.println(-1);
        }else {
            System.out.println(result);
        }
        br.close();
    }
    static int dijkstra(int start,int end){
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