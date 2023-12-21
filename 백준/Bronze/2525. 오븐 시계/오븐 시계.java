import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        int[] now = new int[2];

        now[0] = Integer.parseInt(tmp[0]);
        now[1] = Integer.parseInt(tmp[1]);

        int time = Integer.parseInt(br.readLine());

        int hour = time/60;
        int minute = time%60;

        now[0]+=hour;
        now[1]+=minute;

        if(now[1]>=60) {
            now[0] +=1;
            now[1]%=60;
        }

        while(now[0]>23) {
            now[0]-=24;
        }

        System.out.println(now[0] + " " + now[1]);
    }
}
