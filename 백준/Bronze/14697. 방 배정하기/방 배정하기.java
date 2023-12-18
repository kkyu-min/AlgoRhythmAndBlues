import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        int x = Integer.parseInt(tmp[0]);
        int y = Integer.parseInt(tmp[1]);
        int z = Integer.parseInt(tmp[2]);
        int n = Integer.parseInt(tmp[3]);
        boolean answer = false;

        for(int i=0;i<301;i++) {
            for(int j=0;j<301;j++) {
                for(int k=0;k<301;k++) {
                    if((x*i + y*j + z*k)==n) answer=true;
                }
            }
        }
        if (answer) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
