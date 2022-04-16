// BOJ_2412_암벽 등반
// 시간복잡도 : O(NlogN)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2412 {
    static int n,T;
    static ArrayList<Integer>[] key;
    static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        key = new ArrayList[200001];;
        for (int i = 0; i < 200001; i++) {
            key[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            key[b].add(a);
        }
        for (int i = 0; i < 200001; i++) {
            Collections.sort(key[i]);
        }
        System.out.println(bfs());
        br.close();
    }

    static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0));
        int count=0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Node temp = queue.poll();
                if(temp.y==T) return count;

                for (int y = temp.y - 2; y <= temp.y + 2; y++) {
                    if (y < 0 || y >= 200001) continue;
                    for (int j = 0; j < key[y].size(); j++) {
                        int x = key[y].get(j);
                        if (temp.x + 2 < x) break;
                        else if (temp.x - 2 > x) continue;

                        key[y].remove(j);
                        queue.add(new Node(x, y));
                        j--;
                    }
                }
            }
            count++;
        }


        return -1;
    }
}
