import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n, m;
    static int[] arr;
    static long cnt;
    static long[][] dp;
    static StringBuilder sb = new StringBuilder();

//    static void recur(int cur, int sum, String str) {
//        if(sum>20 || sum<0) return;
//        if(cur==n-1) {
//            if(sum==m) {
//                cnt++;
//                str+="=";
//                str+=m;
//                sb.append(str).append("\n");
//            }
//            return;
//        }
//
//        // +
//        recur(cur+1, sum+arr[cur] , str+"+"+arr[cur]);
//        // -
//        recur(cur+1, sum-arr[cur] ,str+"-"+arr[cur]);
//    }

//    static int recur(int cur, int sum) {
//        if(sum>20 || sum<0) return 0;
//        if(cur==n-1){
//            if(sum==m) {
//                return 1;
//            }
//            return 0;
//        }
//
//        return recur(cur+1, sum+arr[cur]) + recur(cur+1, sum-arr[cur]);
//    }

    static long dp(int cur, int sum) {
        if(sum>20 || sum<0) return 0;
        if(cur==n-1) {
            if(sum==m) {
                return 1;
            }
            return 0;
        }

        if(dp[cur][sum]!=-1) return dp[cur][sum];

        dp[cur][sum] = dp(cur+1, sum+arr[cur]) + dp(cur+1, sum-arr[cur]);
        return dp[cur][sum];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n-1];
        dp = new long[n][22];

        String[] tmp = br.readLine().split(" ");
        for(int i=0;i<n-1;i++) {
            arr[i] = Integer.parseInt(tmp[i]);
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<22;j++) {
                dp[i][j] = -1;
            }
        }
        m = Integer.parseInt(tmp[n-1]);

        System.out.println(dp(1,arr[0]));
    }
}
