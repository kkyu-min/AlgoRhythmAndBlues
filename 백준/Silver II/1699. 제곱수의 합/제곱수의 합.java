import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int ans = Integer.MAX_VALUE;
    static int[][] dp;

//    static void recur(int cur, int sum, int cnt) {
//        if(sum > n || cur*cur>n) return;
//        if(sum == n) {
//            ans = Math.min(ans, cnt);
//            return;
//        }
//
//        // 고르는 경우
//        recur(cur, sum + (cur*cur), cnt+1);
//        recur(cur+1, sum + (cur*cur), cnt+1);
//        // 고르지 않는 경우
//        recur(cur+1, sum, cnt);
//    }

//    static int recur(int cur, int sum) {
//        if(sum > n || cur*cur>n) return 1000000;
//
//        if(sum == n) return 0;
//
//        int min = Math.min(recur(cur, sum+(cur*cur))+1, recur(cur+1, sum+(cur*cur))+1);
//        min = Math.min(min, recur(cur+1,sum));
//        return min;
//    }

    static int dp(int cur, int sum) {
        if(sum > n || (cur*cur)>n) return 1000000;

        if(sum==n) return 0;
        if(dp[cur][sum]!=0) {
            return dp[cur][sum];
        }

        dp[cur][sum] = Math.min(dp(cur, sum+(cur*cur))+1, dp(cur+1, sum+(cur*cur))+1);
        dp[cur][sum] = Math.min(dp[cur][sum], dp(cur+1, sum));
        return dp[cur][sum];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int num = 1;
        for(int i=0;i<n;i++) {
            if((num*num) >= n) break;
            num++;
        }
        dp = new int[num+1][n+1];

//        System.out.println(recur(1,0));
        System.out.println(dp(1,0));
    }
}
