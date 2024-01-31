import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");

        int n = Integer.parseInt(tmp[0]);
        int k = Integer.parseInt(tmp[1]);

        for(int i=1;i<=n;i++) {
            if(n%i==0) k--;
            if(k==0) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}
