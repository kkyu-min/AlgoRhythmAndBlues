import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] arr = new int[1001];

    static int gcd(int a, int b) {
        int tmp;
        while(b!=0) {
            tmp = b;
            b=a%b;
            a=tmp;
        }

        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        arr[1] = 3;
        for(int i=2;i<=1000;i++) {
            int count = 0;
            for(int j=1;j<i;j++) {
                if(gcd(i,j) == 1) {
                    count++;
                }
            }
            arr[i] = 2*count + arr[i-1];
        }

        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(arr[n]).append("\n");
        }
        System.out.println(sb);
    }
}
