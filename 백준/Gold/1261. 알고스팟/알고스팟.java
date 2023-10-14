import static java.lang.Integer.parseInt;
import static java.lang.Integer.rotateRight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int n,m; // 미로 크기
    static int[][] arr;
    static class Node {
        int x; // x좌표
        int y; // y좌표
        int cnt; // 벽 부순 개수

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static int bfs(int x, int y) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> o1.cnt - o2.cnt);
        pq.add(new Node(x,y,0));

        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        boolean[][] visited = new boolean[n][m];
        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(now.x == n-1 && now.y==m-1){
                return now.cnt;
            }
            for(int i=0;i<4;i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m){
                    if(!visited[nx][ny]){
                        if(arr[nx][ny]==0){
                            visited[nx][ny]= true;
                            pq.add(new Node(nx,ny,now.cnt));
                        }
                        else{
                            visited[nx][ny]= true;
                            pq.add(new Node(nx,ny,now.cnt+1));
                        }
                    }
                }
            }
        }
        return 0;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        m = parseInt(tmp[0]);
        n = parseInt(tmp[1]);

        arr = new int[n][m]; // 미로

        for(int i=0;i<n;i++) {
            tmp = br.readLine().split("");
            for(int j=0;j<m;j++){
                arr[i][j] = parseInt(tmp[j]);
            }
        }

        System.out.println(bfs(0,0));
    }
}
