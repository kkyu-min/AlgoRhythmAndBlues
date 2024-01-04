import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

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
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        String[] tmp = br.readLine().split(" ");

//        a = Long.parseLong(tmp[0]);
//        d = Long.parseLong(tmp[1]);
        a = scanner.nextLong();
        d = scanner.nextLong();

//        long q = Long.parseLong(br.readLine());
        long q = scanner.nextLong();

        for(int i=0;i<q;i++) {
//            tmp = br.readLine().split(" ");
//            int con = Integer.parseInt(tmp[0]);
//            long l = Long.parseLong(tmp[1]);
//            long r = Long.parseLong(tmp[2]);
            int con = scanner.nextInt();
            long l = scanner.nextLong();
            long r = scanner.nextLong();

            if(con == 1) { //
                long sum1 = (r * ((2*a) + (r-1)*d)) / 2;
                long sum2 = ((l-1) * ((2*a) + (l-2)*d)) / 2;
//                System.out.println(sum1-sum2);
                String s = String.valueOf(sum1-sum2);
                bw.write(s);
                bw.newLine();
            }
            else { // 최대공약수
                if(l==r) {
//                    System.out.println(a+(l-1)*d);
                    String s = String.valueOf(a+(l-1)*d);
                    bw.write(s);
                    bw.newLine();
                }
                else{
//                    System.out.println(gcd(a,d));
                    String s = String.valueOf(gcd(a,d));
                    bw.write(s);
                    bw.newLine();
                }
            }
        }
        bw.close();
    }
}
