import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        long answer = 0;

        for(long i=2;i<=n/2;i++) {
            answer += (((n/i)-1)*i);
        }

        System.out.println(answer%=1000000);
    }
}
