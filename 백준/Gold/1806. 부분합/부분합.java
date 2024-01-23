import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int s = Integer.parseInt(tmp[1]);

        tmp = br.readLine().split(" ");

        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(tmp[i]);
        }

        int answer = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = 0;

        while(end <= n) {
            if(sum >= s) {
                answer = Math.min(answer, end-start);
                sum-=arr[start++];
            }
            else {
                if(end>=n) break;
                sum+=arr[end++];
            }
        }

        if (answer == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }
}
