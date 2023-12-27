import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        int[] arr = new int[5];
        for(int i=0;i<5;i++) {
            arr[i] = Integer.parseInt(tmp[i]);
        }

        for(int i=1;i<1000001;i++) {
            int cnt = 0;
            for(int j=0;j<5;j++) {
                if(i%arr[j]==0) cnt++;
            }
            if(cnt>=3){
                System.out.println(i);
                break;
            }
        }

    }

}
