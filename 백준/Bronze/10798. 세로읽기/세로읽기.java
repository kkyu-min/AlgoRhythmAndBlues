import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[][] arr = new String[5][15];

        for(int i=0;i<5;i++) {
            String[] tmp = br.readLine().split("");
            for(int j=0;j<tmp.length;j++) {
                arr[i][j] = tmp[j];
            }
        }

        for(int j=0;j<15;j++) {
            for(int i=0;i<5;i++) {
                if(!(arr[i][j] == null)) {
                    sb.append(arr[i][j]);
                }
            }
        }
        System.out.println(sb);
    }
}
