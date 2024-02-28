import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] a = br.readLine().split("");
        String[] b = br.readLine().split("");

        int[][] dp = new int[a.length+1][b.length+1];
        int answer = -1;

        for(int i=0;i<a.length+1;i++) {
            for(int j=0;j<b.length+1;j++) {
                if(i==0 || j==0) dp[i][j]=0;
                else if(a[i-1].equals(b[j-1])) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                answer = Math.max(answer, dp[i][j]);
            }
        }

//        for(int i=0;i<a.length+1;i++) {
//            for(int j=0;j<b.length+1;j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
        System.out.println(answer);
    }
}
