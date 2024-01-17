import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] arr = new boolean[31];

        for(int t=0;t<28;t++) {
            int n = Integer.parseInt(br.readLine());
            arr[n]=true;
        }
        for(int i=1;i<31;i++) {
            if (!arr[i]) {
                System.out.println(i);
            }
        }

    }
}
