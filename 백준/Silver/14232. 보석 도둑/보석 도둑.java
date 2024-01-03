import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long k = Long.parseLong(br.readLine());
        long answer = 0;

        for(long i=2; i*i<=k; i++){
            if(k%i == 0) {
                answer++;
                sb.append(i).append(" ");
                k/=i;
                i--;
            }
        }
        if(k>1){
            answer++;
            sb.append(k);
        }

        System.out.println(answer);
        System.out.println(sb);
    }
}
