import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n,m;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    static void recur(int cur) {
        if(cur == m) {
            for(int i=0;i<m;i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0;i<n;i++) {
            if(visited[i]) continue;
            arr[cur] = i+1;
            visited[i] = true;
            recur(cur+1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");

        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);

        arr = new int[m];
        visited = new boolean[n];

        recur(0);
        System.out.println(sb);
    }
}
