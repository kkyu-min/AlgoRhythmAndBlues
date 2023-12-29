import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i=1;i<n+1;i++){
            String[] tmp = br.readLine().split(" ");

            sb.append("Case #").append(i).append(":").append(" ").append(Integer.parseInt(tmp[0]) + Integer.parseInt(tmp[1])).append("\n");
        }
        System.out.println(sb);
    }
}
