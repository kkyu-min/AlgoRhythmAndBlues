import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] tmp = br.readLine().split(" ");

        int a = Integer.parseInt(tmp[0]);
        int b = Integer.parseInt(tmp[1]);

        for(int i=-1000;i<1001;i++) {
            if((i*i + 2 * a *i + b)==0) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }
}
