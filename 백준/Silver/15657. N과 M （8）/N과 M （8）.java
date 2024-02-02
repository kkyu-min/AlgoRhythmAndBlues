import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n,m;
    static int[] arr;
    static int[] nums;
    static StringBuilder sb = new StringBuilder();

    static void recur(int cur,int start) {
        if(cur == m) {
            for(int i=0;i<m;i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=start;i<n;i++) {
            arr[cur] = nums[i];
            recur(cur+1,i);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");

        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);

        arr = new int[m];
        nums = new int[n];

        tmp = br.readLine().split(" ");
        for(int i=0;i<n;i++) {
            nums[i] = Integer.parseInt(tmp[i]);
        }
        Arrays.sort(nums);

        recur(0,0);
        System.out.println(sb);
    }
}
