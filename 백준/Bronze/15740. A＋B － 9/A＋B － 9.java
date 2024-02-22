import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");

        BigInteger a = new BigInteger(tmp[0]);
        BigInteger b = new BigInteger(tmp[1]);
        System.out.println(a.add(b).toString());
    }
}
