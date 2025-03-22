import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int n,m;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);

        answer = n + m;

        System.out.println(answer);
    }
}
