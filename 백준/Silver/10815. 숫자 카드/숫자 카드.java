import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split(" ");

        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(tmp[i]);
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        tmp = br.readLine().split(" ");

        for(int t=0;t<m;t++) {
            int num = Integer.parseInt(tmp[t]);
            boolean check = false;

            int start= 0;
            int end = n-1;
            while(start <= end) {
                int mid = (start + end)/2;

                if(arr[mid] == num){
                    check = true;
                    break;
                }
                else if(arr[mid] < num) {
                    start= mid+1;
                }
                else {
                    end = mid-1;
                }
            }
            if(check) sb.append(1).append(" ");
            else sb.append(0).append(" ");
        }

        System.out.println(sb);
    }
}
