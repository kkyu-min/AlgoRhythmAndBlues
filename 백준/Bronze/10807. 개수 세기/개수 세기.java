import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int answer = 0;

        String[] tmp = br.readLine().split(" ");
        int num = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++) {
            if(num == Integer.parseInt(tmp[i])) answer++;
        }

        System.out.println(answer);
    }
}
