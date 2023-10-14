import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static class Node {
        int x, y, weight;
        public Node(int x ,int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }
    static int N;
    static int[][] arr;
    static int[][] distance;
    static final int INF = Integer.MAX_VALUE;

    static int dijkstra() {
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)-> o1.weight - o2.weight);
        distance[0][0] = arr[0][0]; // 시작점
        pq.offer(new Node(0,0,arr[0][0]));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            for(int i=0;i<4;i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx>=0 && nx<N && ny>=0 && ny<N) {
                    if(distance[nx][ny] > distance[now.x][now.y] + arr[nx][ny]){
                        distance[nx][ny] = distance[now.x][now.y] + arr[nx][ny];
                        pq.offer(new Node(nx,ny,distance[nx][ny]));
                    }
                }
            }
        }
        return distance[N-1][N-1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int cnt = 1;

        while(true) {
            N = Integer.parseInt(br.readLine());
            if(N==0) break;

            arr = new int[N][N];
            distance = new int[N][N];
            for(int i=0;i<N;i++){
                String[] tmp = br.readLine().split(" ");
                for(int j=0;j<N;j++) {
                    arr[i][j] = Integer.parseInt(tmp[j]);
                    distance[i][j] = INF;
                }
            }
            sb.append("Problem " + cnt+": " + dijkstra() + "\n");
            cnt++;
        }

        System.out.println(sb);
    }
}
