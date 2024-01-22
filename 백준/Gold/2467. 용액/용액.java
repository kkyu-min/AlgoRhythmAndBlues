import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] tmp = br.readLine().split(" ");
        long[] arr = new long[n];
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(tmp[i]);
        }

        int start = 0;
        int end = n-1;
        int ans1 = 0;
        int ans2 = 0;

        long min = Long.MAX_VALUE;
        while(start < end) {
            long sum = arr[start] + arr[end];
            if(Math.abs(sum) <min) {
                ans1 = start;
                ans2 = end;
                min = Math.abs(sum);
            }
            if(sum <=0) start++;
            else end--;
        }
        System.out.println(arr[ans1] + " " + arr[ans2]);

    }
}
