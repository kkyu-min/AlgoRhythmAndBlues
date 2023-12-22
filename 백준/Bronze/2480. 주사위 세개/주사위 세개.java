import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        int[] arr = new int[7];

        for(int i=0;i<3;i++) {
            arr[Integer.parseInt(tmp[i])]++;
        }

        int max = 0;
        int cnt = 0;
        for(int i=1;i<7;i++) {
            if(arr[i]>=max)  {
                max = arr[i];
                cnt = i;
            }
        }

        if(max == 1) {
            System.out.println(cnt * 100);
        }
        else if(max == 2) {
            System.out.println(1000 + cnt*100);
        }
        else {
            System.out.println(10000 + 1000*cnt);
        }
    }
}
