import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        int k = Integer.parseInt(tmp[2]);

        int answer = 0;

        while(true) {
            // 조건 확인
            if(n >= 2 && m >=1) {
                if(n+m-3 >= k) {
                    n-=2;
                    m-=1;
                    answer++;
                }
                else break;
            }
            else break;
        }
        System.out.println(answer);
    }
}
