import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n;
    static int ans;
    static int[] dp;

//    static void recur(int cur) {
//        if(cur>n) return;
//        if(cur == n) {
//            ans++;
//            return;
//        }
//
//        recur(cur+1);
//        recur(cur+2);
//    }

    static int recur(int cur) {
        if(cur>n) return 0;
        if(cur==n) return 1;

        return (recur(cur+1) + recur(cur+2))%10007;
    }

    static int dp(int cur) {
        if(cur>n) return 0;
        if(cur==n) return 1;

        if(dp[cur]!=-1) return dp[cur];

        dp[cur] = (dp(cur+1) + dp(cur+2))%10007;
        return dp[cur];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        Arrays.fill(dp, -1);

        System.out.println(dp(0));
    }
}
