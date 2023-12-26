import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int k = Integer.parseInt(tmp[1]);
        int answer = Integer.MIN_VALUE;

        int[] arr = new int[n];
        tmp = br.readLine().split(" ");

        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(tmp[i]);
        }

        for(int i=0;i<=n-k;i++) {
            int num = 0;
            for(int j=0;j<k;j++) {
                num+=arr[i+j];
            }
            answer = Math.max(num, answer);
        }

        System.out.println(answer);
    }
}
