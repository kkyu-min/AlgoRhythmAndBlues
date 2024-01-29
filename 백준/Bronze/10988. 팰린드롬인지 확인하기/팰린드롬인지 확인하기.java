import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split("");

        for(int i=0;i<tmp.length/2;i++) {
            if(!tmp[i].equals(tmp[tmp.length-1-i])) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }
}
