import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n =Integer.parseInt(br.readLine());
        int[] arr = new int[1001];

        for(int i=0;i<n;i++) {
            String[] tmp = br.readLine().split(" ");
            arr[Integer.parseInt(tmp[0])] = Integer.parseInt(tmp[1]);
        }

        int[] prefix = new int[1002];
        prefix[0] = arr[0];
        int[] suffix = new int[1002];
        suffix[1001] = arr[1000];

        for(int i=1;i<1001;i++) {
            prefix[i] = Math.max(prefix[i-1], arr[i]);
            suffix[1001-i] = Math.max(suffix[1002-i], arr[1001-i]);
        }

        int answer = 0;
        for(int i=0;i<1002;i++) {
            answer+=Math.min(prefix[i],suffix[i]);
        }

        System.out.println(answer);
    }
}
