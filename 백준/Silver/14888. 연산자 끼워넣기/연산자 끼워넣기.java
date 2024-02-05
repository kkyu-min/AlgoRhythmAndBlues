import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[] arr;
    static int[] operator = new int[4];
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    static void recur(int cur, int res) { // 사용한 연산자 수, 연산자 순서
        if(cur==n-1){
            min = Math.min(min, res);
            max = Math.max(max, res);
            return;
        }

        for(int i=0;i<4;i++) {
            if(operator[i] > 0) {
                operator[i]--;
                if(i==0) {
                    recur(cur+1, res+arr[cur+1]);
                }
                else if(i==1) {
                    recur(cur+1, res-arr[cur+1]);
                }
                else if(i==2) {
                    recur(cur+1, res*arr[cur+1]);
                }
                else {
                    recur(cur+1, res/arr[cur+1]);
                }
                operator[i]++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        String[] tmp = br.readLine().split(" ");
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(tmp[i]);
        }

        tmp = br.readLine().split(" ");
        for(int i=0;i<4;i++) {
            operator[i] = Integer.parseInt(tmp[i]);
        }

        recur(0,arr[0]);
        System.out.println(max);
        System.out.println(min);
    }
}
