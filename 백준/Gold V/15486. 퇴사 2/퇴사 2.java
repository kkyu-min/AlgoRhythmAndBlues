import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[][] info;
    static int[] dp;

    static int recur3(int cur) {
        if(cur>n) return Integer.MIN_VALUE;
        if(cur==n) return 0;

        if(dp[cur]!=-1) {
            return dp[cur];
        }
        dp[cur] = Math.max(recur3(cur+info[cur][0]) + info[cur][1] , recur3(cur+1));
        return dp[cur];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        info = new int[n][2];
        dp = new int[n+1];

        for(int i=0;i<n;i++) {
            String[] tmp = br.readLine().split(" ");
            info[i][0] = Integer.parseInt(tmp[0]);
            info[i][1] = Integer.parseInt(tmp[1]);
        }

        for(int i = n - 1; i >= 0; i--) {
            int nextDay = i + info[i][0];
            if(nextDay <= n) {
                dp[i] = Math.max(dp[i + 1], dp[nextDay] + info[i][1]);
            } else {
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[0]);
    }
}
