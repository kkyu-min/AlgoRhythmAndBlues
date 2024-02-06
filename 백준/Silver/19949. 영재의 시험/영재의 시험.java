import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] arr;
    static int answer;

    static void recur(int cur, int[] selected) {
        if(cur==10) {
            int cnt = 0;
            for(int i=0;i<10;i++) {
                if(selected[i]==arr[i]) cnt++;
            }
            if(cnt>=5) answer++;
            return;
        }

        // 연속2개인지 확인
        int over = 6;
        if(cur>=2) {
            if(selected[cur-1]==selected[cur-2]) over= selected[cur-1];
        }

        for(int i=1;i<6;i++) {
            if(over!=i) {
                selected[cur] = i;
                recur(cur+1, selected);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        arr = new int[10];
        for(int i=0;i<10;i++) {
            arr[i] = Integer.parseInt(tmp[i]);
        }

        int[] selected = new int[10];
        recur(0,selected);

        System.out.println(answer);
    }
}
