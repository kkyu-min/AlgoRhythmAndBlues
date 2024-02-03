import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n, s;
    static int[] arr;
    static int answer;

    static void recur(int cur, int sum, int[] input) {
        if(cur==n) {
            if(sum==s) answer++;
            return;
        }

        input[cur] = 1;
        recur(cur+1, sum+arr[cur],input);

        input[cur] = 0;
        recur(cur+1, sum, input);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");

        n = Integer.parseInt(tmp[0]);
        s = Integer.parseInt(tmp[1]);

        arr = new int[n];

        tmp = br.readLine().split(" ");
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(tmp[i]);
        }

        int[] asd = new int[n];
        recur(0,0, asd);

        if(s==0) answer--;
        System.out.println(answer);
    }
}
