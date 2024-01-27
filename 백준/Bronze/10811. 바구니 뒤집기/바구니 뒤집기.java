import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] tmp = br.readLine().split(" ");

        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);

        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = i+1;
        }

        for(int i=0;i<m;i++) {
            tmp = br.readLine().split(" ");

            int left = Integer.parseInt(tmp[0])-1;
            int right = Integer.parseInt(tmp[1])-1;

            while(left < right) {
                int num = arr[left];
                arr[left++] = arr[right];
                arr[right--] = num;
            }
        }

        for(int i=0;i<n;i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
}
