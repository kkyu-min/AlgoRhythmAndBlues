import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static int[][][] arr;
    static int m,n,h;
    static Queue<int[]> queue = new ArrayDeque<>();
    static int day = Integer.MIN_VALUE;

    static void bfs() {
        int[] dx = {0,0,-1,0,1,0};
        int[] dy = {0,0,0,1,0,-1};
        int[] dz = {1,-1,0,0,0,0};

        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int tmpx = tmp[0];
            int tmpy = tmp[1];
            int tmpz = tmp[2];
            int tmpday = tmp[3];

            for(int i=0;i<6;i++){
                int nx = tmpx + dx[i];
                int ny = tmpy + dy[i];
                int nz = tmpz + dz[i];

                if(nx>=0 && ny>=0 && nz>=0 && nx<n && ny<m && nz<h && arr[nx][ny][nz]==0) {
                    arr[nx][ny][nz] = 1;
                    queue.add(new int[] {nx ,ny, nz, tmpday+1});
                }
            }
            day = Math.max(day, tmpday);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        m = Integer.parseInt(tmp[0]);
        n = Integer.parseInt(tmp[1]);
        h = Integer.parseInt(tmp[2]);

        arr = new int[n][m][h];

        for(int i=0;i<h;i++){
            for(int j=0;j<n;j++){
                tmp = br.readLine().split(" ");
                for(int k=0;k<m;k++){
                    if(Integer.parseInt(tmp[k])==1){
                        queue.add(new int[] {j,k,i,0});
                    }
                    arr[j][k][i] = Integer.parseInt(tmp[k]);
                }
            }
        }
        bfs();

        boolean check = true;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int k=0;k<h;k++){
                    if(arr[i][j][k] == 0){
                        check = false;
                        break;
                    }
                }
            }
        }
        if (check) {
            System.out.println(day);
        }
        else {
            System.out.println(-1);
        }
    }
}
