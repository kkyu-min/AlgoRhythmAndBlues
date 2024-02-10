import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n,m,k;
//    static int[] skill;
    static int[][] quest;
    static int answer = Integer.MIN_VALUE;

    static void recur(int cur, int cnt, boolean[] skill) {
        if(cur == 2*n+1) {
            if(cnt==n) {
                answer = Math.max(answer, calc(skill));
            }
            return;
        }

        // 고르는 경우
        skill[cur] = true;
        recur(cur+1, cnt+1, skill);
        // 고르지 않는 경우
        skill[cur] = false;
        recur(cur+1, cnt, skill);
    }

    static int calc(boolean[] skill) {
        int sum = 0;

        for(int i=0;i<m;i++) {
            boolean check = true;
            for(int j=0;j<k;j++) {
                if(!skill[quest[i][j]]) {
                    check = false;
                    break;
                }
            }
            if(check) sum++;
        }
        return sum;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");

        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);
        k = Integer.parseInt(tmp[2]);

        quest = new int[m][k];

        for(int i=0;i<m;i++) {
            tmp = br.readLine().split(" ");
            for(int j=0;j<k;j++) {
                quest[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        boolean[] skill =  new boolean[2*n+1];

        recur(0,0,skill);

        System.out.println(answer);
    }
}
