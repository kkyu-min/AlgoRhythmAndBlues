import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[] arr;
    static int max, zeroCount, sum, answer;

    static boolean check(int num) {
        int total = 0;
        for(int i=0;i<n;i++) {
            if(total > num) return false;
            total+=arr[i];
            if(total==num)total=0;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++) {
            n = Integer.parseInt(br.readLine());
            arr= new int[n];

            String[] tmp = br.readLine().split(" ");
            max = 0;
            zeroCount = 0;
            sum = 0;

            for(int i=0;i<n;i++){
                arr[i] = Integer.parseInt(tmp[i]);

                if(max < arr[i]) max=arr[i];
                if(arr[i]==0) zeroCount++;
                sum+=arr[i];
            }
            answer = 0;
            if(max==0) sb.append(0).append("\n");
            else {
                for(int i=max;i<=sum;i++) {
                    if(sum%i==0 && check(i)) {
                        answer = n -(sum/i);
                        break;
                    }
                }
                sb.append(answer).append("\n");
            }
        }
        System.out.println(sb);
    }
}
