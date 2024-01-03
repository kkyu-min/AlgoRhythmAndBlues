import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long A, B;
    static long calc(long n) {
        if(n==1) return 1;
        else if(n==0) return 0;
        else if(n%2 == 0) return ((n/2) + 2 * calc(n/2));
        else return (n/2+1) + 2*calc(n/2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");

        A = Long.parseLong(tmp[0]);
        B = Long.parseLong(tmp[1]);

        System.out.println(calc(B)-calc(A-1));
    }
}
