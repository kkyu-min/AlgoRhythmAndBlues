import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

    static int n,m;
    static int answer;
    static boolean[] number = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        if(m!=0) {
            String[] tmp = br.readLine().split(" ");

            for (String s : tmp) {
                number[Integer.parseInt(s)] = true;
            }
        }

        answer = Math.abs(n - 100); // 100에서 + - 로 이동횟수

        // 숫자 만들고, + - 로 이동 횟수
        for(int i=0;i<900002;i++) {
            String str = String.valueOf(i);

            boolean check = true;
            for(int j=0;j<str.length();j++) {
                if(number[str.charAt(j) - '0']) {
                    check = false;
                    break;
                }
            }
            if(check) {
                answer = Math.min(answer, str.length()+Math.abs(n-i));
            }
        }

        System.out.println(answer);
    }
}
