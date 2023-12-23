import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++) {
            String[] tmp = br.readLine().split(" ");

            sum-=Integer.parseInt(tmp[0])*Integer.parseInt(tmp[1]);
        }
        if(sum==0) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}
