import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static long k;
    static boolean check;
    static long cnt;
    static String answer;

    static void recur(int sum, String str) {
        if(sum==n) {
            cnt++;
            if(cnt==k) {
                answer = str;
                check=true;
                return;
            }
        }
        else if(sum>n){
            return;
        }
        for(int i=1;i<4;i++) {
            recur(sum+i,str+i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] tmp = br.readLine().split(" ");

        n = Integer.parseInt(tmp[0]);
        k = Long.parseLong(tmp[1]);

        recur(0,"");
        if(check) {
            for(int i=0;i<answer.length();i++) {
                sb.append(answer.charAt(i)).append("+");
            }
            sb.deleteCharAt(2*answer.length()-1);
            System.out.println(sb);
        }

        else System.out.println(-1);
    }
}
