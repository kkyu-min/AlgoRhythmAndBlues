import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static long cnt;
    static long[][][] dp;

//    static void recur(int cur, int w, int h) {
//        if(w<0 || h<0) return;
//        if(cur==2*n-2) {
//            cnt++;
//            return;
//        }
//
//        recur(cur+1, w-1, h+1);
//        recur(cur+1, w, h-1);
//    }

    static int recur(int cur, int w, int h) {
        if(w<0 || h<0) return 0;
        if(cur==2*n-2) return 1;

        return recur(cur+1, w-1, h+1) + recur(cur+1, w, h-1);
    }

    static long dp(int cur, int w, int h) {
        if(w<0 || h<0) return 0;
        if(cur==2*n-2) return 1;

        if(dp[cur][w][h]!=-1) return dp[cur][w][h];

        dp[cur][w][h] = dp(cur+1, w-1, h+1) + dp(cur+1, w, h-1);
        return dp[cur][w][h];
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
           n = Integer.parseInt(br.readLine());
           if(n == 0) break;

//           recur(0,n-1,1);
//           sb.append(cnt).append("\n");
//           cnt=0;
//           sb.append(recur(0,n-1,1)).append("\n");

           dp = new long[2*n][n][n+1];
           for(int i=0;i<2*n;i++) {
               for(int j=0;j<n;j++) {
                   for(int k=0;k<n+1;k++) {
                       dp[i][j][k] = -1;
                   }
               }
           }

           sb.append(dp(0,n-1,1)).append("\n");
        }

        System.out.println(sb);
    }
}
