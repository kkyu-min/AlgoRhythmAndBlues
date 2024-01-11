import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);

        int[][] arr = new int[n+1][n+1];

        for(int i=0;i<n;i++) {
            tmp = br.readLine().split(" ");
            for(int j=0;j<n;j++){
                arr[i+1][j+1] = Integer.parseInt(tmp[j]);
            }
        }
        // 누적합 구하기
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                arr[i][j] += arr[i-1][j] + arr[i][j-1] -arr[i-1][j-1];
            }
        }

        for(int i=0;i<m;i++) {
            tmp = br.readLine().split(" ");
            int x1 = Integer.parseInt(tmp[0]);
            int y1 = Integer.parseInt(tmp[1]);
            int x2 = Integer.parseInt(tmp[2]);
            int y2 = Integer.parseInt(tmp[3]);
            sb.append(arr[x2][y2] - arr[x1-1][y2] - arr[x2][y1-1] + arr[x1-1][y1-1]).append("\n");
        }
        System.out.println(sb);
    }
}
