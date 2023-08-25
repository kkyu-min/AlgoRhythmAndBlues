import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)-> o1.weight - o2.weight);

        Arrays.fill(distance, INF);
        distance[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(distance[now.to] < now.weight) continue;
            for(int i=0;i<arr.get(now.to).size();i++) {
                Node next = arr.get(now.to).get(i);
                if(distance[next.to] > next.weight + distance[now.to]) {
                    distance[next.to] = next.weight + distance[now.to];
                    pq.add(new Node(next.to, distance[next.to]));
                }
            }
        }
        return distance[end];
    }

    static final int INF = 200000000;
    static int n, e; // 노드, 간선 개수
    static int v1, v2; // 필수로 지나야 하는 노드
    static ArrayList<ArrayList<Node>> arr = new ArrayList<>(); // 그래프
    static int[] distance; // 최단 거리 테이블
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        n = parseInt(tmp[0]);
        e = parseInt(tmp[1]);
        for(int i=0;i<n+1;i++) {
            arr.add(new ArrayList<>());
        }
        distance = new int[n+1];

        for(int i=0;i<e;i++) {
            tmp = br.readLine().split(" ");
            int s = parseInt(tmp[0]);
            int e = parseInt(tmp[1]);
            int w = parseInt(tmp[2]);
            arr.get(s).add(new Node(e,w));
            arr.get(e).add(new Node(s,w));
        }
        tmp = br.readLine().split(" ");
        v1 = parseInt(tmp[0]);
        v2 = parseInt(tmp[1]);

        int res1 = 0;
        res1 += dijkstra(1,v1);
        res1 += dijkstra(v1,v2);
        res1 += dijkstra(v2,n);

        int res2 = 0;
        res2 += dijkstra(1,v2);
        res2 += dijkstra(v2,v1);
        res2 += dijkstra(v1,n);

        answer = (res1 >= INF && res2 >= INF) ? -1 : Math.min(res1, res2);
        System.out.println(answer);
    }
}
