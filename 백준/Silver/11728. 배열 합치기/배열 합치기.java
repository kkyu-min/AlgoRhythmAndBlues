import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);

        int[] arr = new int[n+m];

        tmp = br.readLine().split(" ");
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(tmp[i]);
        }

        tmp = br.readLine().split(" ");
        for(int i=0;i<m;i++) {
            arr[n+i] = Integer.parseInt(tmp[i]);
        }

        Arrays.sort(arr);

        for (int i : arr) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
