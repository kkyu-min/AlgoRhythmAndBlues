import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;

    static void recur(String str) {
        if(str.length() == n) {
            System.out.println(str);
            System.exit(0);
            return;
        }
        for(int i=1;i<4;i++) {
            if(check(str+i)) recur(str+i);
        }
    }

    static boolean check(String str) {
        for(int i=1;i<=str.length()/2;i++) {
            String front = str.substring(str.length()-2*i, str.length()-i);
            String back = str.substring(str.length()-i, str.length());
            if(front.equals(back)) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        recur("");
    }
}
