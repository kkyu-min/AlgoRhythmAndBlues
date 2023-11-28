import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static int n;
    static int answer = 0;
    static int highest = 0;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] arr;

    static void bfs(int x, int y, int high, boolean[][] visited) {
        Queue<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{x,y});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            for(int i=0;i<4;i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<n){
                    if(arr[nx][ny] > high && !visited[nx][ny]){
                        queue.add(new int[]{nx,ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for(int i=0;i<n;i++){
            String[] tmp = br.readLine().split(" ");
            for(int j=0;j<n;j++) {
                arr[i][j] = Integer.parseInt(tmp[j]);
                highest = Integer.max(highest, arr[i][j]);
            }
        }

        // 높이 1씩 증가하며 개수 세기
        for(int k=0;k<highest+1;k++) {
            boolean[][] visited = new boolean[n][n];
            // 방문하지 않았고, 물 안찬곳
            int num = 0;
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if(arr[i][j]>k && !visited[i][j]){
                        num++;
                        // bfs 돌려서 안전영역 체크하기
                        bfs(i,j,k,visited);
                    }
                }
            }
//            System.out.println(num);
            answer = Integer.max(answer, num);
        }

        System.out.println(answer);
    }
}
