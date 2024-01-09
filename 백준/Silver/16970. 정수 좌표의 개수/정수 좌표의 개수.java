import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n,m,k;
    static int gcd(int a, int b){
        while(b!=0) {
            int tmp = b;
            b = a%b;
            a = tmp;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");

        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);
        k = Integer.parseInt(tmp[2]);

        int answer = 0;
        for(int x1=0;x1<=n;x1++) {
            for(int y1=0;y1<=m;y1++) {
                for(int x2=0;x2<=n;x2++) {
                    for(int y2=0;y2<=m;y2++) {
                        if(gcd(Math.abs(x2-x1), Math.abs(y2-y1))+1 == k) answer++;
                    }
                }
            }
        }
        System.out.println(answer/2);
    }
}
