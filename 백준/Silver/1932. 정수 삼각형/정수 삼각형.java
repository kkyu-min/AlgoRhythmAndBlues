import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[][] arr;
    static int[][] dp;

//    static void recur(int cur, int index, int sum) {
//        if(cur==n) {
//            answer = Math.max(answer, sum);
//            return;
//        }
//
//        recur(cur+1, index, sum+arr[cur][index]);
//        recur(cur+1, index+1, sum+arr[cur][index]);
//    }

    static int recur(int cur, int index) {
        if(cur==n) return 0;

        return Math.max(recur(cur+1, index) + arr[cur][index], recur(cur+1, index+1) + arr[cur][index]);
    }
    static int dp(int cur, int index) {
        if(cur==n) return 0;

        if(dp[cur][index]!=-1) return dp[cur][index];

        dp[cur][index] = Math.max(dp(cur+1, index) + arr[cur][index], dp(cur+1, index+1) + arr[cur][index]);
        return dp[cur][index];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new int[n][n];

        for(int i=0;i<n;i++) {
            String[] tmp = br.readLine().split(" ");
            for(int j=0;j<tmp.length;j++) {
                arr[i][j] = Integer.parseInt(tmp[j]);
            }
            for(int j=0;j<n;j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(dp(0,0));
    }
}
