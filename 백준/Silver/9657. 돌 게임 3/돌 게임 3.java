import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[] arr = new int[]{1,3,4};
    static int[] dp;
    static int recur(int cur) { // 현재 내 앞에 cur개 있을 때 이기는지 지는지
        if(cur < 0) return 1;
        if(cur==0) return 0;

        if(dp[cur]!=-1) {
            return dp[cur];
        }

        int cnt = 0;
        for(int i=0;i<3;i++) {
            if(recur(cur-arr[i])==0) cnt++;
        }
        if(cnt>0) {
            dp[cur] = 1;
            return dp[cur];
        }
        else {

            dp[cur]=0;
            return dp[cur];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        for(int i=0;i<n+1;i++){
            dp[i]=-1;
        }


        if(recur(n)==1) {
            System.out.println("SK");
        }
        else {
            System.out.println("CY");
        }
    }
}
