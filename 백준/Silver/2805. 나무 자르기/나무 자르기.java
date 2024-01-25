import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long[] arr;
    static int n;
    static long m;
    static long check(long height) {
        long sum = 0;
        for(int i=0;i<n;i++) {
            if((arr[i] - height)>0) {
                sum+=arr[i]-height;
            }
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        m = Long.parseLong(tmp[1]);

        tmp = br.readLine().split(" ");
        arr = new long[n];

        long start = 0;
        long end = 0;
        long answer = 0;

        for(int i=0;i<n;i++) {
            arr[i] = Long.parseLong(tmp[i]);
            end =Math.max(end, arr[i]);
        }

        while(start <= end) {
            long mid =(start+end)/2;

            if(check(mid)>=m) {
                answer=mid;
                start = mid+1;
            }
            else if(check(mid) < m) {
                end=mid-1;
            }
        }

        System.out.println(answer);
    }
}
