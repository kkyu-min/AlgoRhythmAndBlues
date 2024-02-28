import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n,m;
    static int[][] arr; // 방 정보
    static boolean[][] clear; // 청소 여부
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);

        arr = new int[n][m];
        clear = new boolean[n][m];

        tmp = br.readLine().split(" ");
        int x = Integer.parseInt(tmp[0]);
        int y = Integer.parseInt(tmp[1]);
        int d = Integer.parseInt(tmp[2]);

        for(int i=0;i<n;i++) {
            tmp = br.readLine().split(" ");
            for(int j=0;j<m;j++) {
                arr[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        boolean going = true;
        while(going) {
            // 청소
            if(arr[x][y]==0 && !clear[x][y]) {
                clear[x][y]=true;
                answer++;
            }
            // 이동 여부 확인
            boolean check = false;
            for(int i=0;i<4;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m) {
                    if(arr[nx][ny]==0 && !clear[nx][ny]) {
                        check = true;
                        break;
                    }
                }
            }
            // 이동
            if(check) { // 청소되지 않은 빈칸 존재
                d = (d+3)%4;
                if(arr[x+dx[d]][y+dy[d]]==0 && !clear[x+dx[d]][y+dy[d]]) {
                    x += dx[d];
                    y += dy[d];
                }
            }
            else { // 청소되지 않은 빈칸 존재 X
                // 1칸 후진 가능?
                int nx = x - dx[d];
                int ny = y - dy[d];
                if(arr[nx][ny]==0) {
                    x = nx;
                    y = ny;
                }
                else going=false;
            }
        }

        System.out.println(answer);
    }
}
