import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    static int n,m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    static void recur(int cur, int start) {
        if(cur == m) {
            for(int i=0;i<m;i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=start;i<n;i++) {
            arr[cur] = i+1;
            recur(cur+1, i+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);

        arr = new int[m];

        recur(0,0);
        System.out.println(sb);
    }
}
