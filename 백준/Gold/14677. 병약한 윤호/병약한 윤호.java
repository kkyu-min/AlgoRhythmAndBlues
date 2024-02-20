import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[] arr;
    static int[][][] dp;

//    static void recur(int cur, int cnt, int start, int end, int now) {
//        if(cur==3*n) {
//            ans = cnt;
//            return;
//        }
//
//        if(now!=arr[start] && now!=arr[end]) {
//            return;
//        }
//
//        if(now == arr[start]) {
//            recur(cur+1, cnt+1, start+1, end, (now+1)%3);
//        }
//        if(now == arr[end]) {
//            recur(cur+1, cnt+1, start, end-1, (now+1)%3);
//        }
//    }

//    static int recur(int cur, int start, int end, int now) {
//        if(cur==3*n) {
//            return 0;
//        }
//
//        if(now!=arr[start] && now!=arr[end]) return -1000000;
//
//        int cnt = 0;
//        if(now==arr[start]) {
//            cnt = recur(cur+1, start+1, end, (now+1)%3)+1;
//        }
//        if(now==arr[end]) {
//            cnt = Math.max(cnt, recur(cur+1, start, end-1, (now+1)%3)+1);
//        }
//        return cnt;
//    }

    static int dp(int cur, int start, int end) {
        if(start>end) return 0;
        if(dp[cur][start][end]!=-1) {
            return dp[cur][start][end];
        }

        dp[cur][start][end]=0;
        if(cur==arr[start]) {
            dp[cur][start][end] = Math.max(dp[cur][start][end], dp((cur+1)%3, start+1, end)+1);
        }
        if(cur==arr[end]) {
            dp[cur][start][end] = Math.max(dp[cur][start][end], dp((cur+1)%3, start, end-1)+1);
        }
        return dp[cur][start][end];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new int[3][3*n][3*n];

        arr = new int[3*n];
        String[] tmp = br.readLine().split("");
        for(int i=0;i<3*n;i++) {
            if(tmp[i].equals("B")) arr[i]=0;
            else if(tmp[i].equals("L")) arr[i]=1;
            else arr[i]=2;
        }

        for(int i=0;i<3;i++) {
            for(int j=0;j<3*n;j++) {
                for(int k=0;k<3*n;k++) {
                    dp[i][j][k]=-1;
                }
            }
        }

//        recur(0,0,0, 3*n-1, 0);
//        System.out.println(ans);
//        System.out.println(recur(0,0,3*n-1,0));
        System.out.println(dp(0,0,3*n-1));
    }
}

