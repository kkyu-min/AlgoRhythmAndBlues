import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");

        int n = Integer.parseInt(tmp[0]);
        int k = Integer.parseInt(tmp[1]);
        int b = Integer.parseInt(tmp[2]);

        int[] arr= new int[n+1];
        for(int i=0;i<b;i++) {
            arr[Integer.parseInt(br.readLine())]++;
        }

        for(int i=1;i<n+1;i++) {
            arr[i]+=arr[i-1];
        }

        int answer = Integer.MAX_VALUE;
        for(int i=1;i<=n+1-k;i++) {
            answer = Math.min(answer, arr[i+k-1] - arr[i-1]);
        }

        System.out.println(answer);
    }
}
