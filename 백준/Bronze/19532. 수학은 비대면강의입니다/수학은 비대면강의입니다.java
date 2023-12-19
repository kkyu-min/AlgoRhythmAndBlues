import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        int a = Integer.parseInt(tmp[0]);
        int b = Integer.parseInt(tmp[1]);
        int c = Integer.parseInt(tmp[2]);
        int d = Integer.parseInt(tmp[3]);
        int e = Integer.parseInt(tmp[4]);
        int f = Integer.parseInt(tmp[5]);


        for(int x=-999;x<1000;x++) {
            for(int y=-999;y<1000;y++) {
                if((a*x+b*y == c) && (d*x+e*y==f)) {
                    System.out.println(x + " " + y);
                    return;
                }
            }
        }
    }
}
