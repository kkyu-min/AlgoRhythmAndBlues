import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int calc(int start, int end) {
        return end*end - start*start;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int g = Integer.parseInt(br.readLine());

        int start = 1;
        int end = 1;
        int cnt = 0;

        while(true) {
            if(end-start==1 && calc(start, end) > g) {
                break;
            }
            if(calc(start, end) == g) {
                cnt++;
                sb.append(end).append("\n");
                start++;
                end++;
            }
            else if(calc(start, end) < g) {
                end++;
            }
            else{
                start++;
            }
        }

        if (cnt == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }
}
