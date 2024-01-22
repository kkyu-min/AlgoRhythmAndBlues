import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        int n= Integer.parseInt(tmp[0]);
        int m= Integer.parseInt(tmp[1]);

        int[] arr = new int[n];

        tmp = br.readLine().split(" ");
        for(int i=0;i<n;i++) {
            arr[i] =Integer.parseInt(tmp[i]);
        }

        int start = 0;
        int end = 0;
        int total = 0;
        int answer = 0;

        while(end <= n) {
            if(total == m) {
                answer++;
                total-=arr[start];
                start++;
            }
            else if(total > m) {
                total-=arr[start];
                start++;
            }
            else {
                if(end==n) break;
                total+=arr[end];
                end++;
            }

//            System.out.println(answer + " " + total + " " + start + " " + end);
        }
        System.out.println(answer);
    }
}
