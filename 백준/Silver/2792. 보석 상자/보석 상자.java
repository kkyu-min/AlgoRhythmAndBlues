import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n,m;
    static int[] arr;

    static int check(int mid) {
        int sum =0;
        for(int i=0;i<m;i++) {
            int num=arr[i];

            sum+=num/mid;
            num%=mid;
            if(num >0) sum++;
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");

        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);

        arr = new int[m];
        int start = 1;
        int end = 0;
        int answer = 0;

        for(int i=0;i<m;i++){
            arr[i]= Integer.parseInt(br.readLine());
            end = Math.max(end, arr[i]);
        }

        while(start <= end) {
            int mid = (start+end)/2;

            if(check(mid) > n) {
                start=mid+1;
            }
            else {
                answer=mid;
                end=mid-1;
            }
        }
        System.out.println(answer);
    }
}
