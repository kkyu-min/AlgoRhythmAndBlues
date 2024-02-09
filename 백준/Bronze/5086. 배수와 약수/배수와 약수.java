import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String[] tmp = br.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);

            if(a==0 && b==0) break;

            if(a>b && a%b==0) {
                sb.append("multiple").append("\n");
            }
            else if(a<b && b%a==0) {
                sb.append("factor").append("\n");
            }
            else{
                sb.append("neither").append("\n");
            }
        }

        System.out.println(sb);
    }
}
