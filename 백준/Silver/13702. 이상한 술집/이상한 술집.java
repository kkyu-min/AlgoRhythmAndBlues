import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n,k;
    static int[] arr;

    static long check(long mid) {
        long sum = 0;
        for(int i=0;i<n;i++) {
            if(mid!=0) sum+=arr[i]/mid;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");

        n = Integer.parseInt(tmp[0]);
        k = Integer.parseInt(tmp[1]);

        arr = new int[n];
        long start = 1;
        long end = 0;
        long answer = 0;

        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(br.readLine());
            end = Math.max(end, arr[i]);
        }

        while(start<=end) {
            long mid = (start+end)/2;

            if(check(mid) >= k) {
                answer = mid;
                start = mid+1;
            }
            else if(check(mid) < k) {
                end = mid-1;
            }
        }

        System.out.println(answer);
    }
}
