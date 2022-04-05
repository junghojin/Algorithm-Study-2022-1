// BOJ_1753

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753 {
    static final int INF=(int)1e9;
    static int n,m,start;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    static int[] d;
    static class Node implements Comparable<Node>{
        int index;
        int distance;

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
        StringTokenizer st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        d = new int[n+1];
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<Node>());
        }
        for(int i=0;i<m;i++){
            st= new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            int c= Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b,c));
        }

        Arrays.fill(d,INF);
        dijkstra(start);
        for(int i=1;i<=n;i++){
            if(i==start){
                System.out.println(0);
            } else if(d[i]==INF){
                System.out.println("INF");
            }else {
                System.out.println(d[i]);
            }
        }

        br.close();
    }
    static void dijkstra(int start){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start,0));
        d[start]=0;
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            int now = temp.index;
            int dis = temp.distance;
            if(d[now]<dis) continue;
            for(int i=0;i<graph.get(now).size();i++){
                int cost = d[now] + graph.get(now).get(i).distance;
                if(cost<d[graph.get(now).get(i).index]){
                    d[graph.get(now).get(i).index]=cost;
                    queue.offer(new Node(graph.get(now).get(i).index,cost));
                }
            }
        }
    }
}