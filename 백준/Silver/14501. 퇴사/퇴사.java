import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[][] arr;
    static int answer = Integer.MIN_VALUE;

    static void recur(int cur, int date, int sum) {
        if(cur == n) {
            if(date<=n){
                answer = Math.max(answer, sum);
            }
            return;
        }

        // 고르는 경우
        if(date<=cur || cur==0) {
            recur(cur+1, cur+ arr[cur][0], sum+arr[cur][1]);
        }
        // 고르지 않는 경우
        recur(cur+1, date, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];

        for(int i=0;i<n;i++) {
            String[] tmp = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(tmp[0]);
            arr[i][1] = Integer.parseInt(tmp[1]);
        }

        recur(0,0,0);
        System.out.println(answer);
    }
}
