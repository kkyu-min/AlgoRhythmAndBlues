import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());

    int[] arr = new int[n+1];
    String[] tmp = br.readLine().split(" ");
    for(int i=1;i<=n;i++) {
        arr[i] = Integer.parseInt(tmp[i-1]) + arr[i-1];
    }

    int m = Integer.parseInt(br.readLine());
    for(int i=0;i<m;i++) {
        tmp = br.readLine().split(" ");
        int start = Integer.parseInt(tmp[0]);
        int end = Integer.parseInt(tmp[1]);
        sb.append(arr[end]-arr[start-1]).append("\n");
    }
    System.out.println(sb);
}
}
