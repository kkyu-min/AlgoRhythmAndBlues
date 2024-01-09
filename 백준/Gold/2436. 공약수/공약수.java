import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long check(long a, long b) {
        while(b!=0){
            long tmp = b;
            b = a%b;
            a = tmp;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");

        long gcd = Long.parseLong(tmp[0]);
        long lsb = Long.parseLong(tmp[1]);

        lsb/=gcd;

        long num1 = 0;
        long num2 = 0;
        long[] ans = new long[2];

        long sum = Long.MAX_VALUE;

        for(long i=1;i*i<=lsb;i++) {
            long answer1 = gcd;
            long answer2 = gcd;
            if(lsb%i==0) {
                num1 = i;
                num2 =lsb/num1;
                answer1*=num1;
                answer2*=num2;
                if(check(answer1,answer2)==gcd) {
                    if(answer1 + answer2 <= sum) {
                        sum = answer1 + answer2;
                        ans[0] = answer1;
                        ans[1] = answer2;
                    }
                }
            }
        }

        if(ans[0]<ans[1]) {
            System.out.println(ans[0] + " "+ans[1]);
        }
        else {
            System.out.println(ans[0] + " "+ans[1]);
        }
    }
}
