import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N,K;
    static int[][] stats;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        N = Integer.parseInt(tmp[0]);
        K = Integer.parseInt(tmp[1]);
        stats = new int[N][3];
        int answer = Integer.MAX_VALUE;

        for(int i=0;i<N;i++) {
            tmp = br.readLine().split(" ");
            stats[i][0] = Integer.parseInt(tmp[0]);
            stats[i][1] = Integer.parseInt(tmp[1]);
            stats[i][2] = Integer.parseInt(tmp[2]);
        }

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                for(int k=0;k<N;k++) {
                    int cnt = 0;
                    for(int n=0;n<N;n++) {
                        if(stats[i][0] >= stats[n][0] && stats[j][1] >= stats[n][1] && stats[k][2] >= stats[n][2]) {
                            cnt++;
                        }
                    }

                    if(cnt >= K) {
                        answer = Math.min(answer, stats[i][0] + stats[j][1] + stats[k][2]);
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
