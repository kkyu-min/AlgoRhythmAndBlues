import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long a, d;

    static long gcd(long a, long b) {
        // a > b
        while(b != 0) {
            long tmp = b;
            b = a%b;
            a=tmp;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");

        a = Integer.parseInt(tmp[0]);
        d = Integer.parseInt(tmp[1]);

        int q = Integer.parseInt(br.readLine());

        for(int i=0;i<q;i++) {
            tmp = br.readLine().split(" ");
            long con = Integer.parseInt(tmp[0]);
            long l = Integer.parseInt(tmp[1]);
            long r = Integer.parseInt(tmp[2]);
            long al = a + ((l-1)*d);
            long ar = a + ((r-1)*d);

            if(con == 1) { // 등차수열
                long answer = ((r-l+1) * (al+ar)) /2;
                System.out.println(answer);
            }
            else { // 최대공약수
                if(l == r) {
                    System.out.println(al);
                }
                else {
                    System.out.println(gcd(a,d));
                }
            }
        }
    }
}
