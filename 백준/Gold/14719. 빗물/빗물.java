import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp= br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);

        int total = 0;
        int[] arr = new int[m+1];

        tmp = br.readLine().split(" ");
        for(int i=0;i<m;i++) {
            arr[i+1] = Integer.parseInt(tmp[i]);
            total+=arr[i+1];
        }

        int[] prefix = new int[m+2];
        int[] suffix = new int[m+2];

        for(int i=1;i<=m;i++) {
            prefix[i] = Math.max(arr[i], prefix[i-1]);
            suffix[m+1-i] = Math.max(arr[m+1-i], suffix[m-i+2]);
        }

        int answer =0;

        for(int i=1;i<=m;i++) {
            answer += Math.min(prefix[i], suffix[i]);
        }
        System.out.println(answer-total);
    }
}
