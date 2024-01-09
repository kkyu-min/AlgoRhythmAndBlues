import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int count2(long a) {
        int count = 0;
        long num = 2;
        if(a < 2) return 0;
        while(num <= a){
            count += a/num;
            num*=2;
        }
        return count;
    }

    static int count5(long a) {
        int count = 0;
        long num = 5;
        if(a < 5) return 0;
        while(num <= a){
            count+=a/num;
            num*=5;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");


        long n = Long.parseLong(tmp[0]);
        long m = Long.parseLong(tmp[1]);

        int answer = Math.min((count2(n)-count2(n-m)-count2(m)),(count5(n)-count5(n-m)-count5(m)));
        System.out.println(answer);
    }
}
