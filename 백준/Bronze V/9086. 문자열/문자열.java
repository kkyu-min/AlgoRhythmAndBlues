import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for(int t=0;t<n;t++) {
            String str = br.readLine();
            int index = str.length()-1;
            sb.append(str.charAt(0)).append(str.charAt(index)).append("\n");
        }

        System.out.println(sb);
    }
}
