import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n,m;
    static boolean[][] info;
    static int[] answer = new int[2];
    static void recur(int cur, int guitar, int[] song) {
        if(cur == n) {
            int cnt = 0;
            for(int i=1;i<m+1;i++) {
                if(song[i]>=1) cnt++;
            }
            if(cnt>=answer[1] && guitar<=answer[0]){
                answer[0] = guitar;
                answer[1] = cnt;
            }
            return;
        }

        // 고르는 경우
        for(int i=1;i<m+1;i++) {
            if(info[cur][i]) {
                song[i]++;
            }
        }
        recur(cur+1, guitar+1, song);
        // 고르지 않는 경우
        for(int i=1;i<m+1;i++) {
            if(info[cur][i]) {
                song[i]--;
            }
        }
        recur(cur+1, guitar, song);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);

        info = new boolean[n][m+1];
        answer[0] = Integer.MAX_VALUE;
        answer[1] = Integer.MIN_VALUE;

        for(int i=0;i<n;i++) {
            tmp = br.readLine().split(" ");
            for(int j=0;j<tmp[1].length();j++) {
                if(tmp[1].charAt(j) == 'Y'){
                    info[i][j+1] = true;
                }
                else info[i][j+1] = false;
            }
        }

        int[] song = new int[m+1];
        recur(0,0,song);

        if(answer[0]>0 && answer[1]>0) {
            System.out.println(answer[0]);
        }
        else System.out.println(-1);
    }
}
