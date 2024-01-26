import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main  {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);

        int[] arr = new int[n+1];
        for(int i=1;i<n+1;i++) {
            arr[i] = i;
        }

        for(int i=0;i<m;i++) {
            tmp = br.readLine().split(" ");

            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);

            int num = arr[b];
            arr[b] = arr[a];
            arr[a] = num;
        }

        for(int i=1;i<n+1;i++) {
           sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
}
