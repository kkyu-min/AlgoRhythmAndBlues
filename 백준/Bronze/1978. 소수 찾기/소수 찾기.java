import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] arr = new boolean[1001];
        arr[1] = true;

        for(int i=2;i*i<=1000;i++) {
            for(int j=i*i;j<1001;j+=i) {
                arr[j] = true;
            }
        }

        int n = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split(" ");

        int answer = 0;
        for(int i=0;i<tmp.length;i++){
            if(!arr[Integer.parseInt(tmp[i])]) answer++;
        }

        System.out.println(answer);
    }
}
