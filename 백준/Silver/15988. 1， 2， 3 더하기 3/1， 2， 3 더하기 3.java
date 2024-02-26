import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static long[] dp;

//    static void recur(int cur) {
//        if(cur >n) return;
//        if(cur==n) {
//            answer++;
//            return;
//        }
//
//        recur(cur+1);
//        recur(cur+2);
//        recur(cur+3);
//    }

//    static int recur(int cur) {
//        if(cur>n) return 0;
//        if(cur==n) return 1;
//
//        return recur(cur+1) + recur(cur+2) + recur(cur+3);
//    }

//    static long dp(int cur) {
//        if(cur>1000001) return 0;
//        if(cur==1000001) return 1;
//
//        if(dp[cur]!=-1) return dp[cur];
//
//        dp[cur] = (dp(cur+1) + dp(cur+2) + dp(cur+3)) % 1000000009;
//        return dp[cur];
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int test = Integer.parseInt(br.readLine());

        dp = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=4;i<1000001;i++) {
            dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1000000009;
        }

        for(int t=0;t<test;t++) {
            n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }
        System.out.println(sb);
    }
}
