import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static int n,m;
    static int[][] arr; // 비의 양
    static boolean[][] exist; // 구름 존재 여부 배열
    static ArrayList<int[]> cloud = new ArrayList<>(); // 구름 위치

    static void toCloud() { // exist로 cloud 완성하기
        cloud = new ArrayList<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(exist[i][j]) cloud.add(new int[]{i,j});
            }
        }
    }
    static void toExist() { // cloud로 exist 완성하기
        exist = new boolean[n][n];
        for(int[] point: cloud) {
            exist[point[0]][point[1]]=true;
        }
    }

    static void move(int d, int s) { // d방향으로 s만큼 이동
        int[] dx = {0,0,-1,-1,-1,0,1,1,1};
        int[] dy = {0,-1,-1,0,1,1,1,0,-1};

        for(int[] point: cloud) {
            int x = point[0];
            int y = point[1];

            for(int i=0;i<s;i++) {
                x = (x + dx[d] + n) % n;
                y = (y + dy[d] + n) % n;
            }
            point[0] = x;
            point[1] = y;
        }

        // 동기화
        toExist();
    }

    static void rain() {
        for(int[] point: cloud) {
            arr[point[0]][point[1]]+=1;
        }
    }

    static void bug() {
        int[] dx = {-1,-1,1,1};
        int[] dy = {-1,1,1,-1};

        int[][] copy = new int[n][n];
        for(int i=0;i<n;i++) {
            copy[i] = arr[i].clone();
        }

        // copy 배열 확인후 원본(arr) 배열 업데이트
        for(int[] point : cloud) {
            for(int i=0;i<4;i++) {
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<n) {
                    if(copy[nx][ny]>=1) {
                        arr[point[0]][point[1]]++;
                    }
                }
            }
        }

    }

    static void make() {
        cloud = new ArrayList<>();

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(arr[i][j]>=2 && !exist[i][j]) {
                    cloud.add(new int[]{i,j});
                    arr[i][j]-=2;
                }
            }
        }

        toExist();
    }

    static void print() {
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);

        arr = new int[n][n];
        exist = new boolean[n][n];

        for(int i=0;i<n;i++) {
            tmp = br.readLine().split(" ");
            for(int j=0;j<n;j++) {
                arr[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        // 구름 위치 초기화
        exist[n-1][0]=true;
        exist[n-1][1]=true;
        exist[n-2][0]=true;
        exist[n-2][1]=true;
        toCloud();

        for(int i=0;i<m;i++) {
            tmp = br.readLine().split(" ");

            int d = Integer.parseInt(tmp[0]);
            int s = Integer.parseInt(tmp[1]);
            move(d,s);
            rain();
            bug();
            make();
        }

        int answer = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                answer+=arr[i][j];
            }
        }

        System.out.println(answer);
    }
}
