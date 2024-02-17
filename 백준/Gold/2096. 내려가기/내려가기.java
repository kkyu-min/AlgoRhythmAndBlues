import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[][] arr;
    static int[][] dp;
    static int ans1 = Integer.MAX_VALUE;
    static int ans2 = Integer.MIN_VALUE;

//    static void min(int cur, int sum, int now) {
//        if(cur==n) {
//            ans1 = Math.min(sum, ans1);
//            return;
//        }
//
//        if(now == 0) {
//            min(cur+1, sum+arr[cur][0], 0);
//            min(cur+1, sum+arr[cur][1], 1);
//        }
//        else if(now == 2) {
//            min(cur+1, sum+arr[cur][1], 1);
//            min(cur+1, sum+arr[cur][2], 2);
//        }
//        else {
//            min(cur+1, sum+arr[cur][0], 0);
//            min(cur+1, sum+arr[cur][2], 1);
//            min(cur+1, sum+arr[cur][2], 2);
//        }
//    }

    static int recur(int cur, int now) {
        if(cur==n) return 0;

        if(now == 0) {
            return Math.min(recur(cur+1, 0)+arr[cur][0] , recur(cur+1, 1)+arr[cur][1]);
        }
        else if(now == 2) {
            return Math.min(recur(cur+1, 2)+arr[cur][2] , recur(cur+1, 1)+arr[cur][1]);
        }
        else {
            return Math.min(recur(cur+1,0)+arr[cur][0], Math.min(recur(cur+1, 2)+arr[cur][2] , recur(cur+1, 1)+arr[cur][1]));
        }
    }

    static int dpMin(int cur, int now) {
        if(cur==n) return 0;

        if(dp[cur][now]!=-1) return dp[cur][now];

        if(now == 0) {
            dp[cur][now] = Math.min(dpMin(cur+1, 0)+arr[cur][0] , dpMin(cur+1, 1)+arr[cur][1]);
        }
        else if(now == 2) {
            dp[cur][now] = Math.min(dpMin(cur+1, 2)+arr[cur][2] , dpMin(cur+1, 1)+arr[cur][1]);
        }
        else {
            dp[cur][now] = Math.min(dpMin(cur+1,0)+arr[cur][0], Math.min(dpMin(cur+1, 2)+arr[cur][2] , dpMin(cur+1, 1)+arr[cur][1]));
        }
        return dp[cur][now];
    }

    static int dpMax(int cur, int now) {
        if(cur==n) return 0;

        if(dp[cur][now]!=-1) return dp[cur][now];

        if(now == 0) {
            dp[cur][now] = Math.max(dpMax(cur+1, 0)+arr[cur][0] , dpMax(cur+1, 1)+arr[cur][1]);
        }
        else if(now == 2) {
            dp[cur][now] = Math.max(dpMax(cur+1, 2)+arr[cur][2] , dpMax(cur+1, 1)+arr[cur][1]);
        }
        else {
            dp[cur][now] = Math.max(dpMax(cur+1,0)+arr[cur][0], Math.max(dpMax(cur+1, 2)+arr[cur][2] , dpMax(cur+1, 1)+arr[cur][1]));
        }
        return dp[cur][now];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][3];
        dp = new int[n][3];
        for(int i=0;i<n;i++) {
            String[] tmp = br.readLine().split(" ");
            for(int j=0;j<3;j++) {
                arr[i][j] = Integer.parseInt(tmp[j]);
                dp[i][j] = -1;
            }
        }

        for(int i=0;i<3;i++) {
            ans1 = Math.min(ans1, dpMin(0,i));
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<3;j++) {
                dp[i][j] = -1;
            }
        }

        for(int i=0;i<3;i++) {
            ans2 = Math.max(ans2, dpMax(0,i));
        }
        System.out.println(ans2+ " " + ans1);
    }
}
