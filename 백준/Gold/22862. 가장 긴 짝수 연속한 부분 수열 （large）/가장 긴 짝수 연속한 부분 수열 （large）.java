import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int k = Integer.parseInt(tmp[1]);

        int[] arr = new int[n];
        tmp = br.readLine().split(" ");
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(tmp[i]);
        }

        int answer = 0;
        int start = 0;
        int end = 0;
        int cnt = 0;

        while(end < n) {
            if(cnt > k) {
                if(arr[start]%2 == 1) {
                    cnt--;
                }
                start++;
            }
            else {
                if(arr[end]%2==1) {
                    cnt++;
                }
                end++;
            }
            if(cnt <= k) {
                answer = Math.max(answer, end-start-cnt);
            }
        }
        System.out.println(answer);
    }
}
