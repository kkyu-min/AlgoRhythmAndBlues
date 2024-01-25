import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n,k;
    static int[] arr;

    static long check(long mid) {
        long sum = 0;
        for(int i=0;i<k;i++) {
            sum+=arr[i]/mid;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");

        k = Integer.parseInt(tmp[0]);
        n = Integer.parseInt(tmp[1]);

        arr = new int[k];
        long start = 1;
        long end = 0;
        long answer = 0;

        for(int i=0;i<k;i++) {
            arr[i] = Integer.parseInt(br.readLine());
            end = Math.max(end, arr[i]);
        }

        while(start<=end){
            long mid = (start+end)/2;

            if(check(mid) >= n) {
                answer = mid;
                start = mid+1;
            }
            else {
                end = mid-1;
            }
        }
        System.out.println(answer);
    }
}
