import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int tmp = 1;
        int answer = 0;

        while(true) {
            if(tmp * tmp>n) break;
            tmp++;
            answer++;
        }
        System.out.println(answer);

    }
}
