import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        String[] tmp = br.readLine().split(" ");
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(tmp[i]);
        }
        int[] dp = new int[n+1];

        for(int i=0;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(arr[j]<arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int answer = -1;
        for(int i=0;i<n+1;i++) {
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer+1);
    }
}
