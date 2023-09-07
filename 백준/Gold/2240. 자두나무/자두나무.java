import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int t,w;
    static int[] arr;
    static int[][] dp;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        t = parseInt(tmp[0]);
        w = parseInt(tmp[1]);

        arr = new int[t+1];
        arr[0] = 1;
        for(int i=1;i<t+1;i++) {
            arr[i] = parseInt(br.readLine());
        }

        dp = new int[w+1][t+1];
        int count = 0;
        for(int i=1;i<t+1;i++) {
            if(arr[i] == 1) count++;
            dp[0][i] = count;
        }

        answer = dp[0][t];
        int tree = 0;
        for(int i=1;i<w+1;i++){
            if(i%2==0) tree = 1;
            else tree=2;
            for(int j=1;j<t+1;j++) {
                if(tree == arr[j]){ // 떨어지는 위치와 자두 같을때
                    // O or X
                    dp[i][j] = Math.max(dp[i][j-1] + 1, dp[i-1][j]);
                }
                else { // 떨어지는 위치와 자두 위치 다를때
                    // O or X
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
            answer = Math.max(answer, dp[i][t]);
        }

        System.out.println(answer);
    }
}
